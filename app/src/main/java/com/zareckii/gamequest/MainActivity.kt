package com.zareckii.gamequest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wakeupClickable = MyClickableSpan {
            Toast.makeText(this, "asd", Toast.LENGTH_SHORT).show()
        }

        val questionTextView = findViewById<TextView>(R.id.questionTextView)
        val wakeupFullText = getString(R.string.wakeup_full_text)
        val lookAround = getString(R.string.look_around_text)
        val spannableString = SpannableString(wakeupFullText)

        spannableString.setSpan(
            wakeupClickable,
            wakeupFullText.indexOf(lookAround),
            wakeupFullText.indexOf(lookAround) + lookAround.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        questionTextView.run {
            text = spannableString
            movementMethod = LinkMovementMethod.getInstance()
            highlightColor = Color.TRANSPARENT
        }
    }
}