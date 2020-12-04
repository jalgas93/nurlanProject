package kz.nurtbayev.childcare.content.ui.likes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_likes.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.adapter.HorizontalAdapter
import kz.nurtbayev.childcare.adapter.LikeAdapter

class LikesFragment : Fragment() {

    private lateinit var likesViewModel: LikeViewModel
    private lateinit var likeFactory: LikeFactory
    private lateinit var likeAdapter: LikeAdapter
    private lateinit var horizontalAdapter: HorizontalAdapter


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_likes, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = LikesRepository()
        likeFactory = LikeFactory(repository)
        likesViewModel = ViewModelProvider(requireActivity(),likeFactory).get(LikeViewModel::class.java)
        likesViewModel.getLike()
//        likesViewModel.getArticle()

        likeAdapter = LikeAdapter()
        likesRv.adapter = likeAdapter
        horizontalAdapter = HorizontalAdapter()
//        rvHorizontal.adapter = horizontalAdapter

//        likesViewModel.articleLiveData.observe(requireActivity(), Observer {
//            horizontalAdapter.models = it.body()?.categoryList!!
//        })

        likesViewModel.likeLiveData.observe(requireActivity(), Observer {
            likeAdapter.models = it.body()?.data!!
        })
    }
}