package vingle.hucet.com.vingle.view

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import vingle.hucet.com.vingle.R
import vingle.hucet.com.vingle.deeplink.AppDeepLinkModule
import vingle.hucet.com.vingle.deeplink.AppDeepLinkModuleLoader

/**
 * Created by taesu on 2017-12-04.
 */
@DeepLinkHandler(AppDeepLinkModule::class)
class DeepLinkActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)

        val deepLinkDelegate = DeepLinkDelegate(AppDeepLinkModuleLoader())
        deepLinkDelegate.dispatchFrom(this)
        finish()
    }
}
