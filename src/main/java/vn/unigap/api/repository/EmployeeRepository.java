package com.unigap.java_coaching_project.vn.unigap.api.repository;

import com.unigap.java_coaching_project.vn.unigap.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
