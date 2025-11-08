package com.example.delishio

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MealAdapter(private val meals: List<Meal>) :
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMealName: TextView = itemView.findViewById(R.id.tvMealName)
        val tvMealCategory: TextView = itemView.findViewById(R.id.tvMealCategory)
        val tvMealDescription: TextView = itemView.findViewById(R.id.tvMealDescription)
        val imgMeal: ImageView = itemView.findViewById(R.id.imgMeal)
        val btnViewRecipe: Button = itemView.findViewById(R.id.btnViewRecipe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun getItemCount() = meals.size

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = meals[position]

        // Set text safely
        holder.tvMealName.text = meal.strMeal ?: "Unknown"
        holder.tvMealCategory.text = meal.strCategory ?: "No Category"
        holder.tvMealDescription.text = meal.strArea ?: "No Area"

        // Load image
        Glide.with(holder.itemView.context)
            .load(meal.strMealThumb)
            .into(holder.imgMeal)

        // On click → open DetailActivity
        holder.btnViewRecipe.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("mealName", meal.strMeal)
            intent.putExtra("mealImage", meal.strMealThumb)
            intent.putExtra("mealCategory", meal.strCategory)
            intent.putExtra("mealArea", meal.strArea)
            intent.putExtra("mealInstructions", meal.strInstructions)
            context.startActivity(intent)
        }
    }
}
