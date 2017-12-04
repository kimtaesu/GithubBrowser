package vingle.hucet.com.vingle

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.StrictMode
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import vingle.hucet.com.vingle.debug.OptionalTree
import vingle.hucet.com.vingle.di.AppInjector
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

/**
 * Created by taesu on 2017-12-04.
 */
class MyApplication : Application(), HasActivityInjector {

    override fun onCreate() {
        super.onCreate()
        initDagger()
        initTimber()
        initStrictMode()
        initStetho()
    }


    private fun initDagger() {
        AppInjector.init(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(OptionalTree(threadName = true))
        }
    }

    private fun initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build())
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())
        }
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            try {
                val stethoClazz = Class.forName("com.facebook.stetho.Stetho")
                val method = stethoClazz.getMethod("initializeWithDefaults", Context::class.java)
                method.invoke(null, this)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            }
        }
    }

    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}