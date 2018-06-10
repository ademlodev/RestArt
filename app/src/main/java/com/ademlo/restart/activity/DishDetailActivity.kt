package com.ademlo.restart.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.ademlo.restart.R
import com.ademlo.restart.model.Dishes

class DishDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_DISH_INDEX = "EXTRA_DISH_INDEX"

        fun intent(context: Context, dishId: Int): Intent {
            val intent = Intent(context, DishDetailActivity::class.java)
            intent.putExtra(EXTRA_DISH_INDEX, dishId)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)

        val dishId: Int = intent.getIntExtra(EXTRA_DISH_INDEX,0)
        val dish = Dishes.getDishById(dishId)

        val dish_image = findViewById<ImageView>(R.id.imageView)
        val dish_name = findViewById<TextView>(R.id.dish_name_txt)
        val dish_price = findViewById<TextView>(R.id.dish_price_txt)
        val dish_description = findViewById<TextView>(R.id.dish_description_txt)
        val dish_ingredients = findViewById<TextView>(R.id.dish_ingredients_txt)
        val alergen_milk = findViewById<ImageView>(R.id.alergen_milk)
        val alergen_gluten = findViewById<ImageView>(R.id.alergen_gluten)
        val alergen_egg = findViewById<ImageView>(R.id.alergen_egg)
        val alergen_fish = findViewById<ImageView>(R.id.alergen_fish)

        dish?.let {
            dish_image.setImageResource(dish.image)
            dish_name.text = dish.name
            dish_price.text = dish.price.toString() + "€"
            dish_description.text = dish.description
            dish_ingredients.text = dish.ingredients

            if (dish.alergenMilk) {
                alergen_milk.visibility = View.VISIBLE
            }else{
                alergen_milk.visibility = View.INVISIBLE
            }

            if (dish.alergenGluten) {
                alergen_gluten.visibility = View.VISIBLE
            }else{
                alergen_gluten.visibility = View.INVISIBLE
            }

            if (dish.alergenEgg) {
                alergen_egg.visibility = View.VISIBLE
            }else{
                alergen_egg.visibility = View.INVISIBLE
            }

            if (dish.alergenFish) {
                alergen_fish.visibility = View.VISIBLE
            }else{
                alergen_fish.visibility = View.INVISIBLE
            }
        }
    }
}
