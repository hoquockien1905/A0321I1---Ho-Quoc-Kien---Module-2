package codegym.project.demo.demo.services.impl;

import codegym.project.demo.demo.model.Division;
import codegym.project.demo.demo.repositories.DivisionRepo;
import codegym.project.demo.demo.services.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepo divisionRepo;

    @Override
    public List<Division> findAll() {
        return divisionRepo.findAll();
    }
}
