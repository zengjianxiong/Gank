package io.gank.gank.mvp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import me.yokeyword.fragmentation.SupportActivity

/**
 * @author admin
 */

abstract class BaseMvpActivity< in V : BaseMvpView, T : BaseMvpPresenter<V>> : SupportActivity(), BaseMvpView {



    protected abstract var mPresenter: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter.attachView(this as V)
    }


    override fun getContext(): Context = this
    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    override fun showError(stringResId: Int) {
        Toast.makeText(this, stringResId, Toast.LENGTH_SHORT).show();
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    override fun showMessage(srtResId: Int) {
        Toast.makeText(this, srtResId, Toast.LENGTH_SHORT).show();

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}