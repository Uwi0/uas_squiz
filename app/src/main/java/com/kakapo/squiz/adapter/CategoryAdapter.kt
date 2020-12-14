package com.kakapo.squiz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kakapo.squiz.ui.QuizQuestionActivity
import kotlinx.android.synthetic.main.*

import com.kakapo.squiz.Category
import com.kakapo.squiz.R
import kotlinx.android.synthetic.main.list_menu_layout.view.*

class CategoryAdapter( val context: Context,  val CatList: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(CatList[position], context)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, QuizQuestionActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_menu_layout, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return CatList.size
    }





    inner class Holder(val view: View) : RecyclerView.ViewHolder(view!!) {
        fun bind(cat: Category, context: Context) {
            view.tViewCName.text = cat.Name
        }
    }
}