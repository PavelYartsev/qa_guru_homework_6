package data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TestData {
    public static final String
            fileLink = "https://github.com/PavelYartsev/qa_guru_homework_6/blob/master/src/test/resources/files/File.txt",
            txtFilePath = "./src/test/resources/files/File.txt",
            expectedTxtData = "This is test .txt file",
            csvFilePath = "./src/test/resources/files/File.csv",
            expectedCsvData = "This is .csv test file",
            pdfFilePath = "./src/test/resources/files/File.pdf",
            expectedPdfData = "This is .pdf test file",
            xlsFilePath = "./src/test/resources/files/File.xls",
            expectedXlsData = "This is .xls test file",
            expectedXlsCellData = "QA_GURU homework 6",
            xlsxFilePath = "./src/test/resources/files/File.xlsx",
            expectedXlsxData = "This is .xlsx test file",
            zipFilePasswordPath = "./src/test/resources/files/FilePassword.zip",
            unzipFolderPath = "./src/test/resources/files/unzip",
            unzipTxtFilePath = "./src/test/resources/files/unzip/File.txt",
            zipPassword = "1234",
            expectedZipData = "This is file for test zip-archive",
            zipFilePath = "./src/test/resources/files/File.zip",
            docFilePath = "./src/test/resources/files/File.doc",
            expectedDocData = "This is .doc test file",
            docxFilePath = "./src/test/resources/files/File.docx",
            expectedDocxData = "This is test .docx file",
            defaulfDownloadFolderPath = "build/downloads",
            downloadFolderPath = "downloadsForTests";

    public static final SelenideElement downloadFileSelector = $("#raw-url");
}
