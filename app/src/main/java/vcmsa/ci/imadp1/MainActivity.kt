package vcmsa.ci.imadp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var suggestionText: TextView
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeInput = findViewById(R.id.timeInput)
        suggestionText = findViewById(R.id.suggestionText)
        suggestButton = findViewById (R.id.suggestButton)
        resetButton = findViewById(R.id.resetButton)

        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()

            // Meal suggestion logic
            val mealSuggestion = when (timeOfDay) {
                "morning" -> "Breakfast: Eggs"
                "mid morning" -> "Snack: Fruit"
                "afternoon" -> "Lunch: Sandwich"
                "mid afternoon" -> "Snack: Cake"
                "dinner" -> "Main Course: Pasta"
                "after dinner" -> "Dessert: Ice cream"
                else -> null
            }

            if (mealSuggestion != null) {
                suggestionText.text = mealSuggestion
            } else {
                // If input is invalid, show error message
                Toast.makeText(this, "Invalid time input. Please enter a valid time (e.g., Morning, Lunch).", Toast.LENGTH_SHORT).show()
                suggestionText.text = "Please enter a valid time of day."
            }
        }

        // Reset UI elements
        resetButton.setOnClickListener {
            timeInput.text.clear()
            suggestionText.text = "Your meal suggestion will appear here"
        }
    }
}