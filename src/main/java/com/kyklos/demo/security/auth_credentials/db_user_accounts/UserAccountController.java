package com.kyklos.demo.security.auth_credentials.db_user_accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/administration")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping(path ="/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ArrayList<UserAccount>> getAllUser() {
        return new ResponseEntity<>(userAccountService.getAllUserAccount(), HttpStatus.OK);
    }

    @PostMapping(path = "/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<UserAccount> CreateUser(@RequestBody UserAccount userAccount) {
        return new ResponseEntity<>(userAccountService.addUserAccount(userAccount), HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/user/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Void> DeleteUser(@PathVariable String username) {
        userAccountService.deleteUserAccount(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path ="/create_default_user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void CreateDefaultUser() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user");
        userAccount.setPassword("password");
        userAccount.setRole("ROLE");
        userAccount.setEnabled(true);
        userAccount.setAccountNonExpired(true);
        userAccount.setAccountNonLocked(true);
        userAccount.setCredentialsNonExpired(true);

        userAccountService.addUserAccount(userAccount);
    }
}
