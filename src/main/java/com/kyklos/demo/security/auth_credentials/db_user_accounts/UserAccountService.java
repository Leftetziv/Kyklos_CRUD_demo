package com.kyklos.demo.security.auth_credentials.db_user_accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public ArrayList<UserAccount> getAllUserAccount() {
        ArrayList<UserAccount> list = new ArrayList<>();
        userAccountRepository.findAll().forEach(list::add);
        return list;
    }

    public UserAccount addUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    public void deleteUserAccount(String username) {
        userAccountRepository.deleteById(username);
    }

}
