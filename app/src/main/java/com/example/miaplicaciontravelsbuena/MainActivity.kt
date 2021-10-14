package com.example.miaplicaciontravelsbuena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ViewSwitcher.ViewFactory {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView1)

        val itemsFotos = ArrayList<TarjetaFotos>()
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_flores_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_plantas_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_girasol_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_canon_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_tucan_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_rio_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_canon_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_ballena_foreground))
        itemsFotos.add(TarjetaFotos(R.mipmap.ic_bosque_foreground))

        val adaptador = CardsAdapterFotos(itemsFotos)

        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val imageSwitcher = findViewById(R.id.imageswitcher) as ImageSwitcher
        imageSwitcher.setFactory(this)
        imageSwitcher.inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        imageSwitcher.outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        adaptador.onClick = {
            val imagen = resources.getDrawable(itemsFotos[recView.getChildAdapterPosition(it)].imagenesPaisajes)
            imageSwitcher.setImageDrawable(imagen)
        }
    }

    override fun makeView(): View {
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        imageView.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return imageView
    }
}