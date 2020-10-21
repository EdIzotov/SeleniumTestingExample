package org.example.testdata;

import org.example.pages.models.Credentials;
import org.testng.annotations.DataProvider;

public class LoginPageCredentials {
    @DataProvider(name = "validCregentials")
    public Object[] getValidCregentials() {
        return new Credentials[]{
                new Credentials("testuser@test.test", "asdffdsA1")
        };
    }
    @DataProvider(name = "invalidCredentials")
    public Object[] getInvalidCredentials() {
        return new Credentials[] {
                new Credentials("testuser", "asdffdsA1"),
                new Credentials("", "asdffdsA1"),
                new Credentials("   ", "asdffdsA1")
        };
    }
}
