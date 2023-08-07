package URLAssertionTest;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class URLAssertionTest extends BaseDriver {
    @Test
    public void test3(){
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement signInButton = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']"));
        signInButton.click();

        MyMethods.myWait(2);
        WebElement emailInbox = driver.findElement(By.cssSelector("input[id='email']"));
        emailInbox.sendKeys("mrxw76xl5k3y@gmail.com");

        WebElement passwordInbox = driver.findElement(By.cssSelector("input[id='pass'][title='Password']"));
        passwordInbox.sendKeys("2516John.");

        WebElement signInButton2 = driver.findElement(By.cssSelector("button[id='send2'][class='action login primary']"));
        signInButton2.click();

        WebElement whatsButton = driver.findElement(By.cssSelector("a[id='ui-id-3']"));
        whatsButton.click();

        MyMethods.myWait(2);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/what-is-new.html"));

        WebElement womenTabButton = driver.findElement(By.cssSelector("a[id='ui-id-4']"));
        WebElement womenTabTopsTabButton = driver.findElement(By.cssSelector("a[id='ui-id-9']"));
        WebElement womenTabTopsTabJacketsTabButton = driver.findElement(By.cssSelector("a[id='ui-id-11']"));
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(womenTabButton).moveToElement(womenTabTopsTabButton)
                .moveToElement(womenTabTopsTabJacketsTabButton).click().build();
        action.perform();

        MyMethods.myWait(2);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html"));

        waitAndQuit();
    }
}

