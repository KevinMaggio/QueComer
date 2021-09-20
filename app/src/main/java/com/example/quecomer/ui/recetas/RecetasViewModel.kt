package com.example.quecomer.ui.recetas

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quecomer.data.model.RecetaResponse
import com.example.quecomer.data.repository.RecetasRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.annotation.Resource

class RecetasViewModel @ViewModelInject constructor( val recetasRepository: RecetasRepository) :
    ViewModel() {

 fun getLista(): List<RecetaResponse> {
     return recetasRepository.listaRecetas
 }
}