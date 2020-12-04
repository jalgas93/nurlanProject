package kz.nurtbayev.childcare.content.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.adapter.CategoriesAdapter
import kz.nurtbayev.childcare.common.Repository

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var categoriesVIewModel: CategoriesVIewModel
    private lateinit var categoriesFactory: CategoriesFactory
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val repository = Repository()
        categoriesAdapter = CategoriesAdapter()
        rvCategories.adapter = categoriesAdapter

        if (activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_PORTRAIT) {
            rvCategories.layoutManager = GridLayoutManager(requireContext(), 3)
            rvCategories.addItemDecoration(
                GridSpacingItemDecoration(
                    3,
                    0,
                    false
                )
            )
        } else {
            rvCategories.layoutManager = GridLayoutManager(requireContext(), 3)
            rvCategories.addItemDecoration(
                GridSpacingItemDecoration(
                    3,
                    10,
                    true
                )
            )
        }

        categoriesFactory = CategoriesFactory(repository)
        categoriesVIewModel = ViewModelProvider(requireActivity(),categoriesFactory).get(CategoriesVIewModel::class.java)
        categoriesVIewModel.getCategories()
        categoriesVIewModel.categoriesLiveData.observe(requireActivity(), Observer {
            Log.i("Categories",it.body()?.data.toString())
            categoriesAdapter.models = it.body()?.data!!
        })
    }
}