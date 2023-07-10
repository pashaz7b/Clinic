import java.util.*;
import java.io.*;

public class MyFile {

    private static String nursepath = "C:\\Users\\WinSell\\Documents\\ClinicTexts\\nurses.txt";
    private static String personnelpath = "C:\\Users\\WinSell\\Documents\\ClinicTexts\\personnels.txt";
    private static String doctorpath = "C:\\Users\\WinSell\\Documents\\ClinicTexts\\doctors.txt";
    private static String patientpath = "C:\\Users\\WinSell\\Documents\\ClinicTexts\\patients.txt";
    private static String visitpath = "C:\\Users\\WinSell\\Documents\\ClinicTexts\\visits.txt";
    private static String drugpath = "C:\\Users\\WinSell\\Documents\\ClinicTexts\\drugs.txt";

    //******************************************************************************************

    public static ArrayList<Nurse> nurses = new ArrayList<>();
    public static ArrayList<Personnel> personnels = new ArrayList<>();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Visit> visits = new ArrayList<>();
    public static ArrayList<Drug> drugs = new ArrayList<>();

    //******************************************************************************************

    public static Nurse getNurse(int id) {
        Nurse nurse = null;
        for (Nurse n : nurses) {
            if (n.nid == id) {
                nurse = n;
                break;
            }
        }

        return nurse;
    }

    public static Personnel getPersonnel(int id) {
        Personnel personnel = null;
        for (Personnel p : personnels) {
            if (p.pid == id) {
                personnel = p;
                break;
            }
        }
        return personnel;
    }

    public static Doctor getDoctor(int id) {
        Doctor doctor = null;
        for (Doctor d : doctors) {
            if (d.did == id) {
                doctor = d;
                break;
            }
        }

        return doctor;
    }

    public static Patient getPatient(int id) {
        Patient patient = null;
        for (Patient p : patients) {
            if (p.pid == id) {
                patient = p;
                break;
            }
        }
        return patient;
    }

    public static Visit getVisit(int id) {
        Visit visit = null;
        for (Visit v : visits) {
            if (v.vid == id) {
                visit = v;
                break;
            }
        }
        return visit;
    }

    public static Drug getDrug(int id) {
        Drug drug = null;
        for (Drug d : drugs) {
            if (d.drugid == id) {
                drug = d;
                break;
            }
        }
        return drug;
    }

    //******************************************************************************************

    public static void showDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public static void showPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public static void showVisits() {
        for (Visit visit : visits) {
            System.out.println(visit);
        }
    }

    public static void showDrugs() {
        for (Drug drug : drugs) {
            System.out.println(drug);
        }
    }

    public static void showPersonnel() {
        for (Personnel personnel : personnels) {
            System.out.println(personnel);
        }
    }

    public static void showNurses() {
        for (Nurse nurse : nurses) {
            System.out.println(nurse);
        }
    }

    //******************************************************************************************

    public static void writeDoctor() {
        try {
            FileOutputStream fout = new FileOutputStream(doctorpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Doctor d : doctors) {
                out.writeObject(d);
            }

            out.close();
            System.out.println("Doctor data has been successfully written to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while writing the doctor data to the file.");
        }
    }

