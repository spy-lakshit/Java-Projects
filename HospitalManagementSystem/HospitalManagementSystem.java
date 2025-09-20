import java.util.ArrayList;
import java.util.Scanner;

// Patient class
class Patient {
    private String id;
    private String name;
    private int age;
    private String disease;

    public Patient(String id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}

// Doctor class
class Doctor {
    private String id;
    private String name;
    private String specialization;

    public Doctor(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public String getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("\n--- Doctor Details ---");
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

// Appointment class
class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public void displayInfo() {
        System.out.println("\n--- Appointment Details ---");
        System.out.println("Patient: " + patient.getId());
        System.out.println("Doctor: " + doctor.getId());
        System.out.println("Date: " + date);
    }
}

// Main Hospital Management System
public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Hospital Management System ====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String pid = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int page = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();
                    patients.add(new Patient(pid, pname, page, disease));
                    System.out.println("✅ Patient added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Doctor ID: ");
                    String did = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();
                    doctors.add(new Doctor(did, dname, spec));
                    System.out.println("✅ Doctor added successfully!");
                    break;

                case 3:
                    if (patients.isEmpty() || doctors.isEmpty()) {
                        System.out.println("⚠️ Add patients and doctors first!");
                        break;
                    }
                    System.out.print("Enter Patient ID: ");
                    String apid = sc.nextLine();
                    Patient patient = null;
                    for (Patient p : patients) {
                        if (p.getId().equals(apid)) {
                            patient = p;
                            break;
                        }
                    }
                    if (patient == null) {
                        System.out.println("⚠️ Patient not found!");
                        break;
                    }

                    System.out.print("Enter Doctor ID: ");
                    String adid = sc.nextLine();
                    Doctor doctor = null;
                    for (Doctor d : doctors) {
                        if (d.getId().equals(adid)) {
                            doctor = d;
                            break;
                        }
                    }
                    if (doctor == null) {
                        System.out.println("⚠️ Doctor not found!");
                        break;
                    }

                    System.out.print("Enter Appointment Date (dd-mm-yyyy): ");
                    String date = sc.nextLine();
                    appointments.add(new Appointment(patient, doctor, date));
                    System.out.println("✅ Appointment scheduled successfully!");
                    break;

                case 4:
                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {
                        for (Patient p : patients) p.displayInfo();
                    }
                    break;

                case 5:
                    if (doctors.isEmpty()) {
                        System.out.println("No doctors found.");
                    } else {
                        for (Doctor d : doctors) d.displayInfo();
                    }
                    break;

                case 6:
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments found.");
                    } else {
                        for (Appointment a : appointments) a.displayInfo();
                    }
                    break;

                case 7:
                    System.out.println("👋 Exiting the system. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}
