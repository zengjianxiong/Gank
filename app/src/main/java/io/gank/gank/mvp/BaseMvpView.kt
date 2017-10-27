package io.gank.gank.mvp

import android.content.Context
import android.support.annotation.StringRes

/**
 * description:Data：2017/10/27-14:07
 * @author admin
 *
 */
interface BaseMvpView {

    fun getContext(): Context

    fun showError(error: String)

    fun showError(@StringRes stringResId: Int)

    fun showMessage(@StringRes srtResId: Int)

    fun showMessage(message: String)

}