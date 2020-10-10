package com.pado.machinetest.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.pado.demo.Utils.Status
import com.pado.machinetest.Data.Models.Products.DataItem
import com.pado.machinetest.R
import com.pado.machinetest.UI.Adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dynamic.*
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DynamicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class DynamicFragment : Fragment() {
    var page=1
    var sort_by=""
    @Inject lateinit var adapter: ProductAdapter

private val viewmodel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initUi()
    }

    private fun getData() {

        activity?.let {
            viewmodel.getProducts(page.toString(),sort_by).observe(it, Observer {
                it.status?.let {
                    status ->
                    when(status)
                    {
                        Status.LOADING->{

                        }
                        Status.SUCCESS->{
                        it.data?.data?.let {list->
                            processdata(list)
                        }

                        }
                        Status.ERROR->{

                        }
                    }
                }

            })
        }
    }

    private fun processdata(list: List<DataItem>) {
        adapter.submitList(list)
    }

    private fun initUi() {
        var layoutManager=activity?.let {
            GridLayoutManager(it,2)
        }
        recycler.layoutManager=layoutManager
        recycler.adapter=adapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DynamicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            DynamicFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}