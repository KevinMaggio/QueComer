package com.example.quecomer.ui.register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.quecomer.databinding.ActivityRegisterBinding
import com.example.quecomer.ui.login.LoginActivity
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private val registerViewModel by viewModels<RegisterViewModel>()
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //observe login form state to catch errors
        registerViewModel.registerFormState.observe(this, Observer {
            val registerState = it ?: return@Observer

            // disable login button unless fields are valid
            binding.btRegister.isEnabled = registerState.isDataValid

            if (registerState.emailError != null) {
                binding.itEmail.error = getString(registerState.emailError)
            }
            binding.tfPassword.error =if (registerState.passwordError != null) {
                 getString(registerState.passwordError)
            }     else {
                null
            }
            binding.tfConfirmPassword.error =if (registerState.confirmedPasswordError != null) {
                getString(registerState.confirmedPasswordError)
            }     else {
                null
            }
        })
        binding.btRegister.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.btCancel.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        binding.itEmail.afterTextChanged {
            registerViewModel.loginDataChanged(
                binding.itEmail.text.toString(),
                binding.itPassword.text.toString(),
                binding.itName.text.toString(),
                binding.itSurname.text.toString(),
                binding.itConfirmePassword.text.toString(),
                binding.query.text.toString()
            )
        }

        binding.itPassword.afterTextChanged {
            registerViewModel.loginDataChanged(
                binding.itEmail.text.toString(),
                binding.itPassword.text.toString(),
                binding.itName.text.toString(),
                binding.itSurname.text.toString(),
                binding.itConfirmePassword.text.toString(),
                binding.query.text.toString()
            )
        }
        binding.itSurname.afterTextChanged {
            registerViewModel.loginDataChanged(
                binding.itEmail.text.toString(),
                binding.itPassword.text.toString(),
                binding.itName.text.toString(),
                binding.itSurname.text.toString(),
                binding.itConfirmePassword.text.toString(),
                binding.query.text.toString()
            )
        }
        binding.itConfirmePassword.afterTextChanged {
            registerViewModel.loginDataChanged(
                binding.itEmail.text.toString(),
                binding.itPassword.text.toString(),
                binding.itName.text.toString(),
                binding.itSurname.text.toString(),
                binding.itConfirmePassword.text.toString(),
                binding.query.text.toString()
            )
        }
        binding.query.afterTextChanged {
            registerViewModel.loginDataChanged(
                binding.itEmail.text.toString(),
                binding.itPassword.text.toString(),
                binding.itName.text.toString(),
                binding.itSurname.text.toString(),
                binding.itConfirmePassword.text.toString(),
                binding.query.text.toString()
            )
        }
        binding.itName.afterTextChanged {
            registerViewModel.loginDataChanged(
                binding.itEmail.text.toString(),
                binding.itPassword.text.toString(),
                binding.itName.text.toString(),
                binding.itSurname.text.toString(),
                binding.itConfirmePassword.text.toString(),
                binding.query.text.toString()
            )
        }
        binding.btRegister.setOnClickListener {
            registerViewModel.register(
                binding.itName.text?.toString() ?: "",
                binding.itPassword.text?.toString() ?: "",
                binding.itEmail.text?.toString() ?: ""
            )
        }





/*
        fun removeFieldsErrors() {
            binding.itPassword.afterTextChanged {
                binding.itPassword.error = null
                binding.itEmail.error = null
            }

            binding.itEmail.afterTextChanged {
                binding.itPassword.error = null
                binding.itEmail.error = null
            }
        }

        registerViewModel.registerResponse.observe(this, Observer {
            when (it.status) {
                Resource.Status.LOADING -> {
                }
                Resource.Status.SUCCESS -> {
                    Toast.makeText(this, "User created", Toast.LENGTH_LONG).show()
                }
                Resource.Status.ERROR -> {

                    binding.itEmail.error = " "
                    binding.itPassword.error = " "
                    //remove all fields error after modifying any field
                    removeFieldsErrors()
                }
            }
        })*/

    }

    private fun TextInputEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}