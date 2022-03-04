package codegym.project.demo.demo.services.impl;

import codegym.project.demo.demo.model.Employee;
import codegym.project.demo.demo.repositories.EmployeeRepo;
import codegym.project.demo.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public void delete(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeRepo.delete(employee);
        }
    }
}
