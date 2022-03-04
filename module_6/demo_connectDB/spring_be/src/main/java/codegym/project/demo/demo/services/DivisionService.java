package codegym.project.demo.demo.services;

import codegym.project.demo.demo.model.Division;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DivisionService {
    List<Division> findAll();
}
