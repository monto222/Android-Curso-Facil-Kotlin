package com.pruebas.kotlinDesdeCero.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Pruebas.tutorial.R

class SuperHeroAdapter(
    var superheroList: List<SuperheroItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroList: List<SuperheroItemResponse>) { //cuando pongo this me refiero al de la clase, cuando no, al del listado
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false))
        )
    }

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        viewholder.bind(superheroList[position],onItemSelected)
    }

    override fun getItemCount() = superheroList.size

}
