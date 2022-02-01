package com.loria_university.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "author")
    @Size(min = 2, message = "Author name must contain min 2 symbols")
    @NotBlank(message = "This field could not be empty")
    private String authorName;

    @Column(name = "title")
    @Size(min = 2, message = "Title of a book must contain min 2 symbols")
    @NotBlank(message = "This field could not be empty")
    private String title;

    @Column(name = "year")
    @Max(value = 2022, message = "Field value must be between 1 and 2022")
    @Min(value = 1, message = "Field value must be between 1 and 2022")
    private int year;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "book_student",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Book() {
    }

    public Book(String authorName, String title, int year) {
        this.authorName = authorName;
        this.title = title;
        this.year = year;
    }

    public void addStudentToBook(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public void removeStudentOfBook(Student student) {
        students.remove(student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
