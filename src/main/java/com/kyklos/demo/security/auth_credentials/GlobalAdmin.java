package com.kyklos.demo.security.auth_credentials;

import com.kyklos.demo.security.auth_credentials.db_user_accounts.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "custom.globaladmin")
public class GlobalAdmin {

    private String username;
    private String password;

    public GlobalAdmin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccount GetGlobalAdmin() {
        UserAccount globalAdmin = new UserAccount();
        globalAdmin.setUsername(username);
        globalAdmin.setPassword(password);
        globalAdmin.setRole("ADMIN");
        globalAdmin.setEnabled(true);
        globalAdmin.setAccountNonExpired(true);
        globalAdmin.setAccountNonLocked(true);
        globalAdmin.setCredentialsNonExpired(true);
        return globalAdmin;
    }

}
