package com.example.android3110bai2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android3010bai2.Student

class StudentAdapter(private var students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    fun updateList(newList: List<Student>) {
        students = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameText: TextView = itemView.findViewById(android.R.id.text1)
        private val idText: TextView = itemView.findViewById(android.R.id.text2)

        fun bind(student: Student) {
            nameText.text = student.name
            idText.text = student.studentId
        }
    }
}
