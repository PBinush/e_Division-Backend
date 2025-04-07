package edu.e_g.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.e_g.dto.Family;
import edu.e_g.dto.Person;
import edu.e_g.entity.FamilyEntity;
import edu.e_g.entity.PersonEntity;
import edu.e_g.repository.FamilyRepository;
import edu.e_g.repository.PersonRepository;
import edu.e_g.service.FamilyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyServiceImpl implements FamilyService {

    final PersonRepository personRepository;
    final FamilyRepository familyRepository;
    final ObjectMapper objectMapper;

    @Override
    public Boolean saveFamily(Family family) {
        try {
            familyRepository.save(objectMapper.convertValue(family, FamilyEntity.class));
            return true;
        }catch (Exception e){
            log.info(" save error massage : "+e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean savePerson(@Valid Person person) {
        boolean personExists = personRepository.findAll().stream()
                .anyMatch(entity -> entity.getNic().equals(person.getNic()));

        if (personExists) {
            return false;
        }

        //duplicate wenawa
        //familyId null watenne table eke
        FamilyEntity familyEntity = null;
        if (person.getFamily() != null) {
            PersonEntity personEntity = new PersonEntity();
            personEntity.setNic(person.getNic());
            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());
            personEntity.setAddress(person.getAddress());
            personEntity.setGender(person.getGender());
            personEntity.setMaritalStatus(person.getMaritalStatus());
            personEntity.setEmail(person.getEmail());
            personEntity.setPhoneNumber(person.getPhoneNumber());
            personEntity.setDob(person.getDob());
            personEntity.setOccupation(person.getOccupation());
            personEntity.setSalary(person.getSalary());
            personEntity.setDiseased(person.getDiseased());

             familyEntity = familyRepository.findById(person.getFamily().getFamilyId())
                    .orElseThrow(() -> new RuntimeException("Family not found!"));
            personEntity.setFamilyEntity(familyEntity);
        }
       if (familyEntity != null){
            return true;
        }else{
           return false;
       }
    }

    @Override
    public Map<String,Object> getAllFamily() {
        ArrayList<Family> all = new ArrayList<>();
        familyRepository.findAll().forEach(entity-> all.add(objectMapper.convertValue(entity,Family.class)));

        Map<String, Object> responce = new HashMap<>();
        responce.put("family_count",all.size());
        responce.put("all_family",all);
        return responce;
    }

    @Override
    public Map<String,Object> getAllPerson() {
        ArrayList<Person> all = new ArrayList<>();
        personRepository.findAll().forEach(entity-> all.add(objectMapper.convertValue(entity,Person.class)));

        Map<String, Object> responce = new HashMap<>();
        responce.put("person_count",all.size());
        responce.put("all_person",all);
        return responce;
    }

    @Override
    public Family searchFamilyById(Long id) {
        try {
            Optional<FamilyEntity> optionalEntity =  familyRepository.findById(id);

            if (optionalEntity.isPresent()) {
                FamilyEntity entity = optionalEntity.get();
                return objectMapper.convertValue(entity, Family.class);
            } else {
                log.info("Family not found with id: " + id);
                return null;
            }
        } catch (Exception e) {
            log.error("Error occurred: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Person searchPersonById(String nic) {
        try {
            PersonEntity entity = personRepository.findByNicContainingIgnoreCase(nic);
            return objectMapper.convertValue(entity,Person.class);
        }catch (Exception e){
            log.info("search error Message :"+e.getMessage());
            return null;
        }
    }

    @Override
    public List<Person> searchPersonByName(String firstName) {
        ArrayList<Person> allName = new ArrayList<>();
        personRepository.findByFirstNameContainingIgnoreCase(firstName).forEach(entity-> allName.add(objectMapper.convertValue(entity,Person.class)));
        return allName;
    }

    @Override
    public Boolean updateFamily(Family family) {
        try {
            familyRepository.save(objectMapper.convertValue(family, FamilyEntity.class));
            return true;
        }catch (Exception e){
            log.info("update error massage : "+e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean updatePerson(Person person) {
        try {
            personRepository.save(objectMapper.convertValue(person, PersonEntity.class));
            return true;
        }catch (Exception e){
            log.info("update error massage : "+e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean deleteFamily(Long id) {
        try {
            familyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            log.info("delete error massage : "+e.getMessage());
            return false;
        }

    }

    @Override
    public Boolean deletePersonById(String id) {
        try {
            personRepository.deleteById(id);
            return true;
        }catch (Exception e){

            log.info("delete error massage : "+e.getMessage());
            return false;
        }
    }


}



