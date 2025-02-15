package com.example.madarsofttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madarsofttask.data.local.entity.User
import com.example.madarsofttask.domain.usecase.GetUsersUseCase
import com.example.madarsofttask.domain.usecase.SaveUserUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val saveUserUseCase: SaveUserUseCase,
    private val getUsersUseCase: GetUsersUseCase
):ViewModel() {
    private val _insertStatus = MutableStateFlow<Boolean?>(null)
    val insertStatus: StateFlow<Boolean?> = _insertStatus.asStateFlow()
    private val _userStateFlow = MutableStateFlow<List<User>>(emptyList())
    val userStateFlow get() = _userStateFlow
    fun saveUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            val success = saveUserUseCase(user)
            _insertStatus.value = success
        }
    }

    fun getAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            _userStateFlow.value = getUsersUseCase()
        }
    }
}