package entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    @CollectionTable(name="timetable", joinColumns=@JoinColumn(name="train_id"))
    @MapKeyJoinColumn(name="station_id")
    Map<Station, Timetable> attributes = new HashMap<>();

}
