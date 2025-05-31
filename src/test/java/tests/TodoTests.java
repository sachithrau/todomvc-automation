package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.TodoPage;

public class TodoTests {
    WebDriver driver;
    TodoPage todoPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        todoPage = new TodoPage(driver);
    }

    @Test(priority = 1)
    public void testAddTodo() {
        todoPage.openApp();
        todoPage.addTodoItems("Buy Foods");
        Assert.assertEquals(todoPage.getTodoCount(), 1);
        Assert.assertEquals(todoPage.getTodoText(0), "Buy Foods");
    }

    @Test(priority = 2)
    public void selectTodoItems() {
        todoPage.toggleTodo(0);
    }

    @Test(priority = 3)
    public void testDeleteTodo() {
        todoPage.deleteTodo(0);
        Assert.assertEquals(todoPage.getTodoCount(), 0);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}