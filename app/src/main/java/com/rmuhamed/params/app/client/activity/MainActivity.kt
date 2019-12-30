package com.rmuhamed.params.app.client.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rmuhamed.params.app.client.fragment.ParamAddNewFragment
import com.rmuhamed.params.app.client.fragment.ParamDetailsFragment
import com.rmuhamed.params.app.client.fragment.ParamListFragment
import com.rmuhamed.params.app.client.viewobject.ConfigurationViewObject
import com.rmuhamed.params.app.client.viewobject.EditionOptions
import com.rmuhamed.params.app.client.viewobject.Format
import com.rmuhamed.params.app.client.viewobject.Param
import com.rmuhamed.params.app.client.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
    }

    fun fetchFromProvider(view: View) {
        replaceContainerWith(
            R.id.fragment_container,
            tag = "ParamList",
            fragmentClass = ParamListFragment::class.java
        )
    }

    fun addNewParam(view: View) {
        replaceContainerWith(
            R.id.fragment_container,
            tag = "ParamAddNew",
            fragmentClass = ParamAddNewFragment::class.java
        )
    }

    fun updateParam(view: View) {
        Toast.makeText(this, "Coming soon :D", Toast.LENGTH_SHORT).show()
    }

    fun showAMockedParam(view: View) {
        val param = Param(
            "Numeric param",
            true,
            EditionOptions.PASSWORD_REQUIRED,
            Format.NUMERIC,
            ConfigurationViewObject(maxLength = 16)
        )

        val bundle = Bundle().apply {
            putParcelable(ParamDetailsFragment.Companion.PARAM, param)
        }

        replaceContainerWith(
            R.id.fragment_container,
            "ParaDetails",
            bundle,
            ParamDetailsFragment::class.java
        )
    }
}