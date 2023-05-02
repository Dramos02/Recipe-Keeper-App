package com.example.recipekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recipekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initialize this variable to be used in every btn
        var recipeName = ""
        var ingredientName = ""
        var instruction = ""
        var recipeArea = ""

        binding.btnAddRecipe.setOnClickListener(){
            //it will append the user's input in every click of the btn
            recipeName += binding.edtRecipeName.text.toString() + "\n"
            recipeArea = "Recipe Name: $recipeName\n\nIngredients:\n$ingredientName\n\nInstructions:\n$instruction"
            binding.edtRecipeArea.setText(recipeArea)
        }
        binding.btnAddIngredients.setOnClickListener(){
            //it will append the user's input in every click of the btn
            ingredientName += binding.edtIngredients.text.toString() + "\n"
            recipeArea = "Recipe Name: $recipeName\n\nIngredients:\n$ingredientName\n\nInstructions:\n$instruction"
            binding.edtRecipeArea.setText(recipeArea)
        }
        binding.btnAddInstructions.setOnClickListener(){
            //it will append the user's input in every click of the btn
            instruction += binding.edtInstructions.text.toString() + "\n"
            recipeArea = "Recipe Name: $recipeName\n\nIngredients:\n$ingredientName\n\nInstructions:\n$instruction"
            binding.edtRecipeArea.setText(recipeArea)
        }
        binding.btnClear.setOnClickListener {
            //.clear() function will delete/clear all the user's input then (="") for string it will be empty
            binding.edtRecipeName.text.clear()
            binding.edtIngredients.text.clear()
            binding.edtInstructions.text.clear()
            binding.edtRecipeArea.text = ""
            ingredientName = ""
            instruction = ""
            recipeName = ""
            recipeArea = ""
            Toast.makeText(applicationContext, "The field has been Cleared", Toast.LENGTH_SHORT).show()
        }
         binding.btnSaveRecipe.setOnClickListener {
             //this will check the every edittext if not empty then it will save user's input/the recipe will be keeped
            if(binding.edtRecipeName.text.toString().isNotEmpty() &&
                binding.edtIngredients.text.toString().isNotEmpty() &&
                binding.edtInstructions.text.toString().isNotEmpty()) {
                Toast.makeText(applicationContext, "Recipe Saved", Toast.LENGTH_SHORT).show()
            } else {
             //this will satisfy if the edittext is empty
                Toast.makeText(applicationContext, "Please complete all Required Information", Toast.LENGTH_SHORT).show()
            }
        }
        binding.txtTitle.text="Recipe Keeper By Dominic O.Ramos"

    }
}