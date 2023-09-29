package com.example.travelwithmee.Activity

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import com.example.travelwithmee.R
import com.example.travelwithmee.databinding.ActivityMapLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

class MapLocationActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding : ActivityMapLocationBinding
    lateinit var place : String
    private lateinit var mMap: GoogleMap

    lateinit var idSearchView: SearchView

    var addedMarker: Marker? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMapLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        if (intent!=null){

            val mapFragment = supportFragmentManager.findFragmentById(R.id.maplocation) as SupportMapFragment?

            idSearchView.setOnQueryTextListener(/* listener = */ object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    place=  intent.getStringExtra("location").toString()

                    var addressList: List<Address>? = null

                    if (place != null || place == "") {
                        val geocoder = Geocoder(this@MapLocationActivity)
                        try {
                            addressList = geocoder.getFromLocationName(place, 1)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                        val address = addressList!![0]

                        val latLng = LatLng(address.latitude, address.longitude)

                        Log.e(
                            "TAG",
                            "latitude:-  " + address.latitude + " " + "longitude:- " + address.longitude
                        )


                        addedMarker = mMap.addMarker(MarkerOptions().position(latLng).title(place))!!

                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))


                    }

                    return false

                }


                override fun onQueryTextChange(newText: String): Boolean {
                    addedMarker?.remove()
                    return false

                }
            })
            mapFragment!!.getMapAsync(this)



        }
    }

    override fun onMapReady(p0: GoogleMap) {

//        if(place=="Baga beach"){
//            bagaBeach(p0)
//        }
////        else if(place=="Palolem beach")
////        {
////            Palolembeach(p0)
////        }
        mMap = p0
    }

    private fun Palolembeach(p0: GoogleMap) {
        val Palolembeach = LatLng(3.2028 , 73.2207)
        p0?. addMarker(
            MarkerOptions()
                .position(Palolembeach)
                .title("Palolem beach,Maldives")

        )

    }

    private fun bagaBeach(p0: GoogleMap?) {
        val goa = LatLng(15.5570495 , 73.7548514)
        p0?. addMarker(
            MarkerOptions()
            .position(goa)
            .title("Baga beach,Goa")
        )
    }
}