package com.shamanthaka.hibernatedemo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "EMP_DOCUMENT")
public class EmpDocument {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private Integer docId;


    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private EmployeePersonal employeePersonal;

    @Column(name = "DOC_TYPE")
    private String docType;

    @Column(name = "DOC_NUMBER")
    private Integer docNumber;

    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;

    public EmpDocument(){}

    public EmpDocument(int docId,String docType,int docNumber, Date expiryDate){
        this.docId = docId;
        this.docType = docType;
        this.docNumber = docNumber;
        this.expiryDate = expiryDate;

    }

}
