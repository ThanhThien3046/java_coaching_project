package com.unigap.java_coaching_project.vn.unigap.api.service;

import com.unigap.java_coaching_project.vn.unigap.api.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    //Them nhan vien
    public Employee addEmployee(Employee employee);

    //Chinh sua thong tin nhan vien
    public Employee updateEmployee(long id, Employee employee);

    //Xoa nhan vien
    public boolean deleteEmployee(long id);

    //Ham lay ra ds nhan vien
    public List<Employee> getAllEmployee();

    //Ham lay ra mot nhan vien
    public Employee getOneEmployee(long id);

}
