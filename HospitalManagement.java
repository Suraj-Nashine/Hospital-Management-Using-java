/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;

/**
 *
 * @author HP
 */

import java.util.*;

class Patient {
    private String name;
    private String id;
    private String contact;

    public Patient(String name, String id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }
}

class Appointment {
    private String patientId;
    private String doctorId;
    private Date date;

    public Appointment(String patientId, String doctorId, Date date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Date getDate() {
        return date;
    }
}

class ElectronicHealthRecord {
    private String patientId;
    private String record;

    public ElectronicHealthRecord(String patientId, String record) {
        this.patientId = patientId;
        this.record = record;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getRecord() {
        return record;
    }
}

class Bill {
    private String patientId;
    private double amount;

    public Bill(String patientId, double amount) {
        this.patientId = patientId;
        this.amount = amount;
    }

    public String getPatientId() {
        return patientId;
    }

    public double getAmount() {
        return amount;
    }
}

class InventoryItem {
    private String name;
    private int quantity;

    public InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}

class Staff {
    private String name;
    private String id;

    public Staff(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class HospitalManagementSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<ElectronicHealthRecord> ehrList = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();
    private List<InventoryItem> inventory = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();

    public void registerPatient(String name, String id, String contact) {
        patients.add(new Patient(name, id, contact));
        System.out.println("Patient registered: " + name);
    }

    public void scheduleAppointment(String patientId, String doctorId, Date date) {
        appointments.add(new Appointment(patientId, doctorId, date));
        System.out.println("Appointment scheduled for patient ID: " + patientId);
    }

    public void addEHR(String patientId, String record) {
        ehrList.add(new ElectronicHealthRecord(patientId, record));
        System.out.println("EHR added for patient ID: " + patientId);
    }

    public void createBill(String patientId, double amount) {
        bills.add(new Bill(patientId, amount));
        System.out.println("Bill created for patient ID: " + patientId);
    }

    public void addInventoryItem(String name, int quantity) {
        inventory.add(new InventoryItem(name, quantity));
        System.out.println("Inventory item added: " + name);
    }

    public void addStaff(String name, String id) {
        staffMembers.add(new Staff(name, id));
        System.out.println("Staff member added: " + name);
    }

    public void displayPatients() {
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("Name: " + patient.getName() + ", ID: " + patient.getId() + ", Contact: " + patient.getContact());
        }
    }

    public void displayAppointments() {
        System.out.println("Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println("Patient ID: " + appointment.getPatientId() + ", Doctor ID: " + appointment.getDoctorId() + ", Date: " + appointment.getDate());
        }
    }

    public void displayEHRs() {
        System.out.println("Electronic Health Records:");
        for (ElectronicHealthRecord ehr : ehrList) {
            System.out.println("Patient ID: " + ehr.getPatientId() + ", Record: " + ehr.getRecord());
        }
    }

    public void displayBills() {
        System.out.println("Bills:");
        for (Bill bill : bills) {
            System.out.println("Patient ID: " + bill.getPatientId() + ", Amount: " + bill.getAmount());
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (InventoryItem item : inventory) {
            System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity());
        }
    }

    public void displayStaff() {
        System.out.println("Staff Members:");
        for (Staff staff : staffMembers) {
            System.out.println("Name: " + staff.getName() + ", ID: " + staff.getId());
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        
        // Sample data
        hms.registerPatient("Suraj Nashine", "P001", "8564164452");
        hms.registerPatient("Rohit kale", "P002", "9632587415");
        
        hms.addStaff("Dr. Alice", "S001");
        hms.addStaff("Nurse Bob", "S002");
        
        hms.scheduleAppointment("P001", "S001", new Date());
        hms.addEHR("P001", "Allergy to penicillin");
        hms.createBill("P001", 150.00);
        hms.addInventoryItem("Syringe", 100);
        
        // Display all records
        hms.displayPatients();
        hms.displayAppointments();
        hms.displayEHRs();
        hms.displayBills();
        hms.displayInventory();
        hms.displayStaff();
    }
} 