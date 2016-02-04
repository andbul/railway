package daotest;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by andrey on 03.02.16.
 */
@Entity
@Table(name = "user")
//@NamedQueries({
//        @NamedQuery(name = "User.getAll", query = "SELECT u FROM User u"),
//        @NamedQuery(name="Country.findByLogin",
//                query="SELECT u FROM User u WHERE u.name = :name"),
//        @NamedQuery(name="Country.findByLoginAndPassword",
//                query="SELECT u FROM User u WHERE u.name = :name"),
//})
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name = "login", length = 16, unique = true)
    private String login;

    @Column(name = "password", length = 16)
    private String password;

    @Column(name = "name", length = 16)
    private String name;

    @Column(name = "surname", length = 16)
    private String surname;

    @Column(name = "email", length = 16, unique = true)
    private String email;


    public User() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }
}
