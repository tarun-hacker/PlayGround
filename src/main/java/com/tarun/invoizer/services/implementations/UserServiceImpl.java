package com.tarun.invoizer.services.implementations;

import com.tarun.invoizer.exceptions.ResourceNotFoundException;
import com.tarun.invoizer.models.User;
import com.tarun.invoizer.repositories.UserRepository;
import com.tarun.invoizer.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getById(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
