package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodoPage {
    WebDriver driver;

    public TodoPage(WebDriver driver) {
        this.driver = driver;
    }

    By todoInput = By.className("new-todo");
    By todoItems = By.cssSelector(".todo-list li");
    By clearCompleted = By.className("clear-completed");
    By toggleAll = By.className("toggle-all");
    By filters = By.cssSelector(".filters li a");

    public void openApp() {
        driver.get("https://todomvc.com/examples/react/dist/");
    }

    public void addTodoItems(String text) {
        driver.findElement(todoInput).sendKeys(text + Keys.ENTER);
    }

    public int getTodoCount() {
        return driver.findElements(todoItems).size();
    }

    public String getTodoText(int index) {
        return driver.findElements(todoItems).get(index).getText();
    }

    public void toggleTodo(int index) {
        driver.findElements(todoItems).get(index).findElement(By.className("toggle")).click();
    }

    public void deleteTodo(int index) {
        WebElement item = driver.findElements(todoItems).get(index);
        WebElement destroyBtn = item.findElement(By.className("destroy"));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", destroyBtn);
    }

    public void toggleAllTodos() {
        driver.findElement(toggleAll).click();
    }

    public void clearCompleted() {
        driver.findElement(clearCompleted).click();
    }

    public void applyFilter(String filterName) {
        for (WebElement filter : driver.findElements(filters)) {
            if (filter.getText().equalsIgnoreCase(filterName)) {
                filter.click();
                break;
            }
        }
    }
}