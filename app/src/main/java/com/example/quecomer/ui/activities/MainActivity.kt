package com.example.quecomer.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quecomer.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val GOOGLE_SIGN= 100
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btGoogle.setOnClickListener {

            generateGso()
        }

    }

    private fun generateGso(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("901117008744-nabsbvpr7a9g69f5v8aligopi09of27l.apps.googleusercontent.com")
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        startActivityForResult(googleSignInClient.signInIntent,GOOGLE_SIGN)
    }

    //conection whit Google Acount
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN){
            val tast = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val acount = tast.getResult(ApiException::class.java)
                if (acount != null) {
                    val credential = GoogleAuthProvider.getCredential(acount.idToken,null)
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this, acount.givenName, Toast.LENGTH_LONG).show()
                            startActivity(Intent(this,HomeActivity::class.java))
                        }else{
                            Toast.makeText(this, acount.givenName, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }catch (e: Exception){
                Toast.makeText(this, "Entro en Catch", Toast.LENGTH_LONG).show()
            }
        }
    }

}