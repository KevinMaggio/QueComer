package com.example.quecomer.ui.new_recipe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quecomer.R
import com.example.quecomer.databinding.FragmentNewRecipeBinding
import com.example.quecomer.ui.login.LoginActivity


class NewRecipeFragment : Fragment() {
    private lateinit var binding:FragmentNewRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentNewRecipeBinding.inflate(inflater, container, false)



        binding.btCancel.setOnClickListener {
            startActivity(Intent(context,LoginActivity::class.java))
        }
        return binding.root
    }
}