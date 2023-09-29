package com.example.travelwithmee.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelwithmee.Activity.AddData.AddDataActivity
import com.example.travelwithmee.Activity.AddData.BeachDataAddActivity
import com.example.travelwithmee.Activity.AddData.CampAdddataActivity
import com.example.travelwithmee.Activity.AddData.CityAddDataActivity
import com.example.travelwithmee.Activity.AddData.DesertAddDataActivity
import com.example.travelwithmee.Activity.AddData.ForestAddDataActivity
import com.example.travelwithmee.Activity.AddData.LakeAddDataActivity
import com.example.travelwithmee.Activity.AddData.MountainAddDataActivity
import com.example.travelwithmee.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnadminlogin.setOnClickListener {
            val intent = Intent (getActivity(), AddDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }
        binding.btnbeachdata.setOnClickListener {
            val intent = Intent (getActivity(), BeachDataAddActivity::class.java)
            getActivity()?.startActivity(intent)

        }
        binding.btnmountaindata.setOnClickListener {
            val intent = Intent (getActivity(), MountainAddDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }
        binding.btnlakedata.setOnClickListener {
            val intent = Intent (getActivity(), LakeAddDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }
        binding.btncampdata.setOnClickListener {
            val intent = Intent (getActivity(), CampAdddataActivity::class.java)
            getActivity()?.startActivity(intent)

        }
        binding.btncitydata.setOnClickListener {
            val intent = Intent (getActivity(), CityAddDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }
        binding.btndesertdata.setOnClickListener {
            val intent = Intent (getActivity(), DesertAddDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }
        binding.btnforestdata.setOnClickListener {
            val intent = Intent (getActivity(), ForestAddDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }



        // Inflate the layout for this fragment
        return view

    }


}