package com.kakapo.squiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.kakapo.squiz.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_quiz_menu.*


class QuizMenuFragment : Fragment() {

    var fragmentView : View? = null
    var firedatabase : FirebaseDatabase? = null
    var CatList : ArrayList<Category> ? = null
    var ref : DatabaseReference? = null
    var RV_new_menu : RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentView = LayoutInflater.from(activity).inflate(R.layout.fragment_quiz_menu, container, false)

        firedatabase = FirebaseDatabase.getInstance()

        RV_new_menu = fragmentView?.findViewById(R.id.RVCourse)
        RV_new_menu?.setHasFixedSize(true)
        RV_new_menu?.layoutManager = LinearLayoutManager(context)

        CatList = arrayListOf<Category>()
        ref = FirebaseDatabase.getInstance().getReference("Category")


        ref?.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {


                if(p0!!.exists()){


                    for (h in p0!!.children){
                        val cat = h.getValue(Category::class.java)
                        CatList!!.add(cat!!)
                    }
                    val adapter = CategoryAdapter(context!!,CatList!!)
                    RV_new_menu?.setAdapter(adapter)


                }

            }
        })


        return  fragmentView
    }



//    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(itemView, savedInstanceState)
//
//        RV_new_menu = RVCourse
//        val recyclerView = RVCourse as RecyclerView
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        val Category = ArrayList<Category>()
//
//        Category.add(Category("Kotlin"))
//        Category.add(Category("Java"))
//        Category.add(Category("Math"))
//        Category.add(Category("Math"))
//        Category.add(Category("Math"))
//
//        val adapter = CategoryAdapter(Category)
//        recyclerView.adapter = adapter
//    }



    companion object {
        fun newInstance(): QuizMenuFragment{
                val fragment = QuizMenuFragment()
                val args = Bundle()
                fragment.arguments = args
                return fragment
                }
    }
}