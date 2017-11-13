package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Calculatorpage {
    static WebDriver driver;
    static WebDriverWait wait;
    String button = "%s";

    By resultBox = By.id("1000");
    By equal = By.name("=");


   public Calculatorpage(WebDriver driver) { this.driver = driver; }

    public String calculate(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            driver.findElement(By.name(String.format(button, expression.charAt(i)))).click();
        }

        driver.findElement(equal).click();
        return driver.findElement(resultBox).getText();
    }




}
