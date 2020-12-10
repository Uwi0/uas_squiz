package com.kakapo.squiz.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kakapo.quizapp.ui.QuizQuestionActivity
import com.kakapo.squiz.Category
import com.kakapo.squiz.R

class CategoryAdapter(val CategoryList: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_menu_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, QuizQuestionActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return CategoryList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(Category: Category) {

            val textViewCourseCategoryName = itemView.findViewById(R.id.textViewCourseCategoryName) as TextView

            textViewCourseCategoryName.text = Category.Coursename

        }
    }
}