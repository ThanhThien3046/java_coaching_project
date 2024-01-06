package vn.unigap.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.unigap.api.dto.in.EmployeeDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.EmployeeDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.Employee;
import vn.unigap.api.service.EmployeeServiceImpl;
import vn.unigap.api.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private List<Employee> employeelist;

    @Autowired
    private EmployeeServiceImpl iEmployeeService;
    //Test
    @GetMapping("/")
    public String test(){
        return "timoday";
    }

    //API and employee
    @PostMapping("/add/")
//    public ResponseEntity<?> addEmployee(@RequestBody @Valid UserDtoIn userDtoIn){
//        return iEmployeeService.addEmployee(userDtoIn);
//    }
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDtoIn employeeDtoIn){

        EmployeeDtoOut employeeDtoOut = iEmployeeService.addEmployee(employeeDtoIn);
        return new ResponseEntity<>(employeeDtoOut, HttpStatus.CREATED);
    }

    //API update employee
    @PutMapping("/{id}")
    public EmployeeDtoOut updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeDtoIn employeeDtoIn) {
        return iEmployeeService.updateEmployee(id,employeeDtoIn);
    }

//    //API delete
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") long id) {

         iEmployeeService.deleteEmployee(id);
    }

//    //API lay danh sach
    @GetMapping("/list")
    public ResponseEntity<?> getAllEmployee(PageDtoIn pageDtoIn){
        PageDtoOut<EmployeeDtoOut> employeeDtoOuts = iEmployeeService.getAllEmployee(pageDtoIn);
        return ResponseEntity.ok(employeeDtoOuts);
    }
}
