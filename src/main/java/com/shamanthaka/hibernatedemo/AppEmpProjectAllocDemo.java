package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.model.EmpProjectAllocation;
import com.shamanthaka.hibernatedemo.repository.EmpProjectAllocRepository;
import lombok.extern.log4j.Log4j;

@Log4j
public class AppEmpProjectAllocDemo {
    EmpProjectAllocRepository empProjectAllocRepository = new EmpProjectAllocRepository();
    public void addEmpProjectAllocation(){
        EmpProjectAllocation empProjectAllocation = new EmpProjectAllocation();
        empProjectAllocation.setAllocationStatus("Alloted");
        empProjectAllocation.setProjectId(2);
        //empProjectAllocation.setEmpId(13);

        empProjectAllocRepository.save(empProjectAllocation);
    }

    public  void  getAllProjAllocation(){
        empProjectAllocRepository.getAll().stream().forEach(e -> {
            log.info(e.getAllocationStatus()+ "\t"+ e.getAllocationId());
        });
    }

    public static void main(String[] args) {
        AppEmpProjectAllocDemo appEmpProjectAllocDemo = new AppEmpProjectAllocDemo();
        appEmpProjectAllocDemo.addEmpProjectAllocation();
        appEmpProjectAllocDemo.getAllProjAllocation();
    }
}
