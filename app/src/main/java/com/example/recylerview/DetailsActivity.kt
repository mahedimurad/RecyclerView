package com.example.recylerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val mm = intent.getParcelableExtra<Ecom>("mm")
        if (mm !=null){
            val imageView2 = findViewById<ImageView>(R.id.imageView2)
            val tv_itemHeader2 = findViewById<TextView>(R.id.tv_itemHeader2)
            val tv_itemDescription2 = findViewById<TextView>(R.id.tv_itemDescription2)
            val tv_itemPrice2 = findViewById<TextView>(R.id.tv_itemPrice2)

            imageView2.setImageResource(mm.itemImage)
            tv_itemHeader2.text = mm.header
            tv_itemDescription2.text = mm.description
            tv_itemPrice2.text = mm.price
        }

    }
}