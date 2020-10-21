package org.example.tests;

import org.example.config.Log;
import org.example.pages.RegisterPage;
import org.example.pages.models.Credentials;
import org.example.testdata.LoginPageCredentials;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private RegisterPage registerPage;
    @BeforeClass
    public void setUp() {
        Log.getLogger().info("Setting up the test");
        registerPage = new RegisterPage();
    }
    @Test(dataProvider = "validCregentials", dataProviderClass = LoginPageCredentials.class)
    public void validLogin(Credentials credentials) {
        registerPage.registerUser(credentials);
    }
    @Test(dataProvider = "invalidCredentials", dataProviderClass = LoginPageCredentials.class)
    public void invalidLogin(Credentials credentials) {
        registerPage.registerUser(credentials);
    }
}
