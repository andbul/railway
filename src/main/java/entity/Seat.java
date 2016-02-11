package entity;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "type", length = 8)
    private String type;

    @ManyToOne
    @JoinColumn(name = "coach_id",nullable = false)
    private Coach coach;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
