package com.EasyToCode.Employee.Management.Demo.repository;

import com.EasyToCode.Employee.Management.Demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
