package com.shamanthaka.trng;
import com.shamanthaka.constant.AppConstant;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class Employee {
    private String name;
    private Integer age;

    public void setName(String name) throws MyException1{
        if( StringUtils.isEmpty(name)) {
            throw new MyException1(AppConstant.NAME_ERROR);
        }
        this.name = name;
    }

    public void setAge(Integer age) throws MyException1{
        if(age < 15) {
            throw new MyException1(AppConstant.AGE_ERROR);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
