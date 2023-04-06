package com.example.gourmet.Repository;

import com.example.gourmet.Entity.appRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositry extends JpaRepository<appRole,Long> {

    appRole findByRoleName(String roleName);
}
