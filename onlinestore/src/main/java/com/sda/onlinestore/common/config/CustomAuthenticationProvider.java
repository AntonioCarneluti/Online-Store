package com.sda.onlinestore.common.config;


import com.sda.onlinestore.common.utils.Hasher;
import com.sda.onlinestore.model.UserModel;
import com.sda.onlinestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (shouldAuthenticateAgainstThirdPartySystem(name, password)) {

            // use the credentials
            // and authenticate against the third-party system

            UserModel userModel = userRepository.getUserModelByUsername(name).orElse(null);
            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + userModel.getUserRole());
            authorities.add(simpleGrantedAuthority);

            return new UsernamePasswordAuthenticationToken(
                    name, password, authorities);
        } else {
            return null;
        }
    }
    private boolean shouldAuthenticateAgainstThirdPartySystem(String name, String password){
        UserModel user=userRepository.getUserModelByUsername(name).orElse(null);
        if(user!=null&&user.getPassword().equals(Hasher.encode(password))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
