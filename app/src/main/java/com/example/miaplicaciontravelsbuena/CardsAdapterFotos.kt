package com.example.miaplicaciontravelsbuena

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_fotos.*

class CardsAdapterFotos(var items: ArrayList<TarjetaFotos>) : RecyclerView.Adapter<CardsAdapterFotos.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var Foto : ImageView

        init {
            Foto = itemView.findViewById(R.id.imageView1)
        }

        fun bindTarjeta(t: TarjetaFotos, onClick: (View) -> Unit) = with(itemView) {
            Foto.setImageResource(t.imagenesPaisajes)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_fotos, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}