package com.rmuhamed.params.app.client.view.config

import android.content.Context
import androidx.appcompat.widget.LinearLayoutCompat
import com.rmuhamed.params.app.client.view.IpAddressInputField
import com.rmuhamed.params.app.client.viewobject.Param
import com.rmuhamed.params.app.client.viewobject.justReadOnly

class IpAddressFieldStrategy : InputFieldStrategy<LinearLayoutCompat> {
    override fun execute(context: Context, param: Param): LinearLayoutCompat {
        return IpAddressInputField(context, param.justReadOnly())
    }
}