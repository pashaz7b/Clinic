import java.util.*;
import java.io.*;

public class Patient extends Person {
    private String disease;
    static int pID = 1;
    protected int pid;

    public Patient(String name, String address, String phoneNumber, int nationalCode, String disease) {
        super(name, address, phoneNumber, nationalCode);
        this.disease = disease;
        this.pid = pID;
        pID++;
    }

    public String getdisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public static int getpID() {
        return pID;
    }

    public static void setpID(int pID) {
        Patient.pID = pID;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Patient [name = " + super.getName() + ", address = " + super.getAddress() + ", phoneNumber = " + super.getPhoneNumber() + ", nationalCode = " + super.getNationalCode() + ", disease = " + disease + "]";
    }

    public void save() {
        MyFile.save(this);
    }

}

