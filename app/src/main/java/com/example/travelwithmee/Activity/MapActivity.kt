package com.example.travelwithmee.Activity

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.firebase.database.*

import com.example.travelwithmee.databinding.ActivityMapBinding

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.R

class MapActivity : AppCompatActivity() {
    private var mMap: GoogleMap? = null
    private var locationManager: LocationManager? = null
    private var location: Location? = null
    var curr_latLng: LatLng? = null
    var polyline: Polyline? = null
    lateinit var mDbRef: DatabaseReference
    private val LOCATION_MIN_UPDATE_TIME = 10
    private val LOCATION_MIN_UPDATE_DISTANCE = 1000
    lateinit var imgBack : ImageView
    lateinit var binding : ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root )
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        initview()

    }

    private fun initview() {

    }
}