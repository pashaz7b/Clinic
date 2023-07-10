import java.util.*;
import java.io.*;

public class Personnel extends Person implements Staff {
    private String responsibilities;
    static int Pid = 1;
    protected int pid;

    public Personnel(String name, String address, String phoneNumber, int nationalCode, String responsibilities) {
        super(name, address, phoneNumber, nationalCode);
        this.responsibilities = responsibilities;
        this.pid = Pid;
        Pid++;
    }

    @Override
    public String getResponsibilities() {
        return responsibilities;
    }

    public static int getPid() {
        return Pid;
    }

    public static void setPid(int pid) {
        Pid = pid;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String toString() {
        return "Nurse [name = " + super.getName() + ", address = " + super.getAddress() + ", phoneNumber = " + super.getPhoneNumber() + ", responsibilities = " + responsibilities + "]";
    }

    public void save() {
        MyFile.save(this);
    }
}

