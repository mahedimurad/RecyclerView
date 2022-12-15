package com.example.recylerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_ecom.*

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ecom>
    lateinit var itemImage: Array<Int>
    lateinit var itemHeader: Array<String>
    lateinit var itemDescription: Array<String>
    lateinit var itemPrice: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemImage = arrayOf(
                    R.drawable.iphoneg,
                    R.drawable.iphoner,
                    R.drawable.iphone_12_pro_max,
                    R.drawable.iphone_12
        )

        itemHeader = arrayOf(
                    "Apple iPhone 12",
                    "Apple iPhone 13",
                    "Apple iPhone 12 Pro Max",
                    "Apple iPhone 12 Pro"
        )

        itemDescription = arrayOf(
                        "Equipped with impressive features and decent specifications",
                        "Equipped with impressive features and decent specifications",
                        "Internal, 128GB 6GB RAM, 256GB 6GB RAM, 512GB 6GB specifications",
                        "Memory, Card slot ; Internal, 128GB 6GB RAM, 256GB 6GB RAM, 512GB 6GB"
        )

        itemPrice = arrayOf(
                    "BDT 71,000.00",
                    "BDT 75,000.00",
                    "BDT 93,500.00",
                    "BDT 79,500.00"
        )

        newRecyclerView = findViewById(R.id.rv_ecomView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<ecom>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in itemImage.indices){
            val Ecom = ecom(itemImage[i],itemHeader[i],itemDescription[i],itemPrice[i])
            newArrayList.add(Ecom)
        }

        newRecyclerView.adapter = ecomAdapter(newArrayList)

    }
}