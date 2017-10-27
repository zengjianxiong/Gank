package io.gank.gank.ui.activity.main


import android.os.Bundle
import android.view.View
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton

import com.qmuiteam.qmui.util.QMUIResHelper
import com.qmuiteam.qmui.widget.QMUITabSegment
import io.gank.gank.R

import io.gank.gank.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseMvpActivity<MainContract.IView, MainContract.IPresenter>(), View.OnClickListener {
    override fun onClick(view: View?) {
        when (view?.id) {
            leftBackButton?.id -> finish()
            else -> {

            }
        }
    }

    private var leftBackButton: QMUIAlphaImageButton? = null

    companion object {
        private const val TAG = "MainActivity"
    }

    override var mPresenter: MainContract.IPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()
        initTab();


    }

    private fun initTab() {
        val normalColor: Int = QMUIResHelper.getAttrColor(this, R.attr.qmui_config_color_gray_6)
        val selectColor: Int = QMUIResHelper.getAttrColor(this, R.attr.qmui_config_color_blue)

        tabSegment.setDefaultNormalColor(normalColor)
        tabSegment.setDefaultSelectedColor(selectColor)
        val androidTab = QMUITabSegment.Tab("Android")
        val iosTab = QMUITabSegment.Tab("IOS")
        val girlTab = QMUITabSegment.Tab("妹子")
        tabSegment.addTab(androidTab)
                .addTab(iosTab)
                .addTab(girlTab)

    }

    private fun initView() {


        topBar.setTitle(R.string.string_main_title)
        leftBackButton = topBar.addLeftBackImageButton()
        leftBackButton?.setChangeAlphaWhenDisable(true)
        leftBackButton?.setOnClickListener(this)


    }


}
