package com.rmuhamed.params.app.client.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.rmuhamed.params.app.client.ClientApp
import com.rmuhamed.params.app.client.R
import com.rmuhamed.params.providerlibrary.repository.ParamFactory
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository

class ParamAddNewFragment : Fragment() {

    private lateinit var repository: ParameterRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.param_add_new_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        repository = (activity?.application as ClientApp).repository
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameField = view.findViewById<EditText>(R.id.name)
        val formatField = view.findViewById<EditText>(R.id.format)

        view.findViewById<FloatingActionButton>(R.id.add_new_param).setOnClickListener {
            val name = nameField.text.toString()
            val format = formatField.text.toString()

            val result = repository.add(ParamFactory.create(name, format))

            if (result.get()) {
                nameField.text.clear()
                formatField.text.clear()
                Snackbar.make(view, R.string.creation_success, Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(view, R.string.creation_error, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}