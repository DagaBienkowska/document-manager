package com.dagabienkowska.documentmanager.repository;

import com.dagabienkowska.documentmanager.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(String roleName);
}
