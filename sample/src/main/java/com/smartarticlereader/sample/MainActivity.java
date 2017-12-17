package com.smartarticlereader.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.webView = findViewById(R.id.webView);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.button = findViewById(R.id.btnSubmit);
        button.setOnClickListener(this);
        editText = findViewById(R.id.txtUrl);
    }

    @Override
    public void onClick(View v) {
        ArticleLoaderTask articleLoaderTask = new ArticleLoaderTask(webView);
        articleLoaderTask.execute(this.editText.getText().toString());
    }
}
