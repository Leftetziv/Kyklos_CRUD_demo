package com.kyklos.demo.security.auth_credentials;

import com.kyklos.demo.security.auth_credentials.db_user_accounts.UserAccount;
import com.kyklos.demo.security.auth_credentials.db_user_accounts.UserAccountService;
import com.kyklos.demo.security.roles_and_permissions.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("true")
public class TrueApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    final GlobalAdmin globalAdmin;

    @Autowired
    public TrueApplicationUserDaoService(PasswordEncoder passwordEncoder, GlobalAdmin globalAdmin) {
        this.passwordEncoder = passwordEncoder;
        this.globalAdmin = globalAdmin;
    }

    @Autowired
    UserAccountService userAccountService;

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

//            Set<? extends GrantedAuthority> grantedAuthorities = null;
//            for (Role r : Role.values()) {
//                if (user.getRole().equals(r.name())) {
//                    grantedAuthorities = r.getGrantedAuthorities();
//                    break;
//                }
//            }

            Set<? extends GrantedAuthority> grantedAuthorities = Role.valueOf(user.getRole()).getGrantedAuthorities();


            ApplicationUser applicationUser = new ApplicationUser(
                    user.getUsername(),
                    passwordEncoder.encode(user.getPassword()),
                    grantedAuthorities,
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
