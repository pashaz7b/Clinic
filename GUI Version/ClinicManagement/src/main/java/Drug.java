import java.util.*;
import java.io.*;

public class Drug implements Serializable {
    private String name;
    private String manufacturer;
    private String dosage;
    private String description;
    static int DRUGID = 1;
    protected int drugid;

    public Drug(String name, String manufacturer, String dosage, String description) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.dosage = dosage;
        this.description = description;
        this.drugid = DRUGID;
        DRUGID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getDRUGID() {
        return DRUGID;
    }

    public static void setDRUGID(int DRUGID) {
        Drug.DRUGID = DRUGID;
    }

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    @Override
    public String toString() {
        return "Drug [name = " + name + ", manufacturer = " + manufacturer + ", dosage = " + dosage + ", description = " + description + "]";
    }

    public void save() {
        MyFile.save(this);
    }
}


