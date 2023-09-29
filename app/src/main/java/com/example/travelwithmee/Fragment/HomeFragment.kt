package com.example.travelwithmee.Fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelwithmee.Activity.DesignationdetailAcitivity
import com.example.travelwithmee.Adapter.ProfileCategoryAdapter
import com.example.travelwithmee.Modelclass.AddDataModelclass
import com.example.travelwithmee.R
import com.example.travelwithmee.databinding.FragmentHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val View = binding.root
        var reference= FirebaseDatabase.getInstance().reference
        var list = ArrayList<AddDataModelclass>()

        val progressDialog = ProgressDialog(context)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("Datatb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (child in snapshot.children) {

                    var data: AddDataModelclass? = child.getValue(AddDataModelclass::class.java)
                    Log.e("TAG", "onDataChange: "  )

                    if (data != null) {
                        list.add(data)
                    }
                }

                progressDialog.dismiss()

                var adapter = ProfileCategoryAdapter(this@HomeFragment, list)
                var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter.notifyDataSetChanged()

                binding.rcvCategory.layoutManager = manager
                binding.rcvCategory.adapter = adapter


            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "onCancelled: "+error )

            }

        })

        catcall()
        return View


    }

    private fun catcall() {
        binding.catBeach.setOnClickListener {
//            var i = Intent(this,DesignationdetailAcitivity::class.java )
//            startActivity(i)
            val intent = Intent(requireActivity().application, DesignationdetailAcitivity::class.java)
            intent.putExtra("category","Beach")
            startActivity(intent)
        }
        binding.catMountain.setOnClickListener {
            val intent = Intent(requireActivity().application, DesignationdetailAcitivity::class.java)
            intent.putExtra("category","Mountain")
            startActivity(intent)
        }
        binding.catLake.setOnClickListener {
            val intent = Intent(requireActivity().application, DesignationdetailAcitivity::class.java)
            intent.putExtra("category","Lake")
            startActivity(intent)
        }
        binding.catCamp.setOnClickListener {
            val intent = Intent(requireActivity().application, DesignationdetailAcitivity::class.java)
            intent.putExtra("category","Camp")
            startActivity(intent)
        }
        binding.catCity.setOnClickListener {
            val intent = Intent(requireActivity().application, DesignationdetailAcitivity::class.java)
            intent.putExtra("category","City")
            startActivity(intent)
        }
        binding.catDesert.setOnClickListener {
            val intent = Intent(requireActivity().application, DesignationdetailAcitivity::class.java)
            intent.putExtra("category","Desert")
            startActivity(intent)
        }
        binding.catForest.setOnClickListener {
            val intent = Intent(requireActivity().application, DesignationdetailAcitivity::class.java)
            intent.putExtra("category","Forest")
            startActivity(intent)
        }
    }

}


