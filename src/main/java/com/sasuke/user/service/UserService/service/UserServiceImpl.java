package com.sasuke.user.service.UserService.service;

import com.sasuke.user.service.UserService.exceptions.ResourceNotFoundException;
import com.sasuke.user.service.UserService.repository.UserRepository;
import com.sasuke.user.service.UserService.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveUser(User user) {
        try {
            if(userRepository.findByUserName(user.getUserName()) == null) {
                userRepository.save(user);
                return new ResponseEntity<>(user, HttpStatus.CREATED);
            }
            else return new ResponseEntity<>("Already found an account with same userName", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("couldn't save user " + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<?> getAllUser()  {
        try {
            List<User> allUsers = userRepository.findAll();
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
        catch(ResourceNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUserByName(String userName){
        try {
            userRepository.deleteByUserName(userName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ResponseEntity<?> findUserById(ObjectId Id) throws ResourceNotFoundException {
        try {
            User user = userRepository.findById(Id)
                    .orElseThrow(() -> new ResourceNotFoundException("user not found " + Id));
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        catch(ResourceNotFoundException ex) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            // if we return like this -> return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); this null will be treated as a header instead of body
        }
    }


}
