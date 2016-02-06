package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andrey on 06.02.16.
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{
    @Id
    @Column(name = "name", nullable = false, length = 16)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
