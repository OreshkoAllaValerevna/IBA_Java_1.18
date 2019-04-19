package BY.Oreshko.Serv.model;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private int id;
    private String login;
    private byte[] passw;

    public User(int id, String login, byte[] passw) {
        this.id = id;
        this.login = login;
        this.passw = passw;
    }

    public User() {
    }

    public User(String login, byte[] passw) {
        this.login = login;
        this.passw = passw;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassw(byte[] passw) {
        this.passw = passw;
    }
    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public byte[] getPassw() {
        return passw;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Arrays.equals(passw, user.passw);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, login);
        result = 31 * result + Arrays.hashCode(passw);
        return result;
    }
}