package entity;

import javax.persistence.Embeddable;
import java.sql.Timestamp;

@Embeddable
public class Timetable {

    private Timestamp arrivalTime;
    private Timestamp departureTime;
}
