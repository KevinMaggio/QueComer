package com.example.quecomer.data.repository

import com.example.quecomer.data.RecetaService
import com.example.quecomer.data.model.RecetaResponse
import javax.inject.Inject

class RecetasRepository @Inject constructor(val recetaService: RecetaService){

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