    public static void readDoctors() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(doctorpath));) {

            while (true) {
                Doctor d = (Doctor) in.readObject();
                doctors.add(d);
            }

        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (doctors.size() != 0) {
                int n = doctors.size() - 1;
                Doctor.dID = doctors.get(n).did + 1;
            }
        }

    }


    public static void writePatient() {
        try {
            FileOutputStream fout = new FileOutputStream(patientpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Patient p : patients) {
                out.writeObject(p);
            }

            out.close();
            System.out.println("Patient data has been successfully written to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while writing the patient data to the file.");
        }
    }

    public static void readPatient() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(patientpath));) {

            while (true) {
                Patient p = (Patient) in.readObject();
                patients.add(p);
            }

        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (patients.size() != 0) {
                int n = patients.size() - 1;
                Doctor.dID = patients.get(n).pid + 1;
            }
        }

    }

    public static void writeVisit() {
        try {
            FileOutputStream fout = new FileOutputStream(visitpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Visit v : visits) {
                out.writeObject(v);
            }

            out.close();
            System.out.println("Visit data has been successfully written to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while writing the visit data to the file.");
        }
    }

    public static void readVisit() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(visitpath));) {

            while (true) {
                Visit v = (Visit) in.readObject();
                visits.add(v);
            }

        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (visits.size() != 0) {
                int n = visits.size() - 1;
                Visit.VID = visits.get(n).vid + 1;
            }
        }
    }


    public static void writeNurse() {
        try {
            FileOutputStream fout = new FileOutputStream(nursepath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Nurse n : nurses) {
                out.writeObject(n);
            }

            out.close();
            System.out.println("Nurse data has been successfully written to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while writing the nurse data to the file.");
        }
    }

    public static void readNurse() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nursepath))) {

            while (true) {
                Nurse n = (Nurse) in.readObject();
                nurses.add(n);
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (nurses.size() != 0) {
                int n = nurses.size() - 1;
                Nurse.Nid = nurses.get(n).nid + 1;
            }
        }
    }


    public static void writePersonnel() {
        try {
            FileOutputStream fout = new FileOutputStream(personnelpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Personnel p : personnels) {
                out.writeObject(p);
            }

            out.close();
            System.out.println("Personnel data has been successfully written to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while writing the personnel data to the file.");
        }
    }


    public static void readPersonnels() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(personnelpath))) {

            while (true) {
                Personnel p = (Personnel) in.readObject();
                personnels.add(p);
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (personnels.size() != 0) {
                int n = personnels.size() - 1;
                Personnel.Pid = personnels.get(n).pid + 1;
            }
        }
    }

    public static void writeDrugs() {
        try {
            FileOutputStream fout = new FileOutputStream(drugpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);

            for (Drug drug : drugs) {
                out.writeObject(drug);
            }

            out.close();
            System.out.println("Drug data has been successfully written to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while writing the drug data to the file.");
        }
    }

    public static void readDrugs() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(drugpath))) {
            while (true) {
                Drug drug = (Drug) in.readObject();
                drugs.add(drug);
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached.");

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (drugs.size() != 0) {
                int n = drugs.size() - 1;
                Drug.DRUGID = drugs.get(n).drugid + 1;
            }
        }
    }

    //******************************************************************************************


    public static void save(Doctor doctor) {
        doctors.add(doctor);
        writeDoctor();
    }

    public static void save(Patient patient) {
        patients.add(patient);
        writePatient();
    }

    public static void save(Visit visit) {
        visits.add(visit);
        writeVisit();
    }

    public static void save(Nurse nurse) {
        nurses.add(nurse);
        writeNurse();
    }

    public static void save(Drug drug) {
        drugs.add(drug);
        writeDrugs();
    }

    public static void save(Personnel personnel) {
        personnels.add(personnel);
        writePersonnel();
    }


    public static void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
        writeDoctor();
    }

    public static void removeNurse(Nurse nurse) {
        nurses.remove(nurse);
        writeNurse();
    }

    public static void removeDrug(Drug drug) {
        drugs.remove(drug);
        writeDrugs();
    }

    public static void removePersonnel(Personnel personnel) {
        personnels.remove(personnel);
        writePersonnel();
    }

    public static void removePatient(Patient patient) {
        patients.remove(patient);
        writePatient();
    }

    public static void removeVisit(Visit visit) {
        visits.remove(visit);
        writeVisit();
    }

    public static void search(Doctor doctor) {
        boolean found = false;
        int i = 0;
        for (Doctor d : doctors) {
            if (d.did == doctors.get(i).did) {
                System.out.println("Doctor found!");
                found = true;
                removeDoctor(d);
                System.out.println("Doctor removed successfully.");
                break;
            }
            i++;
        }
        if (!found) {
            System.out.println("Doctor wasn't found");
        }
    }

    public static void search(Patient patient) {
        boolean found = false;
        int i = 0;
        for (Patient p : patients) {
            if (patients.get(i).getNationalCode() == p.getNationalCode()) {
                System.out.println("Patient found!");
                found = true;
                removePatient(p);
                System.out.println("Patient removed successfully.");
                break;
            }
            i++;
        }
        if (!found) {
            System.out.println("Patient wasn't found");
        }
    }

    public static void search(Nurse nurse) {
        boolean found = false;
        int i = 0;
        for (Nurse n : nurses) {
            if (n.nid == nurses.get(i).nid) {
                System.out.println("Nurse found!");
                found = true;
                removeNurse(n);
                System.out.println("Nurse removed successfully.");
                break;
            }
            i++;
        }
        if (!found) {
            System.out.println("Nurse wasn't found");
        }
    }

    public static void search(Personnel personnel) {
        boolean found = false;
        int i = 0;
        for (Personnel p : personnels) {
            if (p.pid == personnels.get(i).pid) {
                System.out.println("Personnel found!");
                found = true;
                removePersonnel(p);
                System.out.println("Personnel removed successfully.");
                break;
            }
            i++;
        }
        if (!found) {
            System.out.println("Personnel wasn't found");
        }
    }

    public static void search(Visit visit) {
        boolean found = false;
        int i = 0;
        for (Visit v : visits) {
            if (v.getPatient().getNationalCode() == visits.get(i).getPatient().getNationalCode()) {
                System.out.println("Visit found!");
                found = true;
                removeVisit(v);
                System.out.println("Visit removed successfully.");
                break;
            }
            i++;
        }
        if (!found) {
            System.out.println("Visit wasn't found");
        }
    }

    public static void search(Drug drug) {
        boolean found = false;
        int i = 0;
        for (Drug d : drugs) {
            if (d.drugid == drugs.get(i).drugid) {
                System.out.println("Drug found!");
                found = true;
                removeDrug(d);
                System.out.println("Drug removed successfully.");
                break;
            }
            i++;
        }
        if (!found) {
            System.out.println("Drug wasn't found");
        }
    }
}

//*****************************************************************************************************

