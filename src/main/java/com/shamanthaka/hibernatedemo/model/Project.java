package com.shamanthaka.hibernatedemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = " PROJECT ")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private Integer projectId;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "Technologies")
    private String technologies;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;


    @ManyToMany//this is the owning side
    @JoinTable(name="PROJECT_EMP_PROJECT_ALLOCATION", joinColumns = {@JoinColumn(name="PROJECT_ID")},
            inverseJoinColumns = {@JoinColumn(name="ALLOCATION_ID")})
    private Set<EmpProjectAllocation> projectAllocationSet;

    public Project(){}
    public Project(String projectName,String technologies,
                      String remarks, Date startDate,Date endDate,String projectStatus){

        this.projectName = projectName;
        this.technologies = technologies;
        this.remarks = remarks;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
    }
}
