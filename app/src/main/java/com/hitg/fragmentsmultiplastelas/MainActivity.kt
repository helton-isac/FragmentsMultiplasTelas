package com.hitg.fragmentsmultiplastelas

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.hitg.fragmentsmultiplastelas.models.Item
import com.hitg.fragmentsmultiplastelas.views.activities.DetalheItemActivity
import com.hitg.fragmentsmultiplastelas.views.fragments.DetalheItemFragment
import com.hitg.fragmentsmultiplastelas.views.listeners.OnItemSelectedListener

class MainActivity : AppCompatActivity(), OnItemSelectedListener {
    //Variavel para controle se a tela de detalhe e a lista estao na mesma tela
    private var telaUnica = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        determinePaneLayout()
    }

    private fun determinePaneLayout() {
        val fragmentItemDetail =
            findViewById<FrameLayout>(R.id.flDetailContainer)
        if (fragmentItemDetail != null) {
            telaUnica = true
        }
    }

    override fun onItemSelected(item: Item?) {
        if (telaUnica) {
            // Atualiza o framelayout com o fragment
            val detalheItemFragment = DetalheItemFragment.newInstance(item!!)
            val ft =
                supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, detalheItemFragment)
            ft.commit()
        } else {
            //Inicia a Activity de detalhe caso não seja um tablet
            val i = Intent(this, DetalheItemActivity::class.java)
            i.putExtra("item", item)
            startActivity(i)
        }
    }
}