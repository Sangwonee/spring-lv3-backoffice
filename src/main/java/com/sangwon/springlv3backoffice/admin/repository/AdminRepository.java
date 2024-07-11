package com.sangwon.springlv3backoffice.admin.repository;

import com.sangwon.springlv3backoffice.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
