package tech.vmmpl.com.vaaishnomaametalinks;

import android.app.Application;
import android.text.TextUtils;


import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppController extends Application {

    private static AppController mInstance;
    public final static String TAG = AppController.class.getSimpleName();



    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("times.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }



    public static synchronized AppController getInstance() {
        return mInstance;
    }

}
