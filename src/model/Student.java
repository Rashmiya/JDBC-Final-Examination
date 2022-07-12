package model;

public class Student {
    private String student_ID;
    private String student_Name;
    private String email;
    private String contact;
    private String address;
    private String nic;

    public Student(String student_ID, String student_Name, String email, String contact, String address, String nic) {
        this.student_ID = student_ID;
        this.student_Name = student_Name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.nic = nic;
    }

    public Student() {
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_ID='" + student_ID + '\'' +
                ", student_Name='" + student_Name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
