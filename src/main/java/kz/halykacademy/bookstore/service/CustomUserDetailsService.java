package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.repository.UserRepository;
import kz.halykacademy.bookstore.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import kz.halykacademy.bookstore.dao.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user);
    }
}
