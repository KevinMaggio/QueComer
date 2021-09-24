package com.example.quecomer.ui.register

import android.util.Patterns
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quecomer.R
import com.example.quecomer.data.repository.RegisterRepository
import java.util.regex.Pattern

class RegisterViewModel @ViewModelInject constructor(private val registerRepository: RegisterRepository):ViewModel() {
    private val _registerForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _registerForm

    private val _registerResponse = MutableLiveData<String>()
    val registerResponse: LiveData<String> = _registerResponse

    fun loginDataChanged(email: String, password: String, name:String, surname:String,confirmePasword:String, query:String) {
        if (!isEmailValid(email)) {
            _registerForm.value = RegisterFormState(emailError = R.string.email_error)
        } else if (!isPasswordValid(password)) {
            _registerForm.value = RegisterFormState(passwordError = R.string.password_error)
        } else if (name.isEmpty()||surname.isEmpty()||query.isEmpty()||confirmePasword.isEmpty()) {
        }else if (!passwordsMatch(password,confirmePasword)){
            _registerForm.value= RegisterFormState(confirmedPasswordError = R.string.password_error)
        }else{
            _registerForm.value = RegisterFormState(isDataValid = true)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isPasswordValid(password: String): Boolean {
        val PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[a-zA-Z]).{8,}\$"
        val pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }
    private fun passwordsMatch(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

   /* fun register(name:String,password: String, email: String) = viewModelScope.launch(Dispatchers.Main) {
        val result = withContext(Dispatchers.IO) {
            registerRepository.register(name,email,password)
        }
        _registerResponse.value = result
    }*/
    fun register(name: String,password: String,email: String){
            _registerResponse.value="true"
    }
}