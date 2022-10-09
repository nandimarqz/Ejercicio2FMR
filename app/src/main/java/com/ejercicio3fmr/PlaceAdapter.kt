package com.ejercicio3fmr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ejercicio3fmr.databinding.PlaceViewBinding

/**
 * Este adapter va a ser el puente entre la vista y los datos que tenga (en este caso la vista: place_layout y los datos de la lista de la MainActivity )
 */
class PlaceAdapter(val places: List<Place>, val listener: (Place) -> Unit): RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){


    /**
     * Se encarga de inflar la vista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //Guarda la vista inflada en una variable
        val view =LayoutInflater.from(parent.context).inflate(R.layout.place_view, parent, false)

        //Devuelve el viewHolder con la vista inflada como parametro del constructor
        return ViewHolder(view)
    }

    /**
     *Se encarga de asignar un componente en el momento en el que la vista entra en pantalla
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Llama a la funcion bind de la clase ViewHolder y le pasa por parametro el lugar que indique la posicion
        holder.bind(places[position])

        //Guarda en una variable el lugar que indique la posicion pasada por parametro
        val place = places[position]

        //Pone un escuchador de eventos en los items de la vista,
        //que cuando se haga click sobre ellos llame a la funcion listener
        //pasada por parametro a la clase y se pasa por parametro el lugar que se guardo en la variable
        holder.itemView.setOnClickListener{
            listener(place)

        }

    }

    /**
     * Devuelve el tamaño de la lista que se le pasa por parametro
     */
    override fun getItemCount(): Int = places.size

    /**
     * Gestiona la vista y controla lo que hay en pantalla, los datos, los reutiliza, etc
     */
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        //Guarda en una variable el binding de la vista(los componentes)
        val binding = PlaceViewBinding.bind(view)

        /**
         *Esta funcion cambia el texto y la imagen de los componentes de
         *la vistas recogidos con Binding. Recibe un lugar por parametro
         */
        fun bind(place : Place){

            binding.textView.text = place.name

            Glide.with(binding.imageView).load(place.urlImg).into(binding.imageView)
        }

    }
}