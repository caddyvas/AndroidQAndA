package com.learn.androidqanda.ui.android.fragment.essentialcompfragments.jetpackcompsDemo

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * This class was created as a workaround to tell LiveData:
 *
 * “Emit this event only once and never again, even on configuration changes.”
 *
 * It overrides the normal LiveData behavior by holding an internal flag so that observers only
 * get the event once, even if the observer re-attaches (screen rotation).
 * iveData is great for state, but it was not designed for one-time events like:
 *
 * Toasts
 * Navigation actions
 * Snackbar messages
 * Dialog triggers
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val pending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t->
            if(pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    override fun setValue(value: T?) {
        pending.set(true)
        super.setValue(value)
    }

    fun call() = setValue(null)
}