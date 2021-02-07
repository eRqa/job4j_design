package ru.job4j.io.serialization;

import ru.job4j.io.Engine;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "flat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flat {

    @XmlAttribute
    private boolean itIsFirstFloor;

    @XmlAttribute
    private int square;

    @XmlAttribute
    private String ownerName;

    @XmlElementWrapper(name = "rooms")
    @XmlElement(name = "room")
    private String[] rooms;

    private Engine someObject;

    public Flat(boolean itIsFirstFloor, int square, String ownerName, String[] rooms, Engine someObject) {
        this.itIsFirstFloor = itIsFirstFloor;
        this.square = square;
        this.ownerName = ownerName;
        this.rooms = rooms;
        this.someObject = someObject;
    }

    public Flat() {
    }
}
