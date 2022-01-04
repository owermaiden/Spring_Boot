package com.cybertek.service;

import com.cybertek.entity.User;
import com.cybertek.enums.UserState;
import com.cybertek.exeption.ServiceException;
import com.cybertek.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User readByUsername(String username) {
        return userRepository.findByUserName(username).orElse(null);
    }
    public User readByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional // insert, delete, update operations need different thread..transactional prevents error
    public User createUser(User user) throws ServiceException {

        User foundUserByEmail = readByEmail(user.getEmail());
        User foundUserByUsername = readByUsername(user.getUserName());

        if(foundUserByEmail != null) {
            throw new ServiceException("This user already exists, please change your email");
        }
        if(foundUserByUsername != null) {
            throw new ServiceException("This user already exists, please change your username");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setIsVerified(false);
        user.setIsDeleted(false);
        return userRepository.save(user);
    }

    @Transactional
    public User verifyUser(User user) {
        user.setIsVerified(true);
        user.setState(UserState.ACTIVE);
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUser(Integer id) throws ServiceException {

        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ServiceException("This user does not exist");
        }
        user.setIsVerified(false);
        userRepository.save(user);
    }
    @Transactional
    public User resetPassword(User user) throws ServiceException {

        User foundUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (foundUser == null) {
            throw new ServiceException("User with email does not exists: " + user.getEmail());
        }
        foundUser.setState(UserState.ACTIVE);
        foundUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(foundUser);
    }
}
