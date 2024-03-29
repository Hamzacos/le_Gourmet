package com.example.gourmet.Repository;

import com.example.gourmet.Entity.appUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<appUser,Integer> {

    appUser findByUsername(String username);
}
