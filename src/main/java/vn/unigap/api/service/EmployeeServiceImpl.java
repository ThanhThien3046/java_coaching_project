package vn.unigap.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import vn.unigap.api.dto.in.EmployeeDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.EmployeeDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.Employee;
import vn.unigap.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.unigap.common.errorcode.ErrorCode;
import vn.unigap.common.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
//
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDtoOut addEmployee(EmployeeDtoIn employeeDtoIn) {

        EmployeeDtoOut employeeDtoOut = new EmployeeDtoOut();
//        employeeDtoOut.setId(1L);
//        employeeDtoOut.setName("Thien");
//        employeeDtoOut.setEmail(employee.getEmail());
//        employeeDtoOut.setProvince(employee.getProvince());
//        employeeDtoOut.setDescription(employee.getDescription());

        Employee employee = employeeRepository.save(Employee.builder()
                .email(employeeDtoIn.getEmail())
                .name(employeeDtoIn.getName())
                .province(employeeDtoIn.getProvince())
                .description(employeeDtoIn.getDescription())
                .build());

//        employeeRepository.save(employeeDtoOut);
        return employeeDtoOut.from(employee);
    }


    @Override
    public EmployeeDtoOut updateEmployee(long id, EmployeeDtoIn employeeDtoIn) {
        EmployeeDtoOut employeeDtoOut = new EmployeeDtoOut();
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "user not found")
        );
        if(employeeDtoIn != null){
//            Employee employee1 = employeeRepository.getById(id);
            if(employeeDtoIn.getName() != null) {
                employee.setEmail(employeeDtoIn.getEmail());
                employee.setName(employeeDtoIn.getName());
                employee.setProvince(employeeDtoIn.getProvince());
                employee.setDescription(employeeDtoIn.getDescription());
                employee = employeeRepository.save(employee);
                return  employeeDtoOut.from(employee);

//                return employeeRepository.save(employee1);
            }
        }
        return null;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "user not found")
        );

        employeeRepository.delete(employee);
//        if(id>=1){
////            EmployeeDtoIn employee = employeeRepository.getById(id);
//            EmployeeDtoIn employeeDtoIn = new EmployeeDtoIn();
//            if(employeeDtoIn != null) {
////                employeeRepository.delete(employee);
//                employeeDtoIn.setName("");
//                employeeDtoIn.setEmail("");
//                employeeDtoIn.setProvince(null);
//                employeeDtoIn.setDescription("");
//                return true;
//            }
//        }
//        return false;
    }

     @Override
    public PageDtoOut<EmployeeDtoOut> getAllEmployee(PageDtoIn pageDtoIn) {
         Page<Employee> users = this.employeeRepository.findAll(PageRequest.of(pageDtoIn.getPage() - 1, pageDtoIn.getPageSize(),
                 Sort.by("id").ascending()));
         return PageDtoOut.from(pageDtoIn.getPage(), pageDtoIn.getPageSize(), users.getTotalElements(),
                 users.stream().map(EmployeeDtoOut::from).toList());
//
//        EmployeeDtoOut employee1 = new EmployeeDtoOut();
//        employee1.setId(1L);
//        employee1.setDescription("employee1");
//        employee1.setEmail("employee1@gmail.com");
//        employee1.setProvince(1);
//
//        EmployeeDtoOut employee2 = new EmployeeDtoOut();
//        employee1.setId(2L);
//        employee1.setDescription("employee2");
//        employee1.setEmail("employee2@gmail.com");
//        employee1.setProvince(1);
//
//        List<EmployeeDtoOut> employeeDtoOuts = new ArrayList<>();
//        employeeDtoOuts.add(employee1);
//        employeeDtoOuts.add(employee2);
//        return employeeDtoOuts;
    }

//    @Override
//    public Employee getOneEmployee(long id) {
//        return employeeRepository.getById(id);
//    }
}
