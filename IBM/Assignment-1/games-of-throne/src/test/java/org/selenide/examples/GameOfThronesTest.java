package org.selenide.examples;
import com.codeborne.selenide.*;
import org.apache.hc.core5.util.Timeout;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GameOfThronesTest {
    @Test
    public void user (){
        open("https://imdb.com");
        Selenide.screenshot("imdb");
        $(By.id("suggestion-search")).setValue("games of thrones") .pressEnter();
        Selenide.screenshot("searched-games-of-throne");
        System.out.println("Games of thrones video page url ="+ $(By.className("findList")).find("tbody:first-of-type").findAll("td").find(Condition.matchText("Video Game")).find("a").attr("href"));
        $(By.className("findList")).find("tbody:first-of-type").findAll("td").find(Condition.matchText("Video Game")).find("a").click();
        Selenide.screenshot("searched-games-of-throne-url");
        System.out.println("Video Element url = " +$(By.className("slate")).find("a").attr("href"));
        $(By.className("slate")).find("a").click();
        closeWindow();
    }
}
