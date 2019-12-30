package com.rmuhamed.params.app.client.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.rmuhamed.params.app.client.ClientApp
import com.rmuhamed.params.app.client.R
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository

class ParamListFragment : Fragment() {

    private lateinit var repository: ParameterRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.param_list_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        repository = (activity?.application as ClientApp).repository
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val paramsAdapter = ParamListAdapter(repository.all())

        view.findViewById<RecyclerView>(R.id.param_list).apply {
            adapter = paramsAdapter
            itemAnimator = DefaultItemAnimator()
        }
    }
}