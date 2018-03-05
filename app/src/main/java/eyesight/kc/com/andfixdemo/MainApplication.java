package eyesight.kc.com.andfixdemo;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by shangji.qi on 2018/3/5.
 */

public class MainApplication extends Application {

    private static final String TAG = " andrew";

    private static final String APATCH_PATH = "/out.apatch";

    private static final String DIR = "apatch";//补丁文件夹
    private PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mPatchManager = new PatchManager(this);
        mPatchManager.init("1.0");

        Log.d(TAG, "onCreate: init andfix");
        mPatchManager.loadPatch();


        try {
            String appathFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + APATCH_PATH;
            mPatchManager.addPatch(appathFilePath);
            Log.d(TAG, "apatch:" + appathFilePath + " added.");

            Log.d(TAG, "onCreate: huoquwenjianjia"+this.getFilesDir());
            File file=new File(this.getFilesDir(),DIR+APATCH_PATH);
            if (file.exists()){
                boolean delete = new File(appathFilePath).delete();
                if (!delete){
                    Log.e(TAG, appathFilePath + " delete fail");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
