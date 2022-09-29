package com.luxoft.employee.repository;

import com.luxoft.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("Select e from Employee e  where month(e.dateOfBirth) = ?2 and day(e.dateOfBirth) = ?1")
    List<Employee> findByBirthDay(int day, int month);
}
