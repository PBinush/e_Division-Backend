package edu.e_g.controller;

import edu.e_g.dto.Person;
import edu.e_g.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class PersonController {
    private final PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<String> savePerson(@RequestBody Person person) {
        return personService.savePerson(person) ?
                 ResponseEntity.ok("Person saved successfully") :
                 ResponseEntity.badRequest().body("Failed to save person");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person) ?
                 ResponseEntity.ok("Person updated successfully") :
                 ResponseEntity.badRequest().body("Failed to update person");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/getById")
    public ResponseEntity<Person> getPersonById(@RequestParam Long personId) {
        try {
            Person person = personService.getPersonById(personId);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            log.error("Person not found");
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePerson(@RequestParam Long personId) {
        return personService.deletePersonById(personId) ?
                 ResponseEntity.ok("Person deleted successfully") :
                 ResponseEntity.badRequest().body("Failed to delete person");
    }
}
