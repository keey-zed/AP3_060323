package enset.ma.service;

import enset.ma.entities.Role;
import enset.ma.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addRole(Role role);
    User findUserByUsername(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);
    User authenticate(String username, String password);
}




