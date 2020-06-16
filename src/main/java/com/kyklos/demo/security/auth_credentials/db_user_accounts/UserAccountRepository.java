package com.kyklos.demo.security.auth_credentials.db_user_accounts;

import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, String> {

}
