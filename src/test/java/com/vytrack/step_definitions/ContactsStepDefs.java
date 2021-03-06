package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Then("the user should see following menu options")
    public void the_user_should_see_following_menu_options(List<String> list) {
        System.out.println("list.size() = " + list.size());
        System.out.println(list);


        // get the actual values from UI
        DashboardPage dashboardPage = new DashboardPage();

        List<String> actualList = new ArrayList<>();
        BrowserUtils.waitFor(2);

        for (WebElement option : dashboardPage.menuOptions) {
            actualList.add(option.getText());
        }

        // compare actual list to the expected list
        Assert.assertEquals(list, actualList);

    }
    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> userData) {
        System.out.println(userData);
        System.out.println("Firstname: "+ userData.get("fname"));
        System.out.println("Lastname: "+ userData.get("lname"));
        System.out.println("Username: "+ userData.get("username"));
        System.out.println("Password: "+ userData.get("password"));

        LoginPage loginPage = new LoginPage();

        loginPage.login(userData.get("username"), userData.get("password"));
    }



    @When("the user logs in using the following credentials")
    public void the_user_logs_in_using_the_following_credentials(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

}
