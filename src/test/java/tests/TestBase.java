package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

public class TestBase {
    private static final String defaulfDownloadFolderPath = "build/downloads";
    private static String downloadFolderPath = "downloadsForTests";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.downloadsFolder = downloadFolderPath;
    }

    @AfterEach
    void deleteFiles() throws IOException {
        FileUtils.deleteDirectory(new File(downloadFolderPath));
        FileUtils.deleteDirectory(new File(defaulfDownloadFolderPath));
    }
}
