import java.util.*;
import java.io.*;

public class Nurse extends Person implements Staff {
    private String responsibilities;
    static int Nid = 1;
    protected int nid;

    public Nurse(String name, String address, String phoneNumber, int nationalCode, String responsibilities) {
        super(name, address, phoneNumber, nationalCode);
        this.responsibilities = responsibilities;
        this.nid = Nid;
        Nid++;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    @Override
    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        return "Nurse [name = " + super.getName() + ", address = " + super.getAddress() + ", phoneNumber = " + super.getPhoneNumber() + ", responsibilities = " + responsibilities + "]";
    }

    public void save() {
        MyFile.save(this);
    }
}
