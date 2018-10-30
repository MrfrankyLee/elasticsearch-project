package com.needayeah.elasticsearch.service.user;

import com.needayeah.elasticsearch.entity.Role;
import com.needayeah.elasticsearch.entity.User;
import com.needayeah.elasticsearch.repository.RoleRepository;
import com.needayeah.elasticsearch.repository.UserRepository;
import com.needayeah.elasticsearch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaole
 * @date 2018/10/30
 * @Description  用户service层
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User findUserByName(String name) {
        User user = userRepository.findByName(name);
        if(user == null){
          return null;
        }
        List<Role> roles = roleRepository.findRolesByUserID(user.getId());
        if(roles == null || roles.isEmpty()){
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach((Role role) -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }
}
