package edu.e_g.service.impl;

import edu.e_g.dto.Family;
import edu.e_g.dto.Person;
import edu.e_g.dto.User;
import edu.e_g.entity.PersonEntity;
import edu.e_g.repository.PersonRepository;
import edu.e_g.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper mapper;

    @Override
    public boolean savePerson(Person person) {
        if (person == null || person.getName() == null || person.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid person");
        }
        return Optional.ofNullable(
                        mapper.map(personRepository.save(mapper.map(person, PersonEntity.class)), User.class)
                ).isPresent();
    }

    @Override
    public boolean updatePerson(Person person) {
        if (person == null || person.getName() == null || person.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid user");
        }
        return personRepository.findById(person.getPersonId())
                .map(existing -> personRepository.save(mapper.map(person, PersonEntity.class)))
                .map(saved -> mapper.map(saved, Person.class))
                .map(Person::getName)
                .filter(name -> !name.isEmpty())
                .isPresent();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(personEntity -> mapper.map(personEntity, Person.class))
                .toList();
    }

    @Override
    public Person getPersonById(Long personId) {
        if (personId == null) {
            throw new IllegalArgumentException("Invalid email");
        }
        PersonEntity person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return mapper.map(person,Person.class);
    }

    @Override
    public Map<Person, Family> getFamilyDetailsByPersonId(Long personId) {
        if (personId == null) {
            throw new IllegalArgumentException("Invalid email");
        }
        PersonEntity person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return Map.of(mapper.map(person, Person.class), personRepository.findById(person.getFamily())
                .map(familyEntity -> mapper.map(familyEntity, Family.class))
                .orElseThrow(() -> new IllegalArgumentException("Family not found")));
    }

    @Override
    public boolean deletePersonById(Long personId) {
        if (personId == null ){
            throw new IllegalArgumentException("Invalid id");
        }
        personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("user Not Found"));
        personRepository.deleteById(personId);
        return true;
    }
}
