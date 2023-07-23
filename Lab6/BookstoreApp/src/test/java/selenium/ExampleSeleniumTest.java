package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  @Test
  void test1() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  @Test
  public void test3() {
    // Navigate to the page with the book search and selection functionality
    driver.get("http://localhost:8080/bookstore"); // Replace with the actual URL of your web server

    // Click on the search button
    driver.findElement(By.id("searchbtn")).click();

    // Select the book with ID "order-hall01"
    WebElement book = driver.findElement(By.id("order-hall01"));
    book.click();

    // Click on the cart link
    driver.findElement(By.id("cartlink")).click();

    // Check if the book with ID "hall001" is found in the cart
    boolean isFound = false;
    WebElement cartTable = driver.findElement(By.xpath("//div[@class='content']/table/tbody"));

    // Find all rows in the cart table
    List<WebElement> rows = cartTable.findElements(By.tagName("tr"));

    for (WebElement row : rows) {
      // Check the first cell in each row (contains book IDs)
      String bookId = row.findElement(By.xpath(".//td[1]")).getText();
      if (bookId.equals("hall001")) {
        isFound = true;
        break;
      }
    }

    // Assert that the book with ID "hall001" is found in the cart
    assertTrue(isFound);

  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }
}
