package org.selenide.examples;
import com.codeborne.selenide.*;
import org.apache.hc.core5.util.Timeout;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GameOfThronesTest {
    By suggestionSearch = By.id("suggestion-search");
    By findList = By.className("findList");
    By slate = By.className("slate");

    @Test
    public void user () throws InterruptedException {

        String pageTitle = "Game of Thrones (Video Game 2012) - IMDb";
        String suggestionValue = "games of thrones";

        open("https://imdb.com");
        Selenide.screenshot("imdb");
        $(suggestionSearch).setValue(suggestionValue) .pressEnter();
        Selenide.screenshot("searched-games-of-throne");
        System.out.println("Games of thrones video page url ="+ $(findList).find("tbody:first-of-type").findAll("td").find(Condition.matchText("Video Game")).find("a").attr("href"));
        $(findList).find("tbody:first-of-type").findAll("td").find(Condition.matchText("Video Game")).find("a").click();
        Selenide.screenshot("searched-games-of-throne-url");
        System.out.println("Video Element url = " +$(slate).find("a").attr("href"));
       // $(By.className("video-player__video")).shouldBe(Condition.visible, Duration.ofMinutes(3));
        Assert.assertEquals(pageTitle,title());
        closeWindow();
    }
}
