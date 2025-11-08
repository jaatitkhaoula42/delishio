package com.example.delishio

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvMealTitle = findViewById<TextView>(R.id.tvMealTitle)
        val tvMealCategory = findViewById<TextView>(R.id.tvMealCategory)
        val tvInstructions = findViewById<TextView>(R.id.tvInstructions)
        val imgMealDetail = findViewById<ImageView>(R.id.imgMealDetail)

        // get data from Intent
        val mealName = intent.getStringExtra("mealName")
        val mealCategory = intent.getStringExtra("mealCategory")
        val mealArea = intent.getStringExtra("mealArea")
        val mealInstructions = intent.getStringExtra("mealInstructions")
        val mealImage = intent.getStringExtra("mealImage")

        // display data safely
        tvMealTitle.text = mealName ?: "Unknown Meal"
        tvMealCategory.text = "${mealCategory ?: "Unknown"} • ${mealArea ?: "Unknown"}"
        tvInstructions.text = mealInstructions ?: "No instructions available"

        Glide.with(this)
            .load(mealImage)
            .into(imgMealDetail)
    }
}
