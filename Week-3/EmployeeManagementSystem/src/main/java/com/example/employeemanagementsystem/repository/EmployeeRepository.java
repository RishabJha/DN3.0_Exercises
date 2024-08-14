package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.projection.EmployeeProjectionClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain")
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    @Query(name = "Employee.findByEmail")
    List<Employee> findByEmail(@Param("email") String email);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("name") String name);

    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT new com.example.employeemanagementsystem.projection.EmployeeProjectionClass(e.name, e.email) FROM Employee e")
    List<EmployeeProjection> findAllEmployeeProjections();


}
