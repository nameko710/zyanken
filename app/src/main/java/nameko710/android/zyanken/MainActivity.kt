package nameko710.android.zyanken

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btDecision = findViewById<TextView>(R.id.btDecision)
        val listener = RadioListener()
        btDecision.setOnClickListener(listener)
    }

    private inner class RadioListener:View.OnClickListener{
        override fun onClick(view: View){
            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
            val selectID = radioGroup.checkedRadioButtonId
            val selectButton = findViewById<RadioButton>(selectID)
            val selectHand = selectButton.text
            val (playerHand, programHand, result) = game(selectHand.toString())

            val intentResult = Intent(this@MainActivity,ResultActivity
            ::class.java)
            intentResult.putExtra("result", result)
            intentResult.putExtra("playerHand", playerHand)
            intentResult.putExtra("programHand", programHand)
            startActivity(intentResult)
        }

        fun game(m:String): Triple<Int, Int, String> {
            val zyanken = mapOf("グー" to 1, "チョキ" to 2, "パー" to 3)
            val programHand = (1..3).random()
            val playerHand = zyanken[m]

            val result: String = if (programHand == playerHand){
                "あいこ"
            } else if ((programHand - playerHand!!) == -2 || (programHand - playerHand) == 1){
                "勝ち"
            } else{
                "負け"
            }

            return Triple(playerHand, programHand, result)
        }
    }
}


