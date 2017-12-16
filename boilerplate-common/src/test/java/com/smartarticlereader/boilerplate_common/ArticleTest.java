package com.smartarticlereader.boilerplate_common;


import com.kohlschutter.boilerpipe.BoilerpipeProcessingException;
import com.kohlschutter.boilerpipe.extractors.ArticleExtractor;

import org.junit.Test;

public class ArticleTest {
   @Test
    public void shouldRunWithNoError() throws BoilerpipeProcessingException {
       ArticleExtractor.INSTANCE.getText("");
   }
}