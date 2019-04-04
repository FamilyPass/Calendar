package com.familypass.calendar.DAO;

import com.familypass.calendar.Models.User;

public interface usersDao {
//ADD USER
//DELETE USER
//UPDATE USER
//SELECT USER
//MAP TO USER

    User selectUser(long userId, String userName, String userPassword);

    long addUser(User newUser);
}
