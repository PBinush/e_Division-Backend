package edu.e_g.repository;

import edu.e_g.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<PersonEntity,Long>{
   List<PersonEntity> findByFirstNameContainingIgnoreCase(String firstName);
   PersonEntity findByNicContainingIgnoreCase(String nic);
}
