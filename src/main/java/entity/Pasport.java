package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Pasport {

    @Column(name = "serial", length = 4)
    private Integer serial;

    @Column(name = "number", length = 6)
    private Integer number;

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
