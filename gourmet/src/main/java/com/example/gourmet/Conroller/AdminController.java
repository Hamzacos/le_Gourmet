package com.example.gourmet.Conroller;

import com.example.gourmet.Entity.appRole;
import com.example.gourmet.Entity.appUser;
import com.example.gourmet.Service.Implementation.AdminServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;


    @GetMapping(path = "/users")
    @PostAuthorize("hasAnyAuthority('Admin')")
    public List<appUser> userList(){
        return adminService.listUser();
    }

    @PostMapping(path = "/users")
    @PostAuthorize("hasAnyAuthority('Admin')")
    appUser saveUser(@RequestBody appUser user){
        return adminService.saveUser(user);
    }

    @PostMapping(path = "/register")
    appUser RegisterClient(@RequestBody appUser user){
        return adminService.Register(user);
    }

    @PostMapping(path = "/roles")
    @PostAuthorize("hasAnyAuthority('Admin')")
    appRole saveRole(@RequestBody appRole role){
        return adminService.addNewRole(role);
    }

    @PostMapping(path = "/addRoleToUser")
    @PostAuthorize("hasAnyAuthority('Admin')")
    public String addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        adminService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
        return "{message succes}";
    }

    @GetMapping(path = "/utlisateur")
    public String currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}


@Data
class RoleUserForm{
    private String username;
    private String roleName;
}
