package com.ibetar.testingdemo.presistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3 , max = 10)
    @Column(name = "first_name", nullable = false)
    private String firstname;

    @NotBlank
    @Size(min = 3 , max = 10)
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotBlank
    @Size(min = 5 , max = 25)
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank
    @Column(name = "dni", nullable = false)
    private int dni;

    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

}
