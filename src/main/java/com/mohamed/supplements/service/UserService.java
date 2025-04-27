package com.mohamed.supplements.service;

import com.mohamed.supplements.entities.Role;
import com.mohamed.supplements.entities.User;
public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
boolean roleExists(String roleName); // New method
boolean userExists(String username); // New method
}
