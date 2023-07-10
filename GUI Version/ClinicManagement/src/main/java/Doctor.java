import java.util.*;
import java.io.*;

public class Doctor extends Person {
    private String specialization;
    static int dID = 1;
    protected int did;

    public Doctor(String name, String address, String phoneNumber, int nationalCode, String specialization) {
        super(name, address, phoneNumber, nationalCode);
        this.specialization = specialization;
        this.did = dID;
        dID++;
    }

    public static int getdID() {
        return dID;
    }

    public static void setdID(int dID) {
        Doctor.dID = dID;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor [name = " + super.getName() + ", address = " + super.getAddress() + ", phoneNumber = " + super.getPhoneNumber() + ", nationalCode = " + super.getNationalCode() + ", specialization = " + specialization + "]";
    }

    public void save() {
        MyFile.save(this);
    }
}

