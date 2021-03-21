package com.example.backtest3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_menu.view.*

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    val coffeeList = arrayListOf<Menu_Model>(
        Menu_Model("book", "아메리카노", "2.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5")
    )
    val teaList = arrayListOf<Menu_Model>(
        Menu_Model("book", "아메리카노", "2.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5")
    )
    val teaList1 = arrayListOf<Menu_Model>(
        Menu_Model("book", "아메리카노", "2.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5"),
        Menu_Model("movie", "라떼","3.0"),
        Menu_Model("music","카페라떼","3.5")
    )

    var menu = arrayListOf<Category_Model>(

        Category_Model("coffee", coffeeList),
        Category_Model("tea",teaList),
        Category_Model("Test",teaList1)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val adapter1 = CategoryAdapter(requireContext(),menu)
        view.rcview?.adapter = adapter1

        val lm = LinearLayoutManager(requireContext())
        view.rcview?.layoutManager = lm
        view.rcview?.isNestedScrollingEnabled = true
        view.rcview?.setHasFixedSize(true)
        return view

        /*val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val adapter1 = CategoryAdapter(requireContext(),menu)
        view.rcview?.adapter = adapter1

        val lm = LinearLayoutManager(requireContext())
        view.rcview?.layoutManager = lm.also { it.orientation = LinearLayoutManager.HORIZONTAL }.also { it.isAutoMeasureEnabled=true}
        view.rcview?.isNestedScrollingEnabled = true
        view.rcview?.setHasFixedSize(true)
        return view*/
    }


}
