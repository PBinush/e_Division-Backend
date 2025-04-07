package edu.e_g.controller;

import edu.e_g.dto.Family;
import edu.e_g.dto.Person;
import edu.e_g.service.FamilyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class FamilyController {

    final FamilyService familyService;

    @PostMapping("/save-family")
    public ResponseEntity<String> saveFamily(@Valid @RequestBody Family family, HttpServletRequest request) {
        if(Boolean.TRUE.equals(familyService.saveFamily(family))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add Family detail: {}", os,family);
            return ResponseEntity.ok("family added successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added family");
        }
    }

    @PostMapping("/save-person")
    public ResponseEntity<String> savePerson( @RequestBody Person person,HttpServletRequest request) {
        if(Boolean.TRUE.equals(familyService.savePerson(person))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add Person detail: {}", os, person);
            return ResponseEntity.ok("person added successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added person");
        }
    }

    @GetMapping("/get-all-family")
    public ResponseEntity<Map<String,Object>> getAllFamily(){
        Map<String, Object> response = familyService.getAllFamily();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all-person")
    public ResponseEntity<Map<String,Object>> getAllPerson(){
        Map<String, Object> response = familyService.getAllPerson();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/family-search-by-id/{id}")
    public ResponseEntity<Family> searchFamilyById(@PathVariable Long id){
        Family searchById = familyService.searchFamilyById(id);
        if(searchById != null){
            return new ResponseEntity<>(searchById,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person-search-by-id/{nic}")
    public ResponseEntity<Person> searchPersonById(@Valid @PathVariable("nic") String nic){
        Person searchById = familyService.searchPersonById(nic);
        if(searchById != null){
            return new ResponseEntity<>(searchById,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person-search-by-name/{firstName}")
    public ResponseEntity<List<Person>> searchPersonByName(@PathVariable("firstName") String firstName) {
        List<Person> searchByName = familyService.searchPersonByName(firstName);
        if (searchByName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchByName, HttpStatus.OK);
    }

    @PutMapping("/update-family")
    public ResponseEntity<String> updateFamily(@Valid @RequestBody Family family,
                                               HttpServletRequest request){
        if(Boolean.TRUE.equals(familyService.updateFamily(family))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | update family detail: {}", os, family);
            return ResponseEntity.ok("family update successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't family person");
        }
    }

    @PutMapping("/update-person")
    public ResponseEntity<String> updatePerson(@Valid @RequestBody Person person,
                                               HttpServletRequest request){
        if(Boolean.TRUE.equals(familyService.updatePerson(person))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | update Person detail: {}", os, person);
            return ResponseEntity.ok("person update successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't update person");
        }
    }


    @DeleteMapping("/family-delete-by-id/{id}")
    public ResponseEntity<String> deleteFamilyById(@Valid @PathVariable("id") Long id,
                                                   HttpServletRequest request){
        if(Boolean.TRUE.equals(familyService.deleteFamily(id))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} || delete family id: {}", os,id);
            return ResponseEntity.ok("family delete successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't delete family");
        }
    }

    @DeleteMapping("/person-delete-by-id/{nic}")
    public ResponseEntity<String> deletePersonById(@Valid @PathVariable("nic") String id,
                                                   HttpServletRequest request){
        if(Boolean.TRUE.equals(familyService.deletePersonById(id))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} || delete Person id: {}", os,id);
            return ResponseEntity.ok("person delete successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't delete person");
        }
    }




}
