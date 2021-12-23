package web;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.util.List;

public class WebForm extends PageObject {
    String directorsName;
    String writersName;
    String starsName;
    private int invalidImageCount;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#imdbHeader-navDrawerOpen--desktop"))).click();
    }

    public void clickOnOscars() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#imdbHeader > div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner > aside > div > div._3bRJYEaOz1BKUQYqW6yb29 > div > div:nth-child(3) > span > div > div > ul > a:nth-child(2)"))).click();
    }

    public void chooseYearOfTheOscarMovies() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1929"))).click();
    }

    public void clicktheFirstMovie() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("The Circus"))).click();
    }

    public void clicktheSecondMovie() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("The Jazz Singer"))).click();
    }

    public void checkPhotos() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Photos"))).click();
        Thread.sleep(3000);
        invalidPhotoFind();
        try {
            if(driver.findElement(By.cssSelector("#right > a")).isDisplayed()){
                driver.findElement(By.cssSelector("#right > a")).click();
                invalidPhotoFind();
            }
        }
        catch (NoSuchElementException e){
            System.out.println("Bir başka sayfa bulunamadı.");
        }

    }

    public void clickTheLogo() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_img_holder"))).click();
    }

    public void searchForTheFirstMovie() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-search"))).sendKeys(Constants.MOVIE1);
    }

    public void searchForTheSecondMovie() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-search"))).sendKeys(Constants.MOVIE2);
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public String getWritersName() {
        return writersName;
    }

    public String getStarsName() {
        return starsName;
    }

    public void getMovieInfos() throws InterruptedException {
        Thread.sleep(4000);
        directorsName = driver.findElement(By.cssSelector("#__next > main > div > section.ipc-page-background.ipc-page-background--base.TitlePage__StyledPageBackground-wzlr49-0.dDUGgO > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__NoVideo-kvkd64-6.hAJqld > div.Hero__ContentContainer-kvkd64-10.eaUohq > div.Hero__MetaContainer__NoVideo-kvkd64-8.TqBgz > div.PrincipalCredits__PrincipalCreditsPanelWideScreen-hdn81t-0.iGxbgr > ul > li:nth-child(1) > div > ul > li > a")).getText();
        writersName = driver.findElement(By.cssSelector("#__next > main > div.ipc-page-content-container.ipc-page-content-container--full.BaseLayout__NextPageContentContainer-sc-180q5jf-0.fWxmdE > section.ipc-page-background.ipc-page-background--base.TitlePage__StyledPageBackground-wzlr49-0.dDUGgO > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__NoVideo-kvkd64-6.hAJqld > div.Hero__ContentContainer-kvkd64-10.eaUohq > div.Hero__MetaContainer__NoVideo-kvkd64-8.TqBgz > div.PrincipalCredits__PrincipalCreditsPanelWideScreen-hdn81t-0.iGxbgr > ul > li:nth-child(2) > div > ul > li > a")).getText();
        starsName = driver.findElement(By.cssSelector("#__next > main > div.ipc-page-content-container.ipc-page-content-container--full.BaseLayout__NextPageContentContainer-sc-180q5jf-0.fWxmdE > section.ipc-page-background.ipc-page-background--base.TitlePage__StyledPageBackground-wzlr49-0.dDUGgO > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__NoVideo-kvkd64-6.hAJqld > div.Hero__ContentContainer-kvkd64-10.eaUohq > div.Hero__MetaContainer__NoVideo-kvkd64-8.TqBgz > div.PrincipalCredits__PrincipalCreditsPanelWideScreen-hdn81t-0.iGxbgr > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div")).getText();
    }

    public void getMovieInfosWithVideoOnes() throws InterruptedException {
        Thread.sleep(4000);
        directorsName = driver.findElement(By.cssSelector("#__next > main > div > section.ipc-page-background.ipc-page-background--base.TitlePage__StyledPageBackground-wzlr49-0.dDUGgO > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__Video-kvkd64-2.kmTkgc > div.Hero__ContentContainer-kvkd64-10.eaUohq > div.Hero__MetaContainer__Video-kvkd64-4.kNqsIK > div.PrincipalCredits__PrincipalCreditsPanelWideScreen-hdn81t-0.iGxbgr > ul > li:nth-child(1) > div > ul > li > a")).getText();
        writersName = driver.findElement(By.cssSelector("#__next > main > div > section.ipc-page-background.ipc-page-background--base.TitlePage__StyledPageBackground-wzlr49-0.dDUGgO > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__Video-kvkd64-2.kmTkgc > div.Hero__ContentContainer-kvkd64-10.eaUohq > div.Hero__MetaContainer__Video-kvkd64-4.kNqsIK > div.PrincipalCredits__PrincipalCreditsPanelWideScreen-hdn81t-0.iGxbgr > ul > li:nth-child(2) > div")).getText();
        starsName = driver.findElement(By.cssSelector("#__next > main > div > section.ipc-page-background.ipc-page-background--base.TitlePage__StyledPageBackground-wzlr49-0.dDUGgO > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__Video-kvkd64-2.kmTkgc > div.Hero__ContentContainer-kvkd64-10.eaUohq > div.Hero__MetaContainer__Video-kvkd64-4.kNqsIK > div.PrincipalCredits__PrincipalCreditsPanelWideScreen-hdn81t-0.iGxbgr > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div")).getText();
        //System.out.println("Stars name =  "  +  starsName);
    }

    public void invalidPhotoFind(){
        try {
            invalidImageCount = 0;
            List<WebElement> imagesList = driver.findElements(By.tagName("img"));
            System.out.println("Tıklanılan sayfadaki görsel sayısı = " + imagesList.size());
            for (WebElement imgElement : imagesList) {
                if (imgElement != null) {
                    verifyimageActive(imgElement);
                }
            }
            System.out.println("Tıklanılan sayfadaki geçersiz görsel sayısı = "	+ invalidImageCount);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void verifyimageActive(WebElement imgElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imgElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != 200)
                invalidImageCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}