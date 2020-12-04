package kz.nurtbayev.childcare.content.child.my_childs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.nurtbayev.childcare.HomeActivity
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.adapter.ChildAdapter
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.content.FoundationActivity
import kz.nurtbayev.childcare.database.Child


class MyChildrenActivity : AppCompatActivity() {

    private lateinit var myChildrenViewModel: MyChildrenViewModel
    private lateinit var myChildrenFactory: MyChildrenFactory

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

//    private fun setupViewstoHomeone() {
//        my_child_button.setOnClickListener {
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_children_recycler_view)
//        setupViewstoHomeone()

        Toast.makeText(this,"Не удалось добавить, попробуйте пожалуйста позднее", Toast.LENGTH_SHORT).show()

        val recyclerView = findViewById<RecyclerView>(R.id._childRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val repository = Repository()
        myChildrenFactory = MyChildrenFactory(repository)
        myChildrenViewModel = ViewModelProvider(this,myChildrenFactory).get(MyChildrenViewModel::class.java)
        myChildrenViewModel.getChildren()
        myChildrenViewModel.childrenLiveData.observe(this, Observer {
            Log.i("Result",it.body()?.data.toString())
            recyclerView.adapter =
                ChildAdapter(
                    this,
                    it.body()?.data!!
                ) {
                    val intent = Intent(this, FoundationActivity::class.java)
//                    intent.putExtra(INTENT_PARCELABLE, it)
                    startActivity(intent)
                }
        })




//
//        val childList = listOf<Child>(
//            Child(
//                    R.drawable.baby,
//                    R.drawable.hrec10,
//                "Название",
//                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
//            ),
//
//            Child(
//                    R.drawable.baby,
//                    R.drawable.hrec10,
//                "Название",
//                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
//            ),
//
//            Child(
//                    R.drawable.baby,
//                    R.drawable.hrec10,
//                "Название",
//                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
//            ),
//
//            Child(
//                    R.drawable.baby,
//                    R.drawable.hrec10,
//                "Название",
//                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
//            ),
//
//            Child(
//                    R.drawable.baby,
//                    R.drawable.hrec10,
//                "Название",
//                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
//            )
//        )
//
//
//
    }
}