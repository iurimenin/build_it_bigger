package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by Iuri Menin on 31/03/17.
 */

public class NonEmptyStringTest extends AndroidTestCase implements CallBackInterface {

    private static final String LOG_TAG = "NonEmptyStringTest";

    @SuppressWarnings("unchecked")
    public void test() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        String result = null;
        JokesAsyncTak jokesAsyncTask = new JokesAsyncTak(this, getContext());
        jokesAsyncTask.execute();
        try {
            result = jokesAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

    @Override
    public void callback(String joke) {

    }
}
