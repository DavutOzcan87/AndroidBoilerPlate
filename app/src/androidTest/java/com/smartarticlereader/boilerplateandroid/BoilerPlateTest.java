package com.smartarticlereader.boilerplateandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.kohlschutter.boilerpipe.BoilerpipeExtractor;
import com.kohlschutter.boilerpipe.BoilerpipeProcessingException;
import com.kohlschutter.boilerpipe.extractors.ArticleExtractor;
import com.kohlschutter.boilerpipe.extractors.CommonExtractors;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BoilerPlateTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.smartarticlereader.boilerplateandroid", appContext.getPackageName());
    }

    @Test
    public void shouldConvertWebsiteToArticle() throws BoilerpipeProcessingException, IOException {
        String html = getAssetAsString("loremipsum.html");
        assertNotNull(html);
        String extracted = ArticleExtractor.INSTANCE.getText(html);
        System.out.println("Extracted article is");
        System.out.println(extracted);
        assertNotNull(extracted);
    }

    private String getAssetAsString(String assetName) throws IOException {
        Context ctx = InstrumentationRegistry.getContext();
        InputStream is =  ctx.getAssets().open(assetName);
        return inPutStreamToString(is);
    }

    @NonNull
    private String inPutStreamToString(InputStream is) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuilder buf=new StringBuilder();
        String str;
        while ((str=in.readLine()) != null) {
            buf.append(str);
        }
        in.close();
        return buf.toString();
    }
}
