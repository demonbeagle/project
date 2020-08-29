package com.uabc.project.project.services.security;

import com.uabc.project.project.model.security.UserSecurity;

public interface UserService {
    void save(UserSecurity userSecurity);

    UserSecurity findByUsername(String username);
}
