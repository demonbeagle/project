package com.uabc.project.project.repository.security;

import com.uabc.project.project.model.security.UserSecurity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositorySecurity extends CrudRepository<UserSecurity, Long> {
    UserSecurity findByName(String username);
}
