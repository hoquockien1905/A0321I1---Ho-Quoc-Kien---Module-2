package codegym.project.demo.demo.repositories;

import codegym.project.demo.demo.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Long> {
}
