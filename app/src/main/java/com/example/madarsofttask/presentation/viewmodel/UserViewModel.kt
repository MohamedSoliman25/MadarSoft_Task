package com.example.madarsofttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madarsofttask.data.local.entity.User
import com.example.madarsofttask.domain.usecase.SaveUserUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val saveUserUseCase: SaveUserUseCase,
):ViewModel() {

    fun saveUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            saveUserUseCase(user)
        }
    }
}