package com.kakapo.squiz.model

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.kakapo.squiz.Category
import com.kakapo.squiz.R
import com.kakapo.squiz.adapter.CategoryAdapter
import com.kakapo.squiz.model.Question

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"
    var fragmentView : View? = null
    var firedatabase : FirebaseDatabase? = null
    var CatList : ArrayList<Category> ? = null
    var ref : DatabaseReference? = null


//    fun getQuestion(): ArrayList<Question>{
//        val questionsList = ArrayList<Question>()
//
//        // 1
//        val que1 = Question(
//                1, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_argentina,
//                "Argentina", "Australia",
//                "Armenia", "Austria", 1
//        )
//
//        questionsList.add(que1)
//
//        // 2
//        val que2 = Question(
//                2, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_australia,
//                "Angola", "Austria",
//                "Australia", "Armenia", 3
//        )
//
//        questionsList.add(que2)
//
//        // 3
//        val que3 = Question(
//                3, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_brazil,
//                "Belarus", "Belize",
//                "Brunei", "Brazil", 4
//        )
//
//        questionsList.add(que3)
//
//        // 4
//        val que4 = Question(
//                4, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_belgium,
//                "Bahamas", "Belgium",
//                "Barbados", "Belize", 2
//        )
//
//        questionsList.add(que4)
//
//        // 5
//        val que5 = Question(
//                5, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_fiji,
//                "Gabon", "France",
//                "Fiji", "Finland", 3
//        )
//
//        questionsList.add(que5)
//
//        // 6
//        val que6 = Question(
//                6, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_germany,
//                "Germany", "Georgia",
//                "Greece", "none of these", 1
//        )
//
//        questionsList.add(que6)
//
//        // 7
//        val que7 = Question(
//                7, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_denmark,
//                "Dominica", "Egypt",
//                "Denmark", "Ethiopia", 3
//        )
//
//        questionsList.add(que7)
//
//        // 8
//        val que8 = Question(
//                8, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_india,
//                "Ireland", "Iran",
//                "Hungary", "India", 4
//        )
//
//        questionsList.add(que8)
//
//        // 9
//        val que9 = Question(
//                9, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_new_zealand,
//                "Australia", "New Zealand",
//                "Tuvalu", "United States of America", 2
//        )
//
//        questionsList.add(que9)
//
//        // 10
//        val que10 = Question(
//                10, "What country does this flag belong to?",
//                R.drawable.ic_flag_of_kuwait,
//                "Kuwait", "Jordan",
//                "Sudan", "Palestine", 1
//        )
//
//        questionsList.add(que10)
//
//        return questionsList
//    }
    fun getQuestion(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
    firedatabase = FirebaseDatabase.getInstance()
    ref = FirebaseDatabase.getInstance().getReference("Questions")

    ref?.addValueEventListener(object : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {

        }

        override fun onDataChange(p0: DataSnapshot) {


            if(p0!!.exists()){

                var q : Int = 0
                for (h in p0!!.children){
                    val que = h.getValue(Question::class.java)
                    questionsList.add(que!!)

                }


            }

        }
    })
        // 1


    return questionsList

    }
}