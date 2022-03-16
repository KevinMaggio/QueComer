package com.example.quecomer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quecomer.databinding.FragmentRecipeBinding
import com.example.quecomer.utils.Dates
import com.example.quecomer.utils.State
import com.example.quecomer.viewModel.RecipeViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firestore.v1.Document

class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding
    val recipeViewModel by viewModels<RecipeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)


        binding.btAddRecipe.setOnClickListener {


            recipeViewModel.addRecipe(
                binding.etTitle.text.toString(), binding.etDescription.text.toString(),
                Dates.email, ""
            )
        }

        recipeViewModel.status.observe(viewLifecycleOwner, {
            controlState(it)
        })
        return binding.root
    }

    private fun controlState(status: State) {
        when (status) {
            State.SUCCES -> {
                clear()
                msgSucces()
            }

            State.LOADING -> {
            }

            State.ERROR -> {
                msgError()
            }
        }
    }

    private fun clear() {
        binding.etDescription.text.clear()
        binding.etTitle.text.clear()
        Dates.email = ""
    }

    private fun msgError(){
        Toast.makeText(context, "error en la carga", Toast.LENGTH_LONG).show()
    }
    private fun msgSucces(){
        Toast.makeText(context, "Carga Completa", Toast.LENGTH_LONG).show()
    }

}