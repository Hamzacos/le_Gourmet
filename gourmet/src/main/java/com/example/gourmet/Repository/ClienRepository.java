package com.example.gourmet.Repository;

import com.example.gourmet.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienRepository extends JpaRepository<Client,Long> {
}
