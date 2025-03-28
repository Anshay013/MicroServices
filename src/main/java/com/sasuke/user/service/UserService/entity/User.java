package com.sasuke.user.service.UserService.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true) // making username unique, and by @Indexed the searching of userName becomes fast
    @NonNull
    @Field(name = "EMAIL")
    private String userName;


    @NonNull
    @Size(min = 4, max = 15, message = "name must be atleast 4 letters and at most 15 long ")
    private String name;

    private String about;

    @Transient // it will help ignore the List ratings, and it won't be saved in DB
    private List<Rating> ratings;
    // if we check by hitting to get a user or all users, observe that the rating will come out to be null. If @Transient isn't applied the rating
    // comes out to be an array. (Empty if nothing inside)

}
