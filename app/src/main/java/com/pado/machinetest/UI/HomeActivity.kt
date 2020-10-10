package com.pado.machinetest.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.pado.demo.Utils.Status
import com.pado.machinetest.Data.Models.DataItem
import com.pado.machinetest.R
import com.pado.machinetest.UI.Adapter.SimpleFragmentPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    val viewModel:HomeViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
viewModel.getBrands().observe(this, Observer {
    it.status?.let {it1->
        when(it1)
        {
            Status.SUCCESS->{
              it.data?.data?.let {list ->
                  processData(list)

              }
            }
            Status.LOADING->{

            }
            Status.ERROR->{

            }
        }
    }
})
    }

    private fun processData(list: List<DataItem>) {
        var alist=ArrayList<String>()
        list.forEach{
            tabLayout.addTab(tabLayout.newTab().setText(it.name))
            it.name?.let { it1 -> alist.add(it1) }
        }
        var adapter=SimpleFragmentPagerAdapter(this,supportFragmentManager,list.size,alist)
        pager.offscreenPageLimit=1
        pager.adapter=adapter
       tabLayout.setupWithViewPager(pager)
        pager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }
}