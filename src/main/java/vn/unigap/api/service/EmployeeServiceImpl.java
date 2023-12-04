package com.unigap.java_coaching_project.vn.unigap.api.service;

import com.unigap.java_coaching_project.vn.unigap.api.entity.Employee;
import com.unigap.java_coaching_project.vn.unigap.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired

    private EmployeeRepository employeeRepository;


    @Override
    public Employee addEmployee(Employee employee) {
        if (employee != null){
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        if(employee != null){
            Employee employee1 = employeeRepository.getById(id);
            if(employee != null) {
                employee1.setName(employee.getName());
                employee1.setAddress(employee.getAddress());

                return employeeRepository.save(employee1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        if(id>=1){
            Employee employee = employeeRepository.getById(id);
            if(employee != null) {
                employeeRepository.delete(employee);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployee() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee getOneEmployee(long id) {
        return employeeRepository.getById(id);
    }
}
