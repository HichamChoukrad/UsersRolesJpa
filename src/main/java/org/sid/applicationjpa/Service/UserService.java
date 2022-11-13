package org.sid.applicationjpa.Service;

import org.sid.applicationjpa.entities.Role;
import org.sid.applicationjpa.entities.User;

public interface UserService {



    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);



}
