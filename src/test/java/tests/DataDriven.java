package tests;

import objects.Calculatorpage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class DataDriven extends Base {

    private static Calculatorpage calc;

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        calc = new Calculatorpage(driver);
        //calc.open();
    }

    @Before
    public void cleanup() {
        driver.findElement(By.name("Clear")).click();
    }

    @Test
    public void calculator_DataDrivenTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1000")));
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters (name="Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "2+2", "4" },
                { "100+100", "200" },
                { "30/2", "15" },
                { "1-8", "-7" },
                { "1.02+1.001", "2.021" },
                { "32785*2", "65570" },
               // { "10000000/-1111", "-9000.900090009001" },
                { "-1+154", "153" }
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}