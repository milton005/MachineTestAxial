package com.pado.machinetest.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.pado.demo.Utils.Resource
import com.pado.demo.Utils.Status
import com.pado.machinetest.R
import com.pado.machinetest.Utils.Preferencemanager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initClicks()

    }

    private fun initClicks() {
        button.setOnClickListener{
            checkLogin()
        }
    }

    private fun checkLogin() {
        val e=email.text.toString().trim()
        val d=password.text.toString().trim()
        if (!e.isNullOrEmpty()&&!d.isNullOrEmpty())
        {
            viewModel.login(e,d).observe(this , Observer {
               it.status?.let { it1->
                   when(it1)
                   {
                       Status.SUCCESS->{
                            it.data?.data?.accessToken?.let {data->
                                Preferencemanager.getUtils().savePref("access_token",data)
                                val intent= Intent(this,HomeActivity::class.java)
                                startActivity(intent)
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

    }

}