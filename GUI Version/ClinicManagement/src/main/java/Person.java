import java.util.*;
import java.io.*;

public abstract class Person implements Serializable {
    private String name;
    private String address;
    private String phoneNumber;
    private int nationalCode;

    public Person(String name, String address, String phoneNumber, int nationalCode) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }
    public String toString() {
        return "Name = " + getName() + ", Address = " + getAddress() + ", Phone = " + getPhoneNumber();
    }
}
