package com.example.quecomer.repository

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quecomer.databinding.ActivityComidasBinding
import com.example.quecomer.model.data.RecetaResponse
import com.example.quecomer.model.recyclerView.RecetaAdapter

class RecetasRepository (){

    val listaRecetas :List<RecetaResponse> = listOf(

        RecetaResponse("Ensalada","to se tiene q comer muy frio y rico",0,"www.asdasd.com"),
        RecetaResponse("Asado","to se tiene q comer muy frio y rico",1,"www.asdasd.com"),
        RecetaResponse("Guiso de arroz","to se tiene q comer muy frio y rico",2,"www.asdasd.com"),
        RecetaResponse("Polenta con asado","to se tiene q comer muy frio y rico",3,"www.asdasd.com"),
        RecetaResponse("Enchiladas","to se tiene q comer muy frio y rico",4,"www.asdasd.com"),
        RecetaResponse("Fideos","to se tiene q comer muy frio y rico",5,"www.asdasd.com"),
        RecetaResponse("Pizza","to se tiene q comer muy frio y rico",6,"www.asdasd.com"),
        RecetaResponse("Chorizos a la pomarola con nuez moscada en grano","to se tiene q comer muy frio y rico",7,"www.asdasd.com"),
        RecetaResponse("Ensalada","to se tiene q comer muy frio y rico",0,"www.asdasd.com"),
        RecetaResponse("Asado","to se tiene q comer muy frio y rico",1,"www.asdasd.com"),
        RecetaResponse("Guiso de arroz","to se tiene q comer muy frio y rico",2,"www.asdasd.com"),
        RecetaResponse("Polenta con asado","to se tiene q comer muy frio y rico",3,"www.asdasd.com"),
        RecetaResponse("Enchiladas","to se tiene q comer muy frio y rico",4,"www.asdasd.com"),
        RecetaResponse("Fideos","to se tiene q comer muy frio y rico",5,"www.asdasd.com"),
        RecetaResponse("Pizza","to se tiene q comer muy frio y rico",6,"www.asdasd.com"),
        RecetaResponse("Chorizos a la pomarola con nuez moscada en grano","to se tiene q comer muy frio y rico",7,"www.asdasd.com")

    )
}