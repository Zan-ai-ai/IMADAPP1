package vcmsa.ci.mealsuggestion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var timeOfDaytxt: EditText? = null
    private var suggesttxt: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)




        timeOfDaytxt = findViewById(R.id.timeOfDaytxt)
        suggesttxt = findViewById(R.id.suggesttxt)


        val mealsuggestbtn = findViewById<Button>(R.id.mealsuggestbtn)
        val resetbtn = findViewById<Button>(R.id.resetbtn)
        val exitbtn = findViewById<Button>(R.id.exitbtn)



        mealsuggestbtn.setOnClickListener {
            checkMeal()
        }


        resetbtn.setOnClickListener {

            timeOfDaytxt?.text?.clear()
            suggesttxt?.text = ""
        }

        exitbtn.setOnClickListener {
            finishAffinity()
            exitProcess(status = 0)

        }


    }

    // address user on input error detected
    private fun isNotEmpty(): Boolean {

        var a = true
        if (timeOfDaytxt?.text.toString().trim().isEmpty()) {
            timeOfDaytxt?.error = "Input is Required!"
            a = false
        }
        return a
    }

    private fun checkMeal() {


        if (isNotEmpty()) { // code to be executed if condition is true
            when (timeOfDaytxt?.text.toString().trim()) { // displays results to user

                "Morning" -> suggesttxt?.text =
                    "Protein oatmeal topped with banana slices and syrup"

                "Mid Morning" -> suggesttxt?.text = "Protein Bar and yogurt"
                "Afternoon" -> suggesttxt?.text = "Tuna and Mayo sandwich"
                "Mid Afternoon" -> suggesttxt?.text = "Mango Slices"
                "Night" -> suggesttxt?.text = "Chicken Alfredo with white cheesy sauce"
                "Mid Night" -> suggesttxt?.text = "Cake in a Mug"

                else -> { // prompts user to enter valid information

                    suggesttxt?.text =
                        "INCORRECT Time Of Day! Enter Valid Time Of Day (eg. Mid Afternoon)"
                }


            }
        }


    }
}



