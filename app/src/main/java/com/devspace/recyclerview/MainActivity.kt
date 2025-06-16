package com.devspace.recyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
         rvList.layoutManager = GridLayoutManager(this,2)
        }
        ivList.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }
    }
}

        val contacts = listOf(
            Contact(
                name = "Rafik",
                phone = "(00244) 924875859",
                icon = R.drawable.sample12
            ),

            Contact(
                name = "Micala",
                phone = "(00244) 914095732",
                icon = R.drawable.sample1
            ),

            Contact(
                name = "Marcia",
                phone = "(00244) 920976433",
                icon = R.drawable.sample13
            ),

            Contact(
                name = "Adele",
                phone = "(00244) 96547800",
                icon = R.drawable.sample4
            ),

            Contact(
                name = "Justin",
                phone = "(00244) 98482261",
                icon = R.drawable.sample2
            ),

            Contact(
                name = "Soraia",
                phone = "(00244) 924875859",
                icon = R.drawable.sample16
            ),

            Contact(
                name = "Monica",
                phone = "(00244) 949776433",
                icon = R.drawable.sample3
            ),

            Contact(
                name = "Rosira",
                phone = "(00244) 902431208",
                icon = R.drawable.sample5
            ),

            Contact(
                name = "Solange",
                phone = "(00244) 997654391",
                icon = R.drawable.sample6
            ),

            Contact(
                name = "Tina",
                phone = "(00244) 909448908",
                icon = R.drawable.sample7
            ),

            Contact(
                name = "Gustavo",
                phone = "(00244) 915097754",
                icon = R.drawable.sample8
            ),

            Contact(
                name = "Matt",
                phone = "(00244) 976542661",
                icon = R.drawable.sample9
            ),

            Contact(
                name = "Matheus",
                phone = "(00244) 989234476",
                icon = R.drawable.sample10
            ),

            Contact(
                name = "Annie",
                phone = "(00244) 909754023",
                icon = R.drawable.sample11
            ),

            Contact(
                name = "Lucas",
                phone = "(00244) 912359084",
                icon = R.drawable.sample14
            ),

            Contact(
                name = "Rita",
                phone = "(00244) 987654238",
                icon = R.drawable.sample15
            ),

            )
