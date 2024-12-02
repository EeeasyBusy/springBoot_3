package com.example.springBootdemo_3.domain;

import com.example.springBootdemo_3.controller.Authorities;

import java.util.List;
import java.util.Objects;

public class UserRepository {
    private String login;
    private String password;

    public UserRepository() {
    }

    public UserRepository(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (getLogin().equals(user) && getPassword().equals(password)) {
            return List.of(Authorities.values());
        }
        return List.of();
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRepository that = (UserRepository) o;
        return Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

}
