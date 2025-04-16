package edu.e_g.service;

import edu.e_g.dto.Family;
import edu.e_g.dto.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    boolean savePerson(Person person);
    boolean updatePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(Long personId);
    Map<Person, Family> getFamilyDetailsByPersonId(Long personId);
    boolean deletePersonById(Long personId);
}
