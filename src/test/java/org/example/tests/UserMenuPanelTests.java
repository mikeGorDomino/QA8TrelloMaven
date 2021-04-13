package org.example.tests;


import org.example.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserMenuPanelTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    UserMenuPanelHelper userMenuPanelPage;

    @BeforeMethod
    public void initTests()  {

        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        userMenuPanelPage = PageFactory.initElements(driver, UserMenuPanelHelper.class);

        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPasswordAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        userMenuPanelPage.openUserMenu();
        userMenuPanelPage.waitUntilPageIsLoaded();
    }

    @Test
    public void verifyEmailOnPanel(){
        Assert.assertEquals(userMenuPanelPage.getEmailFromMenu(),LOGIN,"The email is not correct");
    }

    @Test
    public void verifyFirstUserName(){
        Assert.assertTrue(userMenuPanelPage.getUserMenuButtonTitle()
                .contains(userMenuPanelPage.getFirstUserName()));
    }
}