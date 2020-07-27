package com.shamanthaka.hibernatedemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name =" EMP_EDUCATION")
public class EmpEducation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "EDUCATION_ID")
    private Integer educationId;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn (name = "EMP_ID")
    private EmployeePersonal employeePersonal;

    @Column(name = "EDUCATION_NAME")
    private String educationName;

    @Column(name = "INSTITUTE_NAME")
    private String instituteName;

    @Column(name = "PASSING_YEAR")
    private Integer passingYear;

    @Column(name = "PERCENTAGE")
    private Double percentage;

    @Column(name = "TYPE")
    private String type;

    public EmpEducation(){}
    public EmpEducation(String educationName, String instituteName,int passingYear, double percentage,String type){

        this.educationName = educationName;
        this.instituteName = instituteName;
        this.passingYear = passingYear;
        this.percentage = percentage;
        this.type = type;
    }

}
