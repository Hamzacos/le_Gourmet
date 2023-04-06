package com.example.gourmet.Service;

import com.example.gourmet.Entity.appRole;
import com.example.gourmet.Entity.appUser;

import java.util.List;

public interface AdminService {

    appUser saveUser(appUser appUser);
    appUser Register(appUser appUser);
    appRole addNewRole(appRole role);
    void addRoleToUser(String username,String RoelName);
    List<appUser> listUser();
    appUser loadUserByUsername(String username);
}
