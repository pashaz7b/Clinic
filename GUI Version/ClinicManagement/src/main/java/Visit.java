import java.util.*;
import java.io.*;

public class Visit implements Serializable {

    private Doctor doctor;
    private Patient patient;
    private Date date;
    private String prescription;
    static int VID = 1;
    protected int vid;

    public Visit(Doctor doctor, Patient patient, Date date, String prescription) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.prescription = prescription;
        this.vid = VID;
        VID++;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public static int getVID() {
        return VID;
    }

    public static void setVID(int VID) {
        Visit.VID = VID;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String toString() {
        return "visit = { doctor = " + doctor.getName() + " , patient = " + patient.getName() + " , date = " + date + " , prescription = " + prescription + " }";
    }

    public void save() {
        MyFile.save(this);
    }
}