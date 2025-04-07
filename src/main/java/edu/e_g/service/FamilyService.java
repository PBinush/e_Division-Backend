package edu.e_g.service;

import edu.e_g.dto.Family;
import edu.e_g.dto.Person;
import edu.e_g.entity.FamilyEntity;
import edu.e_g.entity.PersonEntity;

import java.util.List;
import java.util.Map;

public interface FamilyService {

    Boolean saveFamily(Family family);

    Map<String,Object> getAllFamily();

    Family searchFamilyById(Long id);

    Boolean updateFamily(Family family);

    Boolean deleteFamily(Long id);

    Boolean savePerson(Person person);

    Map<String,Object> getAllPerson();

    Person searchPersonById(String nic);

    List<Person> searchPersonByName(String firstName);

    Boolean updatePerson(Person person);

    Boolean deletePersonById(String id);



}
