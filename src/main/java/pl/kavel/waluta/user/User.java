package pl.kavel.waluta.user;

import pl.kavel.waluta.user.impl.UserImpl;

public class User implements UserImpl {


    private final String nickName;
    private int coins;

    public User(String nickName){
        this.nickName = nickName;
        this.coins = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public void addCoins(int coins) {
        this.coins += coins;
    }

    @Override
    public void removeCoins(int coins) {
        this.coins -= coins;
    }

    @Override
    public void incrementCoins() {
        this.coins += 1;
    }
}
