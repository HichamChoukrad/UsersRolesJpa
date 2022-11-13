package org.sid.applicationjpa.repositories;

import org.sid.applicationjpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Long> {
       Role findByRoleName(String roleName);

}
