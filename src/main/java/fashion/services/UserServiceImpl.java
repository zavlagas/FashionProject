/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import fashion.daos.UserDao;
import fashion.entity.UserRole;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao udao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        fashion.entity.User myUser = udao.findByUsername(username);
        List<GrantedAuthority> authorities = convertRolesToGrantedAuthorities(myUser.getUserRoleList());
        UserDetails userDetails = new User(myUser.getUsername(), myUser.getPassword(), authorities);
        return userDetails;
    }

    private List<GrantedAuthority> convertRolesToGrantedAuthorities(List<UserRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList();
        roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole().getType())).forEachOrdered(authority -> {
            authorities.add(authority);
        });
        return (authorities);

    }

}
