package com.ejercicio3fmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ejercicio3fmr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val list = listOf<Place>(Place("https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Angkor_Wat.jpg/1200px-Angkor_Wat.jpg", "Angkor Wat", "13.4125", "103.86666666667"),
        Place("https://cnnespanol.cnn.com/wp-content/uploads/2021/06/Gran-barrera-coral.jpeg?quality=100&strip=info", "Barrera de coral", "-18.2870668", "147.6991918"),
        Place("https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Before_Machu_Picchu.jpg/640px-Before_Machu_Picchu.jpg", "Machu Picchu" , "-13.1631412", " -72.5449629"),
        Place("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/william-olivieri-hwy9r6-yzgm-unsplash-1646657593.jpg?crop=1.00xw:1.00xh;0,0&resize=640:*", "Gran Muralla China" , "40.4319077", "116.5703749"),
        Place("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/%C4%90%E1%BB%81n_Taj_Mahal.jpg/245px-%C4%90%E1%BB%81n_Taj_Mahal.jpg", "Taj Mahal" , "27.1750151", "78.0421552"),
        Place("https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Grand_Canyon_view_from_Pima_Point_2010.jpg/273px-Grand_Canyon_view_from_Pima_Point_2010.jpg", "Gran cañon" , "36.0544445", "-112.1401108"),
        Place("https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Foz_de_Igua%C3%A7u_27_Panorama_Nov_2005.jpg/280px-Foz_de_Igua%C3%A7u_27_Panorama_Nov_2005.jpg", "Cataratas del Iguazú" , "-25.731763", "-54.476121"),
        Place("https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Hagia_Sophia_Mars_2013.jpg/270px-Hagia_Sophia_Mars_2013.jpg", "Santa Sofía" , "41.00850865", "28.980009932"),
        Place("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/The_Treasury%2C_Petra%2C_Jordan5.jpg/270px-The_Treasury%2C_Petra%2C_Jordan5.jpg", "Petra" , "30.328621071360363", "35.444458756518614")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = PlaceAdapter(list){ place ->

            val intent = Intent(this@MainActivity, MapsActivity::class.java)

            intent.putExtra(MapsActivity.SELECTED_PLACE, place)

            startActivity(intent)

        }

    }
}