package com.example.demo.security.details;

import com.example.demo.entity.User;
import com.example.demo.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Details loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByAccountId(username)
                .orElseThrow(() -> new RuntimeException("not exist username information (DetailsService:21)"));
        return new Details(user);
    }
}
