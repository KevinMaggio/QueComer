package com.example.quecomer.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.quecomer.databinding.FragmentDetailsRecipeBinding
import com.example.quecomer.utils.State
import com.example.quecomer.viewModel.RecipeViewModel


class DetailsRecipeFragment : Fragment() {

    val recipeViewModel by viewModels<RecipeViewModel> ()
    lateinit var binding:FragmentDetailsRecipeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentDetailsRecipeBinding.inflate(inflater,container,false)


        recipeViewModel.getRecipe(getBundle()).observe(viewLifecycleOwner,{

            controlState(it.status)
        })

        return binding.root
    }

    private fun controlState(status: State) {
        when (status) {
            State.SUCCES -> {
                binding.image.text=recipeViewModel.getRecipe(getBundle()).value!!.data.image
                binding.tvAuthor.text= recipeViewModel.getRecipe(getBundle()).value!!.data.autor
                binding.tvDescription.text= recipeViewModel.getRecipe(getBundle()).value!!.data.description
                binding.tvTitle.text= recipeViewModel.getRecipe(getBundle()).value!!.data.title
                msgSucces()
            }

            State.LOADING -> {
            }

            State.ERROR -> {
                msgError()
            }
        }
    }
    private fun msgError(){
        Toast.makeText(context, "error en la carga", Toast.LENGTH_LONG).show()
    }
    private fun msgSucces(){
        Toast.makeText(context, "Carga Completa", Toast.LENGTH_LONG).show()
    }



    fun getBundle(): String {
        return arguments?.getString("title").toString()
    }
}