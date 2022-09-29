package com.luxoft.employee.batch;

import com.luxoft.employee.model.Employee;
import com.luxoft.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EmployeeBirthdayBatch {

    @Autowired
    EmployeeRepository employeeRepository;

    @Scheduled(fixedDelay = 5000)
    public void sendBirthdayEmail() {
        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonthValue();
        List<Employee> employees = employeeRepository.findByBirthDay(day, month);
        //Triggering email to employees
        employees.forEach(e->System.out.println(e));
    }
}
