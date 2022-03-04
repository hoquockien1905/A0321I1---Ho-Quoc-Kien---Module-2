package codegym.project.demo.demo.services;

import codegym.project.demo.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void delete(Long id);
}
