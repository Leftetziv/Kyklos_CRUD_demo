package com.kyklos.demo.security.auth_credentials;

import com.kyklos.demo.security.auth_credentials.db_user_accounts.GlobalAdmin;
import com.kyklos.demo.security.auth_credentials.db_user_accounts.UserAccount;
import com.kyklos.demo.security.auth_credentials.db_user_accounts.UserAccountService;
import com.kyklos.demo.security.roles_and_permissions.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("true")
public class TrueApplicationUserDaoService implements ApplicationUserDao {

    final GlobalAdmin globalAdmin;
    final UserAccountService userAccountService;

    @Autowired
    public TrueApplicationUserDaoService(GlobalAdmin globalAdmin, UserAccountService userAccountService) {
        this.globalAdmin = globalAdmin;
        this.userAccountService = userAccountService;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        UserAccount userAccount = userAccountService.getUserAccountByUsername(username);

        ApplicationUser applicationUser = new ApplicationUser(
                userAccount.getUsername(),
                userAccount.getPassword(),
                Role.valueOf(userAccount.getRole()).getGrantedAuthorities(),
                userAccount.isAccountNonExpired(),
                userAccount.isAccountNonLocked(),
                userAccount.isCredentialsNonExpired(),
                userAccount.isEnabled()
        );

        return Optional.of(applicationUser);

    }
}
