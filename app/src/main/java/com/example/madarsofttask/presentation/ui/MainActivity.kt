package com.example.madarsofttask.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.madarsofttask.R
import com.example.madarsofttask.data.local.entity.User
import com.example.madarsofttask.databinding.ActivityMainBinding
import com.example.madarsofttask.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val viewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareGenderSpinner()
        handleSaveUserButton()
        observeInsertedUserValue()
    }

    private fun saveUserData(user:User){
        viewModel.saveUser(user)
    }

    private fun prepareGenderSpinner() {
        val genderOptions = arrayOf("Male", "Female")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, genderOptions)
       binding.autoCompleteGender.setAdapter(adapter)
        binding.autoCompleteGender.setOnClickListener {
            binding.autoCompleteGender.showDropDown()
        }
    }
    private fun handleSaveUserButton(){
        binding.btnSave.setOnClickListener {
            val user = User(
                name = binding.editTextName.text.toString(),
                age = if(binding.editTextAge.text?.toString()!!.isEmpty()){
                    0
                }else{
                    binding.editTextAge.text?.toString()?.toInt()
                },
                jobTitle = binding.editTextJob.text.toString(),
                gender = binding.autoCompleteGender.text.toString()
            )
            Log.d(TAG, "handleSaveUserButton: "+user)
            saveUserData(user)
        }
    }

    private fun observeInsertedUserValue(){
        lifecycleScope.launchWhenStarted {
            viewModel.insertStatus.collect { success ->
                success?.let {
                    if (it) {
                        Toast.makeText(this@MainActivity, "User Added!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity,UserDataActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@MainActivity, "Insert Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
