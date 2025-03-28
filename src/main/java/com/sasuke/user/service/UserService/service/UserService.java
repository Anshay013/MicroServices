package com.sasuke.user.service.UserService.service;

import com.sasuke.user.service.UserService.entity.User;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // return User
    ResponseEntity<?> saveUser(User user);

    // Return List<User>
    ResponseEntity<?> getAllUser();

    User findByUserName(String userName);

    void deleteUserByName(String userName);

    ResponseEntity<?> findUserById(ObjectId Id);

}
