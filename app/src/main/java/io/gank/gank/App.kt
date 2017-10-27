package io.gank.gank

import android.app.Application
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.interceptor.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * Created by admin on 2017/10/18.
 */

class App : Application() {

    companion object {
        val instance: App by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { App() }
    }

    override fun onCreate() {
        super.onCreate()

        initOkGo()
    }

    private fun initOkGo() {
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor("http");
        if (BuildConfig.DEBUG) {
            interceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY)
            interceptor.setColorLevel(Level.INFO)
        } else {
            interceptor.setPrintLevel(HttpLoggingInterceptor.Level.NONE);
        }
        builder.readTimeout(AppConfig.ReadTimeout, TimeUnit.SECONDS)
        builder.connectTimeout(AppConfig.ConnectTimeout, TimeUnit.SECONDS)
        builder.writeTimeout(AppConfig.WriteTimeout, TimeUnit.SECONDS)
        builder.addInterceptor(interceptor)
        OkGo.getInstance().init(instance)
                .setOkHttpClient(builder.build())
                .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)//缓存模式 先使用缓存，不管是否存在，仍然请求网络
                .setCacheTime(AppConfig.CacheTime)
                .setRetryCount(AppConfig.RetryCount)
    }
}


