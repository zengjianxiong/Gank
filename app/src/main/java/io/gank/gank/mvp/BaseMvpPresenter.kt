package io.gank.gank.mvp

/**
 * description:Data：2017/10/27-14:10
 * @author admin
 *
 */
interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(view: V)

    fun detachView()
}