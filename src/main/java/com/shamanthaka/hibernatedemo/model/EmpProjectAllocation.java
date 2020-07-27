package com.shamanthaka.hibernatedemo.model;
import com.shamanthaka.assignment3.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = " EMP_PROJECT_ALLOCATION ")
public class EmpProjectAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALLOCATION_ID")
    private Integer allocationId;

    @Column(name = "PROJECT_ID")
    private Integer projectId;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn (name = "EMP_ID")
    private EmployeePersonal employeePersonal;

    @Column(name = "ALLOCATION_STATUS")
    private String allocationStatus;

    @ManyToMany(mappedBy = "projectAllocationSet")
    private Set<Project> projectSet;



    public void empProjectAllocation(){}

    public void empProjectAllocation(int allocationId, int projectId,String allocationStatus){
        this.allocationId = allocationId;
        this.projectId = projectId;
        //this.empId = empId;
        this.allocationStatus = allocationStatus;
    }
}
