package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Constants;
import web.WebForm;

public class imdbTest {
    private static final WebDriver driver = new ChromeDriver();
    WebForm webForm = new WebForm(driver);
    String firstDn, firstSn, firstWn, secondDn, secondSn, seconWn;


    @BeforeSuite
    public void before() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "IMDB adresine gidilir -> Menüden filme istenilen yol ile gidilir -> İstenen bilgiler tutulur" + "-> Bir de arama yapılarak filme gidilir " +
            "-> Bilgiler kıyaslanılır. -> Görseller kırık mı diye kontrol edilir. (2 film için) ")
    public void checkMovieInfosAndImages() throws InterruptedException {
        driver.get(Constants.IMDB_URL);
        driver.manage().window().maximize();
        webForm.clickMenuButton();
        webForm.clickOnOscars();
        webForm.chooseYearOfTheOscarMovies();
        webForm.clicktheFirstMovie();
        webForm.getMovieInfos();
        firstDn = webForm.getDirectorsName();
        firstSn = webForm.getStarsName();
        firstWn = webForm.getWritersName();
        webForm.clickTheLogo();
        webForm.searchForTheFirstMovie();
        webForm.clicktheFirstMovie();
        webForm.getMovieInfos();
        secondDn = webForm.getDirectorsName();
        secondSn = webForm.getStarsName();
        seconWn = webForm.getWritersName();
        AssertJUnit.assertEquals(firstDn, secondDn);
        AssertJUnit.assertEquals(firstSn, secondSn);
        AssertJUnit.assertEquals(firstWn, seconWn);
        webForm.checkPhotos();

        //2.filmin kontrolü
        webForm.clickTheLogo();
        webForm.clickMenuButton();
        webForm.clickOnOscars();
        webForm.chooseYearOfTheOscarMovies();
        webForm.clicktheSecondMovie();
        webForm.getMovieInfosWithVideoOnes();
        firstDn = webForm.getDirectorsName();
        firstSn = webForm.getStarsName();
        firstWn = webForm.getWritersName();
        webForm.clickTheLogo();
        webForm.searchForTheSecondMovie();
        webForm.clicktheSecondMovie();
        webForm.getMovieInfosWithVideoOnes();
        secondDn = webForm.getDirectorsName();
        secondSn = webForm.getStarsName();
        seconWn = webForm.getWritersName();
        AssertJUnit.assertEquals(firstDn, secondDn);
        AssertJUnit.assertEquals(firstSn, secondSn);
        AssertJUnit.assertEquals(firstWn, seconWn);
        webForm.checkPhotos();
    }







}