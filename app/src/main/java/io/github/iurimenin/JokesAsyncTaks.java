package io.github.iurimenin;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;

import io.github.iurimenin.jokes.backend.myApi.MyApi;

/**
 * Created by Iuri Menin on 30/03/17.
 */

public class JokesAsyncTaks extends AsyncTask<Object, Void, String> {

    private MainActivity mMainActivity;
    private static MyApi myApiService = null;
    private ProgressDialog mProgressDialog;


    public JokesAsyncTaks (MainActivity mainActivity) {
        this.mMainActivity = mainActivity;
        mProgressDialog = new ProgressDialog(this.mMainActivity);
        mProgressDialog.setMessage(mMainActivity.getString(R.string.loading_joke));
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    @Override
    protected String doInBackground(Object[] objects) {

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //.setRootUrl("http://10.0.2.2:8080/_ah/api/") //Emulador
                    .setRootUrl("http://192.168.0.142:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        mProgressDialog.dismiss();
        this.mMainActivity.launchJokeActivity(joke);
    }
}
