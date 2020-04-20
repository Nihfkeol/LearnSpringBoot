package com.nihfkeol.mapper;

import com.nihfkeol.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
