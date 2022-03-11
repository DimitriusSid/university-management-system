package com.loria_university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TeacherPersonalInfo {

    @Column(name = "name")
    @NotBlank(message = "This field could not be empty")
    @Size(min = 2, message = "Name must contain min 2 symbols")
    private String name;

    @Column(name = "salary")
    @Min(value = 1, message = "Salary must be greater than 1")
    private int salary;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\+\\d{3}-\\d{2}-\\d{3}-\\d{2}-\\d{2}", message = "Phone number must look like: +XXX-XX-XXX-XX-XX")
    private String phoneNumber;

}
