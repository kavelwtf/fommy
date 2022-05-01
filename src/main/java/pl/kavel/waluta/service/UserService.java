package pl.kavel.waluta.service;

import pl.kavel.waluta.user.User;

import java.util.concurrent.ConcurrentHashMap;

public class UserService {

    private final ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

    public User findUserOrCreate(String nickName){
        return this.userMap.computeIfAbsent(nickName, User::new);
    }

    public User findUserByNickName(String nickName){
        return this.userMap
                .values()
                .stream()
                .filter(user -> user.getNickName().equalsIgnoreCase(nickName))
                .findFirst()
                .orElse(null);
    }

    public ConcurrentHashMap<String, User> getUserMap() {
        return userMap;
    }
}
