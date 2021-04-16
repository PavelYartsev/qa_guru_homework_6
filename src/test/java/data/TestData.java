package data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TestData {
    public static final String fileLink = "https://github.com/PavelYartsev/qa_guru_homework_6/blob/master/src/test/resources/files/File.txt";
    public static final SelenideElement downloadFileSelector = $("#raw-url");
    public static final String txtFilePath = "./src/test/resources/files/File.txt";
    public static final String expectedTxtData = "This is test .txt file";
    public static final String csvFilePath = "./src/test/resources/files/File.csv";
    public static final String expectedCsvData = "This is .csv test file";
    public static final String pdfFilePath = "./src/test/resources/files/File.pdf";
    public static final String expectedPdfData = "This is .pdf test file";
    public static final String xlsFilePath = "./src/test/resources/files/File.xls";
    public static final String expectedXlsData = "This is .xls test file";
    public static final String expectedXlsCellData = "QA_GURU homework 6";
    public static final String xlsxFilePath = "./src/test/resources/files/File.xlsx";
    public static final String expectedXlsxData = "This is .xlsx test file";
    public static final String zipFilePasswordPath = "./src/test/resources/files/FilePassword.zip";
    public static final String unzipFolderPath = "./src/test/resources/files/unzip";
    public static final String unzipTxtFilePath = "./src/test/resources/files/unzip/File.txt";
    public static final String zipPassword = "1234";
    public static final String expectedZipData = "This is file for test zip-archive";
    public static final String zipFilePath = "./src/test/resources/files/File.zip";
    public static final String docFilePath = "./src/test/resources/files/File.doc";
    public static final String expectedDocData = "This is .doc test file";
    public static final String docxFilePath = "./src/test/resources/files/File.docx";
    public static final String expectedDocxData = "This is test .docx file";
}
