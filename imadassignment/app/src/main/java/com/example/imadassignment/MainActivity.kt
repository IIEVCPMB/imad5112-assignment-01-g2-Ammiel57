package com.example.imadassignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Declaration of variables

    private lateinit var edtDay: EditText
    private lateinit var btnReset: Button
    private lateinit var btnSuggestion: Button
    private lateinit var tvResults: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Typecasting

        edtDay = findViewById(R.id.edtDay)
        btnReset = findViewById(R.id.btnReset)
        btnSuggestion = findViewById(R.id.btnSuggestion)
        tvResults = findViewById(R.id.tvResults)

        //Coding the suggestion button

        btnSuggestion.setOnClickListener {

            val dayText = edtDay.text.toString().trim()

            // first if: Check if the user entered a value
            if (dayText.isNotEmpty()) {

                // second if: Check for Morning
                if (dayText == "Morning") {
                    tvResults.text = "Send a 'Good morning' text to a family member."
                } else {
                    // nested if: Check for Mid-morning
                    if (dayText == "Mid-morning") {
                        tvResults.text = "Reach out to a colleague with a quick 'Thank you'."
                    } else {
                        // nested if: Check for Afternoon
                        if (dayText == "Afternoon") {
                            tvResults.text = "Share a funny meme or interesting link with a friend."
                        } else {
                            // nested if: Check for Afternoon Snack Time
                            if (dayText == "Afternoon Snack Time") {
                                tvResults.text = "Send a quick 'thinking of you' message."
                            } else {
                                // nested if: Check for Dinner
                                if (dayText == "Dinner") {
                                    tvResults.text = "Call a friend or relative for a 5-minute catch-up."
                                } else {
                                    // nested if: Check for Night or After Dinner
                                    if (dayText == "After Dinner") {
                                        tvResults.text = "Leave a thoughtful comment on a friend's post."
                                    } else {
                                        if (dayText == "Night") {
                                            tvResults.text = "Leave a thoughtful comment on a friend's post."
                                        } else {
                                            // final else for unrecognized text
                                            tvResults.text = "Time not recognized."
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                // if the field was empty
                tvResults.text = "Please enter a time of day"
            }
        }

        //Reset button
        btnReset.setOnClickListener {
            edtDay.text.clear()
            tvResults.text = ""
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}