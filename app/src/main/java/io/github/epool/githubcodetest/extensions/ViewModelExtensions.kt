package io.github.epool.githubcodetest.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import io.github.epool.githubcodetest.factories.ViewModelFactory
import io.reactivex.Flowable

inline fun <reified VM : ViewModel> FragmentActivity.getViewModel() =
        ViewModelProviders.of(this, ViewModelFactory)[VM::class.java]

inline fun <reified T> Flowable<T>.toLiveData(): LiveData<T> =
        LiveDataReactiveStreams.fromPublisher(this)