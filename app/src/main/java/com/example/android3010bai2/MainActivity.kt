package com.example.android3010bai2

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android3110bai2.StudentAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private val studentList = listOf(
        Student("Nguyen Van A", "20204547"),
        Student("Nguyen van B", "20204564"),
        Student("Tran Thi C", "20202020"),
        Student("Tran Thi Huyen T", "20232021")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchView = findViewById<SearchView>(R.id.searchView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty() && newText.length >= 2) {
                    val filteredList = studentList.filter {
                        it.name.contains(newText, ignoreCase = true) || it.studentId.contains(newText, ignoreCase = true)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    studentAdapter.updateList(studentList)
                }
                return true
            }
        })
    }
}
