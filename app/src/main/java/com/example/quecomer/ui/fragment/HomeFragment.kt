package com.example.quecomer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quecomer.R
import com.example.quecomer.databinding.FragmentHomeBinding
import com.example.quecomer.ui.adapter.RecipeAdapter
import com.example.quecomer.utils.State
import com.example.quecomer.viewModel.RecipeViewModel

class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    private val recipeViewModel by viewModels<RecipeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeBinding.inflate(inflater, container, false)


//        binding.svSearch.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (!query.isNullOrEmpty()){
//                    recipeViewModel.getRecipe(binding.svSearch.query.toString())
//                }
//                return false
//            }
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//        })

        recipeViewModel.getRecipes().observe(viewLifecycleOwner,{
            controlState(it.status)

            initReciclerView(it.data)
        })


        return binding.root
    }

    private fun initReciclerView(list: List<String>){
        val adapter = RecipeAdapter(list)
        adapter.setOnItemClickListener(object : RecipeAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val bundle = Bundle()
                bundle.putString("title", list[position])
                findNavController().navigate(R.id.action_nav_home_to_detailsRecipeFragment, bundle)
            }
        })
        binding.rvRecycler.adapter= adapter
    }

    private fun controlState(status: State) {
        when (status) {
            State.SUCCES -> {
                msgSucces()
                binding.loading.root.isVisible= false
            }

            State.LOADING -> { binding.loading.root.isVisible= true
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
}