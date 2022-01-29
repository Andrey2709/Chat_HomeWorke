package server;

import java.util.List;
import java.util.Objects;

public class Castomer {

    public  String name;
    public  String login;
    public  String password;
    public  int id;


    public Castomer(int id, String login, String password,String name) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;

    }




    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Castomer{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Castomer castomer = (Castomer) o;
        return id == castomer.id &&
                Objects.equals(name, castomer.name) &&
                Objects.equals(login, castomer.login) &&
                Objects.equals(password, castomer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, password, id);
    }

    public boolean getLogin(String s1) {
        return login.equals(s1);
    }


}
