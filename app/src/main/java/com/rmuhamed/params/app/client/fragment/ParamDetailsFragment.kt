package com.rmuhamed.params.app.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.rmuhamed.params.app.client.viewobject.Param
import com.rmuhamed.params.app.client.viewobject.passwordRequiredBeforeSave
import com.rmuhamed.params.app.client.view.config.InputFieldContext
import com.rmuhamed.params.app.client.R

class ParamDetailsFragment : Fragment() {

    private val param = lazy<Param?> {
        arguments?.getParcelable(PARAM)
    }

    private val passwordDialog = lazy {
        buildPasswordDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.param_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val container = view.findViewById<FrameLayout>(R.id.param_field_container)
        val title = view.findViewById<AppCompatTextView>(R.id.param_title)
        val saveButton = view.findViewById<AppCompatButton>(R.id.save_button)
        saveButton.setOnClickListener {
            if (param.value?.passwordRequiredBeforeSave() == true) {
                passwordDialog.value.show()
            }
        }

        param.value?.let {
            title.text = it.name
            val paramView = InputFieldContext.by(it.format).execute(context!!, it)

            container.addView(paramView)
        }
    }

    private fun buildPasswordDialog() =
        AlertDialog.Builder(context!!)
            .setView(R.layout.password_field)
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }.setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }.create()

    companion object {
        const val PARAM = "PARAM"
    }
}
