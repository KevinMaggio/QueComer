package com.example.quecomer.data.repository

import com.example.quecomer.data.RecipeService
import com.example.quecomer.data.model.RecipeResponseGet
import javax.inject.Inject

class RecipesRepository @Inject constructor(val recipeService: RecipeService){

    val listaRecipeGets :List<RecipeResponseGet> = listOf(

        RecipeResponseGet("Ensalada","to se tiene q comer muy frio y rico",0,"www.asdasd.com"),
        RecipeResponseGet("Asado","to se tiene q comer muy frio y rico",1,"www.asdasd.com"),
        RecipeResponseGet("Guiso de arroz","to se tiene q comer muy frio y rico",2,"www.asdasd.com"),
        RecipeResponseGet("Polenta con asado","to se tiene q comer muy frio y rico",3,"www.asdasd.com"),
        RecipeResponseGet("Enchiladas","to se tiene q comer muy frio y rico",4,"www.asdasd.com"),
        RecipeResponseGet("Fideos","to se tiene q comer muy frio y rico",5,"www.asdasd.com"),
        RecipeResponseGet("Pizza","to se tiene q comer muy frio y rico",6,"www.asdasd.com"),
        RecipeResponseGet("Chorizos a la pomarola con nuez moscada en grano","to se tiene q comer muy frio y rico",7,"www.asdasd.com"),
        RecipeResponseGet("Ensalada","to se tiene q comer muy frio y rico",0,"www.asdasd.com"),
        RecipeResponseGet("Asado","to se tiene q comer muy frio y rico",1,"www.asdasd.com"),
        RecipeResponseGet("Guiso de arroz","to se tiene q comer muy frio y rico",2,"www.asdasd.com"),
        RecipeResponseGet("Polenta con asado","to se tiene q comer muy frio y rico",3,"www.asdasd.com"),
        RecipeResponseGet("Enchiladas","to se tiene q comer muy frio y rico",4,"www.asdasd.com"),
        RecipeResponseGet("Fideos","to se tiene q comer muy frio y rico",5,"www.asdasd.com"),
        RecipeResponseGet("Pizza","to se tiene q comer muy frio y rico",6,"www.asdasd.com"),
        RecipeResponseGet("Chorizos a la pomarola con nuez moscada en grano","to se tiene q comer muy frio y rico",7,"www.asdasd.com")

    )
}