package com.portfolio.backenduspiri.services;

import com.portfolio.backenduspiri.model.User;
import com.portfolio.backenduspiri.repository.UserRepository;
import com.portfolio.backenduspiri.service_interface.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    
    @Autowired
    public UserRepository userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    
}
