package com.example.madarsofttask.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madarsofttask.R
import com.example.madarsofttask.databinding.ActivityUserDataBinding
import com.example.madarsofttask.presentation.adapter.UserAdapter
import com.example.madarsofttask.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserDataBinding
    private val userViewModel: UserViewModel by viewModels<UserViewModel>()
    private  val TAG = "UserDataActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        getAllUsers()
        observeAllUsers()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@UserDataActivity)
            adapter = UserAdapter(ArrayList())
        }
    }

    private fun getAllUsers() = userViewModel.getAllUsers()

    private fun getUserLisAdapter() =
        binding.recyclerView.adapter as? UserAdapter

    private fun observeAllUsers() {
        lifecycleScope.launchWhenStarted {
            userViewModel.userStateFlow.collect { userList ->
                Log.d(TAG, "observeAllUsersMoo: "+userList)
                getUserLisAdapter()?.updateData(userList)
            }
        }
    }
}