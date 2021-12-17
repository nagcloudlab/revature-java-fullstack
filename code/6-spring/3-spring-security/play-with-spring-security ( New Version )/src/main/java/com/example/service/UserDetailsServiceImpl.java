package com.example.service;

import com.example.entity.UserEntity;
import com.example.repository.UserEntityRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserEntityRepository userEntityRepository;

    public UserDetailsServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userEntityRepository.findByEmail(username);
        List<String> authorities=userEntity.getAuthorities();
        List<? extends GrantedAuthority> grantedAuthorities= authorities
                .stream()
                .map(s->new SimpleGrantedAuthority(s))
                .collect(Collectors.toList());
        UserDetails userDetails=new User(userEntity.getEmail(),userEntity.getPassword(),grantedAuthorities);
        return  userDetails;
    }
}
