package com.loria_university.entity;

import com.loria_university.validation.CheckEmail;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "This field could not be empty")
    @Size(min = 2, message = "Name must contain min 2 symbols")
    private String name;

    @Column(name = "course")
    @Min(value = 1, message = "Course value must be between 1 and 5")
    @Max(value = 5, message = "Course value must be between 1 and 5")
    private int course;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\+\\d{3}-\\d{2}-\\d{3}-\\d{2}-\\d{2}", message = "Phone number must look like: +XXX-XX-XXX-XX-XX")
    private String phoneNumber;

    @Column(name = "email")
    @CheckEmail
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "book_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;

    public Student() {
    }

    public Student(int id, String name, int course, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void addBookToStudent(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }

    public void removeBookOfStudent(Book book) {
        books.remove(book);
    }

    public void addTeacherToStudent(Teacher teacher) {
        if (teachers == null) {
            teachers = new ArrayList<>();
        }
        teachers.add(teacher);
    }

    public void removeTeacherOfStudent(Teacher teacher) {
        teachers.remove(teacher);
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
