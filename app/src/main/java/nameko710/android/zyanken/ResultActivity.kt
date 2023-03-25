package nameko710.android.zyanken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //勝敗結果を表示
        val result = intent.getStringExtra("result")
        val tvResult = findViewById<TextView>(R.id.tvResult)
        tvResult.text = result

        //val resultImage = mapOf(1 to R.drawable.janken_gu, 2 to R.drawable.janken_choki, 3 to R.drawable.janken_pa)

        //自分が出した手を表示
        val imageView1 = findViewById<ImageView>(R.id.ivPlayer)
        val playerHandImage: Int = when (intent.getIntExtra("playerHand", 0)){
            1 -> {
                R.drawable.janken_gu
            }
            2 -> {
                R.drawable.janken_choki
            }
            // 3の場合
            else -> {
                R.drawable.janken_pa
            }
        }
        imageView1.setImageResource(playerHandImage)

        //相手が出した手を表示
        val imageView2 = findViewById<ImageView>(R.id.ivProgram)
        val programHandImage: Int = when (intent.getIntExtra("programHand", 0)){
            1 -> {
                R.drawable.janken_gu
            }
            2 -> {
                R.drawable.janken_choki
            }
            // 3の場合
            else -> {
                R.drawable.janken_pa
            }
        }
        imageView2.setImageResource(programHandImage)

        //前の画面に戻る
        val btBack = findViewById<Button>(R.id.btBack)
        btBack.setOnClickListener{
            finish()
        }
    }
}



