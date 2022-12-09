package com.example.demo.security.details;

import com.example.demo.entity.User;
import com.example.demo.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByAccountId(username)
                .orElseThrow(() -> {
                    throw new RuntimeException("not exist username information");
                });
        return new Details(user);
    }
}
