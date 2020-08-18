package com.grizzlynt.reviews;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;


final class GNTReviewPreferenceHelper {

    private static final String PREF_FILE_NAME = "android_rate_pref_file";

    private static final String PREF_KEY_INSTALL_DATE = "android_rate_install_date";

    private static final String PREF_KEY_LAUNCH_TIMES = "android_rate_launch_times";

    private static final String PREF_KEY_REMIND_INTERVAL = "android_rate_remind_interval";

    private GNTReviewPreferenceHelper() {
    }

    static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    static SharedPreferences.Editor getPreferencesEditor(Context context) {
        return getPreferences(context).edit();
    }

    /**
     * Clear data in shared preferences.<br/>
     *
     * @param context context
     */
    static void setRemindIntervalDate(Context context) {
        SharedPreferences.Editor editor = getPreferencesEditor(context);
        editor.remove(PREF_KEY_REMIND_INTERVAL);
        editor.putLong(PREF_KEY_REMIND_INTERVAL, new Date().getTime());
        editor.apply();
    }

    static long getRemindInterval(Context context) {
        return getPreferences(context).getLong(PREF_KEY_REMIND_INTERVAL, 0);
    }

    static void setInstallDate(Context context) {
        SharedPreferences.Editor editor = getPreferencesEditor(context);
        editor.putLong(PREF_KEY_INSTALL_DATE, new Date().getTime());
        editor.apply();
    }

    static long getInstallDate(Context context) {
        return getPreferences(context).getLong(PREF_KEY_INSTALL_DATE, 0);
    }

    static void setLaunchTimes(Context context, int launchTimes) {
        SharedPreferences.Editor editor = getPreferencesEditor(context);
        editor.putInt(PREF_KEY_LAUNCH_TIMES, launchTimes);
        editor.apply();
    }

    static int getLaunchTimes(Context context) {
        return getPreferences(context).getInt(PREF_KEY_LAUNCH_TIMES, 0);
    }

    static boolean isFirstLaunch(Context context) {
        return getPreferences(context).getLong(PREF_KEY_INSTALL_DATE, 0) == 0L;
    }
}

