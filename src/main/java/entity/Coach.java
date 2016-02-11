package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "coach")
public class Coach {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type", length = 8)
    private String type;

    @Column(name = "curentnumber")
    private Integer curentnumber;

    @OneToMany(mappedBy = "coach")
    private List<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCurentnumber() {
        return curentnumber;
    }

    public void setCurentnumber(Integer curentnumber) {
        this.curentnumber = curentnumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
