package com.jwt.service;

import com.jwt.dao.RoleDao;
import com.jwt.dao.UserDao;
import com.jwt.entity.Role;
import com.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
@Autowired
    private UserDao userDao;
@Autowired
private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
public User createNewUser(User user){

    return userDao.save(user);
}

public void initRolesAndUsers(){
    Role adminRole = new Role();
    adminRole.setRoleName("Admin");
    adminRole.setRoleDesc("Admin Role");
    roleDao.save(adminRole);

    Role userRole = new Role();
    userRole.setRoleName("User");
    userRole.setRoleDesc("User Role");
    roleDao.save(userRole);

    User adminUser = new User();
    adminUser.setUserName("AdminUser");
    adminUser.setFirstName("Admin");
    adminUser.setLastName("Admin");
    adminUser.setPassword("$2a$10$RBEdXTfVuWxeCi/hCyBCZe3QRjUPPR5.lVWrvL485i8ST19gCuS3W");
    Set<Role> adminRoles = new HashSet<>();
    adminRoles.add(adminRole);
    adminUser.setRole(adminRoles);
    userDao.save(adminUser);

//    User user = new User();
//    user.setUserName("JayBajpai");
//    user.setFirstName("Jay");
//    user.setLastName("Bajpai");
//    user.setPassword("Jay@123");
//    Set<Role> userRoles = new HashSet<>();
//    userRoles.add(userRole);
//    user.setRole(userRoles);
//    userDao.save(user);

}
    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setPassword(getEncodedPassword(user.getPassword()));

        return userDao.save(user);
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
