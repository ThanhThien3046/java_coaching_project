package vn.unigap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.api.dto.in.EmployeeDtoIn;
import vn.unigap.api.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void delete(Employee employee);
}
