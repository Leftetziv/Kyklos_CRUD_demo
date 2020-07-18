package com.kyklos.demo.security.auth_credentials.db_user_accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private final GlobalAdmin globalAdmin;

    public UserAccountService(GlobalAdmin globalAdmin) {
        this.globalAdmin = globalAdmin;
    }

    public ArrayList<UserAccount> getAllUserAccount() {
        ArrayList<UserAccount> list = new ArrayList<>();
        userAccountRepository.findAll().forEach(list::add);
        return list;
    }

    public UserAccount getUserAccountByUsername(String username) {
        if (globalAdmin.GetGlobalAdmin().getUsername().equals(username)) {
            return globalAdmin.GetGlobalAdmin();
        }

        return userAccountRepository.findById(username)
                .orElseThrow(() ->
                new UsernameNotFoundException(String.format("Username %s not found", username))
        );
    }

    public UserAccount addUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    public void deleteUserAccount(String username) {
        userAccountRepository.deleteById(username);
    }

}
