package entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 16, nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name="timetable", joinColumns=@JoinColumn(name="station_id"))
    @MapKeyJoinColumn(name="train_id")
    Map<Train, Timetable> attributes = new HashMap<>();

}
