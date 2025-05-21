package com.example.secondapp


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val name = intent.getStringExtra("name")
        val time = intent.getStringExtra("time")
        val servings = intent.getStringExtra("servings")
        val calories = intent.getStringExtra("calories")
        val ingredients = intent.getStringExtra("ingredients")
        val steps = intent.getStringExtra("steps")

        findViewById<TextView>(R.id.recipeName).text = name
        findViewById<TextView>(R.id.recipeTime).text = "Time: $time"
        findViewById<TextView>(R.id.recipeServings).text = "Servings: $servings"
        findViewById<TextView>(R.id.recipeCalories).text = "Calories: $calories"
        findViewById<TextView>(R.id.recipeIngredients).text = "Ingredients:\n$ingredients"
        findViewById<TextView>(R.id.recipeSteps).text = "Steps:\n$steps"

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

    }
}
