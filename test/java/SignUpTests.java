import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests { //dsfdscdscsdcsd
    @Test
    public void zipCodeTests() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        continueButton.click();
        Assert.assertFalse(driver.findElement(By.name("zip_code")).isDisplayed(), "#1");
        Assert.assertTrue(driver.findElement(By.name("first_name")).isDisplayed(), "#2");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test       // in the zip code field 3 number instead of 5
    public void zipCodeTestsNegative() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123");
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        continueButton.click();
        WebElement element = driver.findElement(By.cssSelector(".error_message"));
        String actualResult = element.getText();
        String expectedResult = "Oops, error on page. ZIP code should have 5 digits";
        Assert.assertEquals(actualResult, expectedResult, "#3");
        Assert.assertTrue(driver.findElement(By.className("error_message")).isDisplayed(), "#4");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test       // in the zip code field, a space instead of numbers
    public void zipCodeTestsNegative1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys(" ");
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        continueButton.click();
        WebElement element = driver.findElement(By.cssSelector(".error_message"));
        String actualResult = element.getText();
        String expectedResult = "Oops, error on page. ZIP code should have 5 digits";
        Assert.assertEquals(actualResult, expectedResult, "5");
        Assert.assertTrue(driver.findElement(By.className("error_message")).isDisplayed(), "#6");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void signUpTests() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.cssSelector("[href='./register.py']"));
        signUp.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        continueButton.click();
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("Sergey");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("qweasd@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("qwe123");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("qwe123");
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        registerButton.click();
        WebElement element = driver.findElement(By.cssSelector(".confirmation_message"));
        String actualResult = element.getText();
        String expectedResult = "Account is created!";
        Assert.assertEquals(actualResult, expectedResult, "#7");
        Assert.assertTrue(driver.findElement(By.className("confirmation_message")).isDisplayed(), "8");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test       // in the first name field, numbers instead of letters
    public void signUpTestsNegative() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.cssSelector("[href='./register.py']"));
        signUp.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        continueButton.click();
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("123456");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("qweasd@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("qwe123");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("qwe123");
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        registerButton.click();
        WebElement element = driver.findElement(By.cssSelector(".error_message"));
        String actualResult = element.getText();
        String expectedResult = "Oops, error on page. Some of your fields have invalid data or email was previously used";
        Assert.assertEquals(actualResult, expectedResult, "#9");
        Assert.assertTrue(driver.findElement(By.className("error_message")).isDisplayed(), "#10");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test       // there is no @ symbol in the email field
    public void signUpTestsNegative1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.cssSelector("[href='./register.py']"));
        signUp.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        continueButton.click();
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("Sergey");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("qweasdgmail.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("qwe123");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("qwe123");
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        registerButton.click();
        WebElement element = driver.findElement(By.cssSelector(".error_message"));
        String actualResult = element.getText();
        String expectedResult = "Oops, error on page. Some of your fields have invalid data or email was previously used";
        Assert.assertEquals(actualResult, expectedResult, "#11");
        Assert.assertTrue(driver.findElement(By.className("error_message")).isDisplayed(), "#12");
        Thread.sleep(10000);
        driver.quit();
    }

}
