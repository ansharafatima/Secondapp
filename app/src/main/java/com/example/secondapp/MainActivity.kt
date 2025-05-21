package com.example.secondapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {


    private fun launchRecipeDetail(name: String, time: String, servings: String, calories: String, ingredients: String, steps: String) {
        val intent = Intent(this, RecipeDetailActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("time", time)
        intent.putExtra("servings", servings)
        intent.putExtra("calories", calories)
        intent.putExtra("ingredients", ingredients)
        intent.putExtra("steps", steps)
        startActivity(intent)

    }

    private fun showSettingsBottomSheet() {
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_settings, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(bottomSheetView)

        val editUsername = bottomSheetView.findViewById<EditText>(R.id.editUsername)
        val saveButton = bottomSheetView.findViewById<Button>(R.id.saveSettingsBtn)

        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val currentUsername = sharedPreferences.getString("USERNAME", "")

        editUsername.setText(currentUsername)

        saveButton.setOnClickListener {
            val newUsername = editUsername.text.toString().trim()

            sharedPreferences.edit().apply {
                putString("USERNAME", newUsername)
                apply()
            }
            dialog.dismiss()
            showCustomWelcomeDialog(newUsername)
        }

        dialog.show()
    }

    private fun showCustomWelcomeDialog(username: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_welcome, null)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        dialogView.startAnimation(fadeIn)

        val welcomeMessage = dialogView.findViewById<TextView>(R.id.welcomeMessage)
        val welcomeImage = dialogView.findViewById<ImageView>(R.id.welcomeImage)
        val okButton = dialogView.findViewById<Button>(R.id.welcomeOkButton)

        if (username.isNotEmpty()) {
            welcomeMessage.text = "Hello, $username! Ready to bake something sweet? 🍯"
        } else {
            welcomeMessage.text = "Welcome to Sweet Recipes! 🧁"
        }

        // Optional: Load cute gif or image using Glide
        Glide.with(this)
            .load(R.drawable.egggif)
            .into(welcomeImage)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        okButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val username = sharedPreferences.getString("USERNAME", "") ?: ""
        showCustomWelcomeDialog(username)

        findViewById<Button>(R.id.settingsButton).setOnClickListener {
            showSettingsBottomSheet()
        }



        // Chocolate Cake
        findViewById<ImageButton>(R.id.dessert1).setOnClickListener {
            launchRecipeDetail(
                "Chocolate Cake", "45 minutes", "8", "350",
                "2 cups flour\n1 cup sugar\n½ cup cocoa powder\n2 eggs\n1 cup milk",
                "1. Preheat oven to 180°C.\n2. Mix dry ingredients.\n3. Add eggs and milk.\n4. Pour into pan and bake for 30 mins."
            )
        }

        // Apple Pie
        findViewById<ImageButton>(R.id.dessert2).setOnClickListener {
            launchRecipeDetail(
                "Apple Pie", "60 minutes", "6", "400",
                "5 apples, sliced\n2 cups flour\n½ cup butter\n½ cup sugar\n1 tsp cinnamon",
                "1. Prepare crust.\n2. Mix apples with cinnamon.\n3. Fill crust and bake at 180°C for 45 mins."
            )
        }

        // Donuts
        findViewById<ImageButton>(R.id.dessert3).setOnClickListener {
            launchRecipeDetail(
                "Donuts", "30 minutes", "12", "250",
                "2 cups flour\n1 egg\n½ cup sugar\n1 tsp baking powder\nOil for frying",
                "1. Mix ingredients.\n2. Shape dough.\n3. Fry until golden brown."
            )
        }

        // Vanilla Cupcakes
        findViewById<ImageButton>(R.id.dessert4).setOnClickListener {
            launchRecipeDetail(
                "Vanilla Cupcakes", "25 minutes", "12", "200",
                "1½ cups flour\n1 cup sugar\n2 eggs\n1 tsp vanilla\n½ cup butter",
                "1. Mix ingredients.\n2. Pour into molds.\n3. Bake at 175°C for 20 mins."
            )
        }

        // Chocolate Chip Cookies
        findViewById<ImageButton>(R.id.dessert5).setOnClickListener {
            launchRecipeDetail(
                "Chocolate Chip Cookies", "20 minutes", "24", "150",
                "2 cups flour\n1 cup sugar\n1 cup chocolate chips\n1 egg\n1 tsp vanilla",
                "1. Mix ingredients.\n2. Scoop onto tray.\n3. Bake at 180°C for 10–12 mins."
            )
        }

        // Caramel Pudding
        findViewById<ImageButton>(R.id.dessert6).setOnClickListener {
            launchRecipeDetail(
                "Caramel Pudding", "50 minutes", "4", "300",
                "½ cup sugar\n2 eggs\n2 cups milk\n1 tsp vanilla",
                "1. Make caramel.\n2. Mix milk & eggs.\n3. Bake or steam in oven."
            )
        }

        // Strawberry Cheesecake
        findViewById<ImageButton>(R.id.dessert7).setOnClickListener {
            launchRecipeDetail(
                "Strawberry Cheesecake", "4 hours", "8", "420",
                "200g cream cheese\n½ cup sugar\n1 cup biscuits\n½ cup butter\nStrawberries",
                "1. Make crust.\n2. Mix filling.\n3. Chill and add topping."
            )
        }

        // Pancakes
        findViewById<ImageButton>(R.id.dessert8).setOnClickListener {
            launchRecipeDetail(
                "Pancakes", "15 minutes", "6", "180",
                "1 cup flour\n1 egg\n1 cup milk\n1 tbsp sugar",
                "1. Mix batter.\n2. Pour on pan.\n3. Flip and serve."
            )
        }

        // Brownies
        findViewById<ImageButton>(R.id.dessert9).setOnClickListener {
            launchRecipeDetail(
                "Brownies", "35 minutes", "9", "320",
                "1 cup chocolate\n1 cup flour\n1 cup sugar\n2 eggs\n½ cup butter",
                "1. Melt chocolate.\n2. Combine with flour and eggs.\n3. Bake at 180°C for 30 mins."
            )
        }

        // Cinnamon Rolls
        findViewById<ImageButton>(R.id.dessert10).setOnClickListener {
            launchRecipeDetail(
                "Cinnamon Rolls", "90 minutes", "8", "400",
                "2 cups flour\n½ cup sugar\n1 tsp cinnamon\n1 egg\n½ cup milk",
                "1. Make dough.\n2. Roll with filling.\n3. Bake at 180°C."
            )
        }


    }
}

