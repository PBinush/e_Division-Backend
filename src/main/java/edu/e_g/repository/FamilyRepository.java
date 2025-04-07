package edu.e_g.repository;


import edu.e_g.entity.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<FamilyEntity,Long> {
}
