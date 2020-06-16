package com.kyklos.demo.security.auth_credentials;

import com.kyklos.demo.security.auth_credentials.db_user_accounts.UserAccount;
import com.kyklos.demo.security.auth_credentials.db_user_accounts.UserAccountService;
import com.kyklos.demo.security.roles_and_permissions.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("true")
public class TrueApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    final GlobalAdmin globalAdmin;
    final UserAccountService userAccountService;

    @Autowired
    public TrueApplicationUserDaoService(PasswordEncoder passwordEncoder, GlobalAdmin globalAdmin, UserAccountService userAccountService) {
        this.passwordEncoder = passwordEncoder;
        this.globalAdmin = globalAdmin;
        this.userAccountService = userAccountService;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = new ArrayList<>();
        List<UserAccount> userAccounts = userAccountService.getAllUserAccount();

        userAccounts.add(globalAdmin.GetGlobalAdmin());

        for (UserAccount user : userAccounts ) {
            ApplicationUser applicationUser = new ApplicationUser(
                    user.getUsername(),
                    passwordEncoder.encode(user.getPassword()),
                    Role.valueOf(user.getRole()).getGrantedAuthorities(),
                    user.isAccountNonExpired(),
                    user.isAccountNonLocked(),
                    user.isCredentialsNonExpired(),
                    user.isEnabled()
            );
            applicationUsers.add(applicationUser);
        }

        return applicationUsers;
    }

}
