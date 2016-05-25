package com.theironyard;

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by illladell on 5/25/16.
 */
public class MainTest {
    static final String TEST_FILE_ = "test.json";

    @Test
    public void saveAndLoad() throws IOException {
        HashMap testMap = new HashMap();
        testMap.put("album", "mm...food");
        testMap.put("artist", "mf doom");
        testMap.put("song", "one beer");
        testMap.put("genre", "hip-hop");
        testMap.put("year", "2004");

        Main.WriteJson(testMap, TEST_FILE_);
        HashMap newInput = Main.ReadJson(TEST_FILE_);


        File file = new File(TEST_FILE_);
        file.delete();

        assertTrue(newInput != null);
        assertTrue(newInput.equals(testMap));
    }
}