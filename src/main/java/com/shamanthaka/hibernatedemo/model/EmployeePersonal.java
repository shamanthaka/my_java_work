package com.shamanthaka.hibernatedemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "EMP_PERSONAL")
public class EmployeePersonal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Integer empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "EMP_DOJ")
    private Date doj;

    @Column(name = "EMP_CONTACT")
    private String empContact;

    @Column(name = "EMP_EMAIL")
    private String empEmail;

    @Column(name = "EMP_DOB")
    private Date dob;

    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmpDocument> empDocumentSet;

    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmpAddress> empAddresSet;

    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmpEducation> empEducation;


  }
