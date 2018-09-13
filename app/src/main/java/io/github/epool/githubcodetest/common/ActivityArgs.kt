package io.github.epool.githubcodetest.common

import android.content.Context
import android.content.Intent
import android.os.Parcelable

interface ActivityArgs : Parcelable {

    /**
     * @return Returns an Intent that can be used to launch this Activity.
     */
    fun intent(context: Context): Intent

    /**
     * Launches this Activity given your Activity context.
     *
     * The default implementation uses the Intent generated from [intent].
     */
    fun launch(context: Context?) = context?.startActivity(intent(context)) ?: Unit

}