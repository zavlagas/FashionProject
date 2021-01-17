/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import fashion.daos.UserDao;
import fashion.entity.Product;
import fashion.entity.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao udao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        fashion.entity.User myUser = udao.findByUsername(username);
        List<GrantedAuthority> authorities = convertRolesToGrantedAuthorities(myUser.getRoleList());
        UserDetails userDetails = new User(myUser.getUsername(), myUser.getPassword(), authorities);
        return userDetails;
    }

    private List<GrantedAuthority> convertRolesToGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList();
        roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getType())).forEachOrdered(authority -> {
            authorities.add(authority);
        });
        return (authorities);

    }

    @Override
    public fashion.entity.User getAuthorizedUser(String username) {
        fashion.entity.User databaseUser = udao.findByUsername(username);
        return databaseUser;
    }

    @Override
    public boolean signUpNewUserIfNotExists(fashion.entity.User newUser) {
        boolean userExists = false;
        fashion.entity.User isDatabaseUser = udao.findByUsername(newUser.getUsername());
        if (isDatabaseUser == null) {
            String userPassword = newUser.getPassword();
            newUser.setPassword(passwordEncoder.encode(userPassword));
            udao.signUpToDatabase(newUser);
        } else {
            userExists = true;

        }
        return (userExists);
    }

    @Override
    public boolean updateNewUserDetails(fashion.entity.User oldUserDetails) {
        return (udao.updateUserDetails(oldUserDetails));
    }

    @Override
    public fashion.entity.User findUserById(int id) {
        return(udao.findUserById(id));
    }

    @Override
    public fashion.entity.User getAllUserDetails(String username) {
      return (udao.fetchAllUserDetails(username));
    }

    
    

}
