package com.smartarticlereader.sample;

import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;

import com.kohlschutter.boilerpipe.BoilerpipeProcessingException;
import com.kohlschutter.boilerpipe.extractors.ArticleExtractor;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by davut on 12/17/2017.
 */

public class ArticleLoaderTask extends AsyncTask<String , String , String> {
    public static final String MOBILE_USER_AGENT = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3";
    public static final String TAG = ArticleLoaderTask.class.getSimpleName();
    private Response response;
    WebView webView;
    private String url;

    public ArticleLoaderTask(WebView webView) {
        this.webView = webView;
    }

    @Override
    protected String doInBackground(String... urls) {
        this.url = urls[0];
        try {
            OkHttpClient client = new OkHttpClient.Builder().build();
            Call call =  client.newCall(new Request.Builder().header("User-Agent", MOBILE_USER_AGENT).url(url).build());
            this.response =  call.execute();
            if(!response.isSuccessful())
                return null;
            return asArticle(response.body().string());
        } catch (Exception e)
        {
            Log.e(TAG, "doInBackground: ",e );
            return null;
        }
    }

    private String asArticle(String string) {
        try {
            return ArticleExtractor.INSTANCE.getText(string);
        } catch (BoilerpipeProcessingException e) {
            Log.e(TAG, "asArticle: ",e );
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
       if(result != null)
           webView.loadDataWithBaseURL(url , result , "text/html" , "utf-8" , null );
       else
           webView.loadData( "Failed" , "text/html" , "utf-8" );
    }
}
