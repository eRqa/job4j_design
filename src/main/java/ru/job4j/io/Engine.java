package ru.job4j.io;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "someObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Engine {

    @XmlAttribute
    private int volume;

    public Engine(int volume) {
        this.volume = volume;
    }

    public Engine() {
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
