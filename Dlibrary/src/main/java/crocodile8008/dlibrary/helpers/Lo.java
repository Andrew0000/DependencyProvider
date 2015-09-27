package crocodile8008.dlibrary.helpers;

import android.util.Log;

public class Lo {

    private static final String LOG_TAG = "Dependency lib";
    private static final boolean NEED_LOG = true;

    public static void v(String s, String s2) {
        Lo.v(s2);
    }

    public static void v(String s) {
        if (NEED_LOG) {
            Log.v(LOG_TAG, s);
        }
    }

    public static void d(String s, String s2) {
        Lo.d(s2);
    }

    public static void d(String s) {
        if (NEED_LOG) {
            Log.d(LOG_TAG, s);
        }
    }

    public static void i(String s, String s2) {
        Lo.i(s2);
    }

    public static void i(String s) {
        if (NEED_LOG) {
            Log.i(LOG_TAG, s);
        }
    }

    public static void w(String s, String s2) {
        Lo.w(s2);
    }

    public static void w(String s) {
        if (NEED_LOG) {
            Log.w(LOG_TAG, s);
        }
    }

    public static void e(String s, String s2) {
        Lo.e(s2);
    }

    public static void e(String s) {
        if (NEED_LOG) {
            Log.e(LOG_TAG, s);
        }
    }

}
