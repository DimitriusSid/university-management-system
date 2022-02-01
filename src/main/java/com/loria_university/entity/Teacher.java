package com.loria_university.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "This field could not be empty")
    @Size(min = 2, message = "Name must contain min 2 symbols")
    private String name;

    @Column(name = "subject")
    @NotBlank(message = "This field could not be empty")
    @Size(min = 2, message = "Subject name must contain min 2 symbols")
    private String subject;

    @Column(name = "salary")
    @Min(value = 1, message = "Salary must be greater than 1")
    private int salary;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\+\\d{3}-\\d{2}-\\d{3}-\\d{2}-\\d{2}", message = "Phone number must look like: +XXX-XX-XXX-XX-XX")
    private String phoneNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(String name, String subject, int salary, String phoneNumber) {
        this.name = name;
        this.subject = subject;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public void addStudentToTeacher(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public void removeStudentOfTeacher(Student student) {
        students.remove(student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", salary=" + salary +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
