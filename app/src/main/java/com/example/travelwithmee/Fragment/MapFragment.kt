package com.example.travelwithmee.Fragment

import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.content.ContextCompat
import com.example.travelwithmee.R
import com.example.travelwithmee.databinding.FragmentHomeBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.core.Context
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : Fragment(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private var addedMarker: Marker? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_map, container, false)
        initView(view)
        return view
    }

    private fun initView(view: Any) {
        // Initializing our search view.

        // Obtain the SupportMapFragment and get notified
        // when the map is ready to be used.
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        // Adding a query listener for our search view.
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val location = searchView.query.toString()
                var addressList: List<Address>? = null

                if (location != null || location == "") {
                    val geocoder = Geocoder(requireContext())
                    try {
                        addressList = geocoder.getFromLocationName(location, 1)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                    if (!addressList.isNullOrEmpty()) {
                        val address = addressList[0]
                        val latLng = LatLng(address.latitude, address.longitude)

                        Log.e(
                            "TAG",
                            "latitude:-  " + address.latitude + " " + "longitude:- " + address.longitude
                        )

                        addedMarker?.remove()
                        addedMarker =
                            mMap.addMarker(MarkerOptions().position(latLng).title(location))
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))
                    }
                }

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                addedMarker?.remove()
                return false
            }
        })

        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }
}

//        val rootView = inflater.inflate(R.layout.fragment_map, container, false)
//
//        val mapFragment =
//            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
//        mapFragment!!.getMapAsync { mMap ->
//            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
//
//            mMap.clear() //clear old markers
//
//            val googlePlex = CameraPosition.builder()
//                .target(LatLng(37.4219999, -122.0862462))
//                .zoom(10f)
//                .bearing(0f)
//                .tilt(45f)
//                .build()
//
//            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null)
//
////            mMap.addMarker(
////                MarkerOptions()
////                    .position(LatLng(37.4219999, -122.0862462))
////                    .title("Spider Man")
////
////            )
////
////            mMap.addMarker(
////                MarkerOptions()
////                    .position(LatLng(37.4629101, -122.2449094))
////                    .title("Iron Man")
////                    .snippet("His Talent : Plenty of money")
////            )
////
////            mMap.addMarker(
////                MarkerOptions()
////                    .position(LatLng(37.3092293, -122.1136845))
////                    .title("Captain America")
////            )
//        }
//
//        return rootView
//    }
//
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        val london = LatLng(51.509865, -0.118092)
//        googleMap?. addMarker(MarkerOptions()
//            .position(london)
//            .title("London,Uk")
//        )

//    private fun bitmapDescriptorFromVector(context: Context?, vectorResId: Int): BitmapDescriptor {
//        val vectorDrawable = ContextCompat.getDrawable(requireContext(), vectorResId)
//        vectorDrawable!!.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)
//        val bitmap =
//            Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(bitmap)
//        vectorDrawable.draw(canvas)
//        return BitmapDescriptorFactory.fromBitmap(bitmap)
//    }


