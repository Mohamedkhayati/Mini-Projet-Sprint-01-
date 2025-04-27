package com.mohamed.supplements.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mohamed.supplements.entities.Role;
import com.mohamed.supplements.entities.User;
import com.mohamed.supplements.repos.RoleRepository;
import com.mohamed.supplements.repos.UserRepository;
@Transactional
@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepository userRep;
@Autowired
RoleRepository roleRep;
@Autowired
BCryptPasswordEncoder bCryptPasswordEncoder;
@Override
public User saveUser(User user) {
user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
return userRep.save(user);
}
@Override
public User addRoleToUser(String username, String rolename) {
User usr = userRep.findByUsername(username);
Role r = roleRep.findByRole(rolename);
usr.getRoles().add(r);
return usr;
}
@Override
public void deleteAllusers() {
userRep.deleteAll();
}
@Override
public void deleteAllRoles() {
roleRep.deleteAll();
}
@Override
public Role addRole(Role role) {
return roleRep.save(role);
}
@Override
public User findUserByUsername(String username) {
return userRep.findByUsername(username);
}
@Override
public boolean roleExists(String roleName) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean userExists(String username) {
	// TODO Auto-generated method stub
	return false;
}
}