package io.gank.gank.ui.activity.main

import io.gank.gank.mvp.BaseMvpPresenter
import io.gank.gank.mvp.BaseMvpView

/**
 * description:Data：2017/10/27-14:57
 * @author admin
 *
 */
class MainContract {
    interface IView : BaseMvpView {

    }

    interface IPresenter : BaseMvpPresenter<IView> {

    }
}