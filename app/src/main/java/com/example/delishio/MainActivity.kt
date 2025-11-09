package com.example.delishio

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val allMeals = ArrayList<Meal>()
    private val displayedMeals = ArrayList<Meal>()
    private lateinit var rvMeals: RecyclerView
    private lateinit var adapter: MealAdapter
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvMeals = findViewById(R.id.rvMeals)
        searchEditText = findViewById(R.id.searchEditText)

        rvMeals.layoutManager = LinearLayoutManager(this)
        rvMeals.setHasFixedSize(true)

        adapter = MealAdapter(displayedMeals)
        rvMeals.adapter = adapter

        getMealsData()
        setupSearch()
    }

    private fun getMealsData() {
        RetrofitInstance.api.getMeals().enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    allMeals.clear()
                    allMeals.addAll(response.body()!!.meals)
                    displayedMeals.clear()
                    displayedMeals.addAll(allMeals)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupSearch() {
        searchEditText.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            ) {
                val query = searchEditText.text.toString().trim()
                if (query.isEmpty()) {
                    displayedMeals.clear()
                    displayedMeals.addAll(allMeals)
                } else {

                    val filtered = allMeals.filter { meal ->
                        meal.strMeal.contains(query, ignoreCase = true) ||
                                meal.strCategory?.contains(query, ignoreCase = true) == true ||
                                meal.strArea?.contains(query, ignoreCase = true) == true
                    }
                    displayedMeals.clear()
                    displayedMeals.addAll(filtered)
                }
                adapter.notifyDataSetChanged()
                true
            } else false
        }
    }
}
