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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Files.*;
import static utils.Zip.unzip;

public class DownloadFileTests extends TestBase {

    @Test
    void selenideDownloadFileTest() throws IOException {
        open("https://github.com/PavelYartsev/qa_guru_homework_6/blob/master/src/test/resources/File.txt");
        File downloadedFIle = $("#raw-url").download();
        String fileContent = FileUtils.readFileToString(downloadedFIle, StandardCharsets.UTF_8);
        System.out.println(fileContent);
        assertTrue(fileContent.contains("This is test .txt file"));
        assertThat(fileContent, containsString("This is test .txt file"));
    }

    @Test
    void txtFileTest() throws IOException {
        String txtFilePath = "./src/test/resources/files/File.txt";
        String expectedData = "This is test .txt file";
        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void csvFileTest() throws IOException {
        String csvFilePath = "./src/test/resources/files/File.csv";
        String expectedData = "This is .csv test file";
        String actualData = readTextFromPath(csvFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void pdfFileTest() throws IOException {
        String pdfFilePath = "./src/test/resources/files/File.pdf";
        String expectedData = "This is .pdf test file";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedData));
    }

    @Test
    void xlsFileTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/File.xls";
        String expectedData = "This is .xls test file";

        XLS xlsFile = getXls(xlsFilePath);
        assertThat(xlsFile, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() {
        String xlsFilePath = "./src/test/resources/files/File.xls";
        String expectedData = "QA_GURU homework 6";

        XLS xlsFile = new XLS(new File(xlsFilePath));
        String actualData = xlsFile.excel.getSheetAt(0).getRow(2).getCell(2).toString();
        System.out.println(actualData);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxFileTest() {
        String xlsxFilePath = "./src/test/resources/files/File.xlsx";
        String expectedData = "This is .xlsx test file";
        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxFileCellTest() throws IOException, InvalidFormatException {
        String xlsxFilePath = "./src/test/resources/files/File.xlsx";
        String expectedData = "QA_GURU homework 6";

        XSSFWorkbook myExcelBook = new XSSFWorkbook(new File(xlsxFilePath));

        String actualData = myExcelBook.getSheet("Sheet 2").getRow(2).getCell(2).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void zipFilePasswordTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/FilePassword.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/File.txt";
        String zipPassword = "1234";

        String expectedData = "This is file for test zip-archive";

        unzip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));

        FileUtils.deleteDirectory(new File(unzipFolderPath));
    }

    @Test
    void zipFileWithoutPasswordTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/File.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/File.txt";

        String expectedData = "This is file for test zip-archive";

        unzip(zipFilePath, unzipFolderPath);

        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));

        FileUtils.deleteDirectory(new File(unzipFolderPath));
    }

    @Test
    void docFileTest() {
        String docFilePath = "./src/test/resources/files/File.doc";
        String expectedData = "This is .doc test file";

        String actualData = getTextFromDocFile(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void docxFileTest() {
        String docxFilePath = "./src/test/resources/files/File.docx";
        String expectedData = "This is test .docx file";

        String actualData = getTextFromDocxFile(docxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
