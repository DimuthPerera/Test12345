package hms;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "address", "phoneNumber", "name" })
public class Student {

    private int ID;
    private String name;
    private String address;
    private long phoneNumber;

    public Student(int pID, String pName, String pAddress, long pPhoneNum) {
        this.ID = pID;
        this.name = pName;
        this.address = pAddress;
        this.phoneNumber = pPhoneNum;
    }

    public Student(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printData(){
        System.out.println("ID : " + this.ID);
        System.out.println("Name : " + name);
        System.out.println("Address : " + address);
        System.out.println("Phone Number : " + phoneNumber);
    }
}
