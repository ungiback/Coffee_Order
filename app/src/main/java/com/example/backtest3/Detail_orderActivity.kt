package com.example.backtest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_detail_order.*

class Detail_orderActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_order)

        do_drinkname.text = intent.getStringExtra("drinkname")
        do_drinkprice.text = intent.getStringExtra("drinkprice")
        count.text = intent.getStringExtra("count")

        var count_ : Int = Integer.parseInt(intent.getStringExtra("count"))

        var a = 0
        plus.setOnClickListener {
            a++
            count.text = a.toString()
        }

        minus.setOnClickListener {
            if (a == 0 ){
                Toast.makeText(this,"더 이상 줄일 수 없습니다.",Toast.LENGTH_SHORT).show()
            }else{
                a--
                count.text = a.toString()
            }
        }

        drink_add.setOnClickListener {

            val drink_order = hashMapOf(
                "count" to count.text.toString(),
                "drink_name" to do_drinkname.text.toString(),
                "drink_price" to do_drinkprice.text.toString()
            )

            var aa : Int  = Integer.parseInt(count.text.toString())
            if (aa != 0){
                db.collection("test")
                    .document("Order")
                    .set(drink_order)
                    .addOnCompleteListener {
                        Toast.makeText(this,"추가함",Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"추가실패",Toast.LENGTH_SHORT).show()
                    }
            }else{
                Toast.makeText(this,"0개라서 취소함",Toast.LENGTH_SHORT).show()
            }

            finish()
        }
        drink_close.setOnClickListener { finish() }
    }
}
