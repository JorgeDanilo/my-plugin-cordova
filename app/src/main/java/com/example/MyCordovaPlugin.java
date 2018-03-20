/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.app.Service;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.ContactsContract;
import android.widget.Toast;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;


public class MyCordovaPlugin extends CordovaPlugin {

    private static final String TAG = "MyCordovaPlugin";
    CordovaInterface mCordova;
    BroadcastReceiver mReceiver;

    /**
     * Initialize cordova plugin.
     * @param cordova
     * @param webView
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Log.d(TAG, "Initializing MyCordovaPlugin");
        super.initialize(cordova, webView);
        this.mCordova = cordova;
        startContactLookService();
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
         return false;
    }

    public void startContactLookService() {
         Context context = this.mCordova.getActivity();
         Intent intent = new Intent(context, ContactWathService.class);
         context.startService(intent);
    }

}

