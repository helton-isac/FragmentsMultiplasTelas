package com.hitg.fragmentsmultiplastelas.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.hitg.fragmentsmultiplastelas.R
import com.hitg.fragmentsmultiplastelas.models.Item

class DetalheItemFragment : Fragment() {
    private var item: Item? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable("item")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_detalhe_item,
            container, false
        )
        val tvTitle = view.findViewById(R.id.tvTitulo) as TextView
        val tvBody = view.findViewById(R.id.tvSubtitulo) as TextView
        tvTitle.text = item?.title
        tvBody.text = item?.body
        return view
    }

    companion object {
        fun newInstance(item: Item): DetalheItemFragment {
            val fragmentDemo = DetalheItemFragment()
            val args = Bundle()
            args.putParcelable("item", item)
            fragmentDemo.arguments = args
            return fragmentDemo
        }
    }
}