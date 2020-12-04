package kz.nurtbayev.childcare.content.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import kz.nurtbayev.childcare.MainActivity
import kz.nurtbayev.childcare.ProfileBaby
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.content.FoundationActivity

class ProfileFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMother.setOnClickListener {
        }
        btnBaby.setOnClickListener {
        }
    }
}