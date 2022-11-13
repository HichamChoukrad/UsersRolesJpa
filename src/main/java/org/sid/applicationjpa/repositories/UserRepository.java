package org.sid.applicationjpa.repositories;

import org.sid.applicationjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

     User findByUserName(String userName);

}
