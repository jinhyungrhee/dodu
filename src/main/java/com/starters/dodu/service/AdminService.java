package com.starters.dodu.service;

import com.starters.dodu.domain.Admin;
import com.starters.dodu.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
//public class AdminService implements UserDetailsService {
public class AdminService {
    private final AdminRepository adminRepository;

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public boolean authenticate(String adminName, String password) {

        Optional<Admin> admin = adminRepository.findAdminByAdminNameAndPassword(adminName, password);
        System.out.println(admin);
        if (!admin.isEmpty() && admin.get().getPassword().equals(password)) { // Optional Empty 처리
            return true;
        } else {
            return false;
        }
    }
    public Optional<Admin> findAdminByAdminNameAndPassword(String adminName, String password){
        return adminRepository.findAdminByAdminNameAndPassword(adminName, password);
    }

    // 추가
    /*
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
        UserDetails uDetails = adminRepository.findByAdminName(adminName)
                .map(admin -> createUser(adminName, admin))
                .orElseThrow(EntityNotFoundException::new);

        System.out.println("[UserDetails] : " + uDetails);

        return uDetails;
    }

    private UserDetails createUser(String adminName, Admin admin) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        return User.builder()
                .username(adminName)
                .password(admin.getPassword())
                .authorities(authority)
                .build();
    }
     */
}
