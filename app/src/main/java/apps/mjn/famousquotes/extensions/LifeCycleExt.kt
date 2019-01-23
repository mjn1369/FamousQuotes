package apps.mjn.famousquotes.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import apps.mjn.famousquotes.ui.model.Resource

fun <T : Any, L : LiveData<Resource<T>>> LifecycleOwner.observe(liveData: L, body: (Resource<T>?) -> Unit) =
    liveData.observe(this, Observer(body))