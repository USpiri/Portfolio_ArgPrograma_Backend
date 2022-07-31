package com.portfolio.backenduspiri.service_interface;

import com.portfolio.backenduspiri.model.User;
import java.util.List;

public interface IUserService {
    
    public List<User> getUsers();
    
    public void createUser (User user);
    
    public void deleteUser (Long id);
    
    public User getUser (Long id);
    
}
