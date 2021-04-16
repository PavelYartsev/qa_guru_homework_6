package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.open;
import static data.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;
import static utils.Zip.unzip;

public class DownloadFileTests extends TestBase {

    @Test
    void selenideDownloadFileTest() throws IOException {
        open(fileLink);
        File downloadedFIle = downloadFileSelector.download();
        String fileContent = FileUtils.readFileToString(downloadedFIle, StandardCharsets.UTF_8);
        assertThat(fileContent, containsString(expectedTxtData));
    }

    @Test
    void txtFileTest() throws IOException {
        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedTxtData));
    }

    @Test
    void csvFileTest() throws IOException {
        String actualData = readTextFromPath(csvFilePath);
        assertThat(actualData, containsString(expectedCsvData));
    }

    @Test
    void pdfFileTest() throws IOException {
        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedPdfData));
    }

    @Test
    void xlsFileTest() throws IOException {
        XLS xlsFile = getXls(xlsFilePath);
        assertThat(xlsFile, XLS.containsText(expectedXlsData));
    }

    @Test
    void xlsCellTest() {
        XLS xlsFile = new XLS(new File(xlsFilePath));
        String actualData = xlsFile.excel.getSheetAt(0).getRow(2).getCell(2).toString();
        assertThat(actualData, containsString(expectedXlsCellData));
    }

    //This test can be used only with com.codeborne:xls-test version 1.4.3 version
    @Test
    void xlsxFileTest() throws IOException {
        XLS xlsFile = getXls(xlsxFilePath);
        assertThat(xlsFile, XLS.containsText(expectedXlsxData));
    }

    @Test
    void xlsxFileTestUsingPoi() {
        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedXlsxData));
    }

    @Test
    void xlsxCellTest() throws IOException, InvalidFormatException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new File(xlsxFilePath));

        String actualData = myExcelBook.getSheet("Sheet 2").getRow(2).getCell(2).toString();
        assertThat(actualData, containsString(expectedXlsCellData));
    }

    @Test
    void zipFilePasswordTest() throws IOException, ZipException {
        unzip(zipFilePasswordPath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedZipData));

        FileUtils.deleteDirectory(new File(unzipFolderPath));
    }

    @Test
    void zipFileWithoutPasswordTest() throws IOException {
        unzip(zipFilePath, unzipFolderPath);

        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedZipData));

        FileUtils.deleteDirectory(new File(unzipFolderPath));
    }

    @Test
    void docFileTest() {
        String actualData = getTextFromDocFile(docFilePath);
        assertThat(actualData, containsString(expectedDocData));
    }

    @Test
    void docxFileTest() {
        String actualData = getTextFromDocxFile(docxFilePath);
        assertThat(actualData, containsString(expectedDocxData));
    }
}
