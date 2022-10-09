package com.ejercicio3fmr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ejercicio3fmr.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    //Crea la constante para recoger el lugar que se pasa en la mainActivity
    //y recogerlo con el intent
    companion object{

        const val SELECTED_PLACE = "LugarSeleccionado"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //Obtiene el lugar con el intent y lo guardamos en una variable
        val getPlace = intent.getParcelableExtra<Place>(SELECTED_PLACE)

        //Cuando el lugar no sea null entra en la condicion
        if(getPlace != null) {

            //Cambiamos el nombre de la ActionBar por el nombre del lugar
            supportActionBar?.title = getPlace.name;

            //Guarda las coordenads del lugar en una variable
            val place = LatLng(getPlace.lat.toDouble(), getPlace.lon.toDouble())

            //Añade el marcador en las coordenas que indique el lugar y de titulo se le pone su nombre
            mMap.addMarker(MarkerOptions().position(place).title(getPlace.name))

            //Mueve la camara hacia las coordenas del lugar
            mMap.moveCamera(CameraUpdateFactory.newLatLng(place))

            //Hace zoom hacia las coordenadas
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place, 14f),4000,null)

        }
    }
}