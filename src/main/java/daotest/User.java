package daotest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andrey on 03.02.16.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn(name="login", referencedColumnName="login"),
            inverseJoinColumns = @JoinColumn(name="role_name", referencedColumnName="name")
    )
    private List<Role> roles;

    public User() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                " login='" + login + '\'' +
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

        return login == user.login;

    }
}
