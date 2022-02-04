package com.loria_university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public void addStudentToTeacher(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public void removeStudentOfTeacher(Student student) {
        students.remove(student);
    }
}
