package com.sasuke.user.service.UserService.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Rating {

    private Object id; // primary key annotate it with @Id when attach it to mongo
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
