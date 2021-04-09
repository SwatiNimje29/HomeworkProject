package org.selenide.examples;
        import com.codeborne.selenide.CollectionCondition;
        import org.junit.Test;
        import org.openqa.selenium.By;

        import static com.codeborne.selenide.CollectionCondition.empty;
        import static com.codeborne.selenide.CollectionCondition.size;
        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selenide.*;

public class GameOfThronesTest {
    @Test
    public void user (){
        open("https://imdb.com");
        $(By.id("suggestion-search")).setValue("games of thrones") .pressEnter();
        $$("table.findList tr.findResult").findBy(text("(2012) (Video Game)")).find("a").click();
    }
}
