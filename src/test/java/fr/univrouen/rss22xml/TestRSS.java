package fr.univrouen.rss22xml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestRSS {
    public String loadFileXML() {

        Resource resource =  new DefaultResourceLoader().getResource("classpath:xml/feed.xml");
        try (Reader reader = new InputStreamReader(((InputStreamSource) resource).getInputStream())) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }



}