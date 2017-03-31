package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Iuri Menin on 31/03/17.
 */
@RunWith(AndroidJUnit4.class)
public class NonEmptyStringTest implements CallBackInterface {

    private static final String LOG_TAG = "NonEmptyStringTest";

    @Test
    public void testString() {

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
