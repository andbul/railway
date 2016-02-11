package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 16, nullable = false)
    private String name;

    @Column(name = "surname", length = 16, nullable = false)
    private String surname;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Embedded
    private Pasport pasport;
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Pasport getPasport() {
        return pasport;
    }

    public void setPasport(Pasport pasport) {
        this.pasport = pasport;
    }

}
