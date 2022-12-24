package com.example.recylerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Ecom>
    private lateinit var ecomAdapter: ecomAdapter
    lateinit var itemImage: Array<Int>
    lateinit var itemHeader: Array<String>
    lateinit var itemDescription: Array<String>
    lateinit var itemPrice: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemImage = arrayOf(
                    R.drawable.iphone_12g,
                    R.drawable.iphone_13r,
                    R.drawable.iphone_12_pro,
                    R.drawable.iphone_12p,
                    R.drawable.ipone_13
        )

        itemHeader = arrayOf(
                    "Apple iPhone 12",
                    "Apple iPhone 13",
                    "Apple iPhone 12 Pro Max",
                    "Apple iPhone 12 Pro",
                    "iPhone 14 Pro"
        )

        itemDescription = arrayOf(
                        getString(R.string.dis_1),
                        getString(R.string.dis_2),
                        getString(R.string.dis_3),
                        getString(R.string.dis_4),
                        getString(R.string.dis_5)
        )

        itemPrice = arrayOf(
                    "BDT 71,000.00",
                    "BDT 75,000.00",
                    "BDT 93,500.00",
                    "BDT 79,500.00",
                    "BDT 98,500.00"
        )

        newRecyclerView = findViewById(R.id.rv_ecomView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Ecom>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in itemImage.indices){
            val Ecom = Ecom(itemImage[i],itemHeader[i],itemDescription[i],itemPrice[i])
            newArrayList.add(Ecom)
        }

        newRecyclerView.adapter = ecomAdapter(newArrayList){
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("mm", it)
            startActivity(intent)
        }

    }
}