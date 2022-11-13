package org.sid.applicationjpa.Service;

import org.sid.applicationjpa.entities.Role;
import org.sid.applicationjpa.entities.User;
import org.sid.applicationjpa.repositories.RoleRepository;
import org.sid.applicationjpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional //pour gérer les transactions dans la couche Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {
          user.setUserId(UUID.randomUUID().toString());
          return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
       User user= findUserByUserName(userName);
       Role role= findRoleByRoleName(roleName);
       if (user.getRoles()!=null)
       user.getRoles().add(role);
       role.getUsers().add(user);
    }
}

