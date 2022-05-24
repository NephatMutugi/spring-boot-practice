package com.kcbgroup.main.user;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoService {
	
    private static final List<User> userList =new ArrayList<>();
    private static int usersCount = 5;
    static {
        userList.add(new User(1, "Neph", new Date()));
        userList.add(new User(2, "Mercy", new Date()));
        userList.add(new User(3, "Maureen", new Date()));
        userList.add(new User(4, "Annalis", new Date()));
        userList.add(new User(5, "Jack", new Date()));
    }

    public List<User> findAll() {
        return userList;
    }

    public User saveUser(User user){
        if (user.getId() == null){
            user.setId(++usersCount);
        }
        userList.add(user);
        return user;
    }

    public User findOne(String name){
        for (User user : userList){
            if (Objects.equals(user.getName(), name)){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
