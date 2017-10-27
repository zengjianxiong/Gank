package io.gank.gank.mvp

/**
 * description:Data：2017/10/27-14:13
 * @author admin
 *
 */
open class BaseMvpPresenterImpl<V : BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}