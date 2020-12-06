package com.kakapo.squiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val CategoryList: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_menu_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(CategoryList[position])
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