package com.tarun.invoizer.services.interfaces;

import com.tarun.invoizer.exceptions.ResourceNotFoundException;
import com.tarun.invoizer.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void removeUser(User user);
    User getById(Long id) throws ResourceNotFoundException;
    List<User> list();
}
