package com.doranco.appli1.auth;

public interface ApplicationUserDao {
    ApplicationUserDetail getUserByUsername(String username);
}
