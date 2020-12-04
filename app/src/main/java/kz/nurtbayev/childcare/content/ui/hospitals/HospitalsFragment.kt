package kz.nurtbayev.childcare.content.ui.hospitals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_hospitals.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.adapter.HospitalAdapter
import kz.nurtbayev.childcare.common.Repository

class HospitalsFragment : Fragment() {

    private lateinit var hospitalsViewModel: HospitalsViewModel
    private lateinit var hospitalsViewModelFactory: HospitalsViewModelFactory
    private lateinit var hospitalAdapter: HospitalAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hospitals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupRecyclerView()

        hospitalsViewModel.hospitalLiveData.observe(viewLifecycleOwner, Observer {
            if(it.isSuccessful){
                val result = it.body()?.data
                if(result != null){
                    hospitalAdapter.models = result
                }
            }
        })
    }

    private fun setupRecyclerView() {
        hospitalAdapter = HospitalAdapter()
        rvHospitals.adapter = hospitalAdapter
    }

    private fun init() {
        val repository = Repository()
        hospitalsViewModelFactory = HospitalsViewModelFactory(repository)
        hospitalsViewModel = ViewModelProvider(requireActivity(),hospitalsViewModelFactory).get(HospitalsViewModel::class.java)
        hospitalsViewModel.getHospital()
    }
}