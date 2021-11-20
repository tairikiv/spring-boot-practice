package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.Authority;
import com.example.springbootpractice.repositories.AuthorityRepository;
import com.example.springbootpractice.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Service to handle Authority related operations
 *
 * @author Tairi
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void createAuthority(Authority authority) {
        if(!findAuthorityByName(authority.getName()).isPresent()) {
            authorityRepository.save(authority);
        }
    }

    @Override
    public Optional<Authority> findAuthorityByName(String name) {
        return authorityRepository.findByName(name);
    }

    @Override
    public List<Authority> getAllAuthorities() {
        return authorityRepository.findAll();
    }
}
