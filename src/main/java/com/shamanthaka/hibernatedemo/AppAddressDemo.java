package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.model.EmpAddress;
import com.shamanthaka.hibernatedemo.model.EmpProjectAllocation;
import com.shamanthaka.hibernatedemo.repository.EmpAddressRepository;
import lombok.extern.log4j.Log4j;

@Log4j
public class AppAddressDemo {
    EmpAddressRepository empAddressRepository = new EmpAddressRepository();
    public void getAllEmpAddress(){
        empAddressRepository.getAll().stream().forEach(ep->{
            log.info(ep.getAddress() + "\t" + ep.getAddressType());
        });
    }
    public void addEmpAddress(){
        EmpAddress empAddress = App4.populateAddress();

        empAddressRepository.save(empAddress);
    }

    public void updateEmpAddress(){
        EmpAddress empAddress = new EmpAddress();
        empAddress.setAddressId(4);
        //empAddress.setEmpId(1);
        empAddress.setZipCode(98989898);
        empAddress.setAddress("Cincinatti");
        empAddress.setAddressType("Personal");
        empAddressRepository.update(empAddress);
    }
    public void deleteEmpAddress(){

        empAddressRepository.delete(3);
    }

    public static void main(String[] args) {
       AppAddressDemo appAddressDemo = new AppAddressDemo();
       //appAddressDemo.addEmpAddress();
        //appAddressDemo.updateEmpAddress();
        appAddressDemo.deleteEmpAddress();
        appAddressDemo.getAllEmpAddress();



    }
}
