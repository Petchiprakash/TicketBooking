package com.example.ticketbooking

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Movies>
    lateinit var imageId: Array<Int>
    lateinit var tempArrList: ArrayList<Movies>
    lateinit var title: Array<String>
    lateinit var titleDescription: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.maanaadu_vp,
            R.drawable.annaathae,
            R.drawable.master,
            R.drawable.spider,
            R.drawable.paris,
            R.drawable.goodwill,
            R.drawable.maanaadu_vp,
            R.drawable.annaathae,
            R.drawable.master,
            R.drawable.spider,
            R.drawable.paris,
            R.drawable.goodwill
        )

        title = arrayOf(
            "Maanaadu",
            "Annaatthe",
            "Master",
            "SpiderMan No Way Home",
            "Midnight in Paris",
            "GoodWill",
            "Maanaadu One",
            "Annaatthe One",
            "Master One",
            "SpiderMan No Way Home One",
            "Midnight in Paris One",
            "GoodWill One"
        )

        titleDescription = arrayOf(
            "Tamil U/A",
            "Tamil U",
            "Tamil U/A",
            "English U/A",
            "English U",
            "English U/A",
            "Tamil U/A",
            "Tamil U",
            "Tamil U/A",
            "English U/A",
            "English U",
            "English U/A"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Movies>()
        tempArrList = arrayListOf<Movies>()
        getUserdata()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val item = menu?.findItem(R.id.search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()) {

                    newArrayList.forEach {
                        if (it.title.lowercase(Locale.getDefault()).contains(searchText)) {
                            tempArrList.add(it)
                        }
                    }
                    newRecyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    tempArrList.clear()
                    tempArrList.addAll(newArrayList)
                    newRecyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val movies = Movies(imageId[i], title[i], titleDescription[i])
            newArrayList.add(movies)
        }

        tempArrList.addAll(newArrayList)
        val adapter = MyAdapter(tempArrList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListner(object : MyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val temp = title[position]
                Toast.makeText(
                    this@MainActivity,
                    "You have Selected $temp",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

    }
}