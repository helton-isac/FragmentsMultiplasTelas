package com.hitg.fragmentsmultiplastelas.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hitg.fragmentsmultiplastelas.R
import com.hitg.fragmentsmultiplastelas.models.Item
import com.hitg.fragmentsmultiplastelas.views.fragments.DetalheItemFragment

class DetalheItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalhe_item)

        val item = intent.getParcelableExtra("item") as Item

        if (savedInstanceState == null) {
            val detalheItemFragment = DetalheItemFragment.newInstance(item)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, detalheItemFragment)
            ft.commit()
        }
    }
}
