package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

import static data.TestData.defaulfDownloadFolderPath;
import static data.TestData.downloadFolderPath;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.downloadsFolder = downloadFolderPath;
    }

    @AfterEach
    void deleteFiles() throws IOException {
        if (Configuration.downloadsFolder != null)
            FileUtils.deleteDirectory(new File(downloadFolderPath));
        else
            FileUtils.deleteDirectory(new File(defaulfDownloadFolderPath));
    }
}
