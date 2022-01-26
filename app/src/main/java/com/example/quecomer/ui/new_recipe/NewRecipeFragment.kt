package com.example.quecomer.ui.new_recipe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quecomer.databinding.FragmentNewRecipeBinding
import com.example.quecomer.ui.home.HomeActivity


class NewRecipeFragment : Fragment() {
    private lateinit var binding:FragmentNewRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentNewRecipeBinding.inflate(inflater, container, false)



        binding.btCancel.setOnClickListener {
            startActivity(Intent(context, HomeActivity::class.java))
        }
        return binding.root
    }
}