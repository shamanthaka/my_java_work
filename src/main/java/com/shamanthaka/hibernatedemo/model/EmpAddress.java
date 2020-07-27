package com.shamanthaka.hibernatedemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "EMP_ADDRESS")
public class EmpAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Integer addressId;


    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private EmployeePersonal employeePersonal;


    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    @Column(name = "ZIP_CODE")
    private Integer zipCode;



    public EmpAddress(){}

    public EmpAddress( String address, String addressType,int zipCode){

        this.address = address;
        this.addressType = addressType;
        this.zipCode = zipCode;

    }



}
