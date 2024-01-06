package vn.unigap.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.unigap.api.dto.in.EmployeeDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.EmployeeDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.Employee;
import vn.unigap.api.repository.EmployeeRepository;

import java.util.List;

public interface IEmployeeService {
    //Them nhan vien
    public EmployeeDtoOut addEmployee(EmployeeDtoIn employee);

    //Chinh sua thong tin nhan vien
    public EmployeeDtoOut updateEmployee(long id, EmployeeDtoIn employeeDtoIn);

    //Xoa nhan vien
    public void deleteEmployee(long id);

    //Ham lay ra ds nhan vien
    public PageDtoOut<EmployeeDtoOut> getAllEmployee(PageDtoIn pageDtoIn);

    //Ham lay ra mot nhan vien
//    public Employee getOneEmployee(long id);

}
