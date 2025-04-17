package edu.e_g.controller;

import edu.e_g.dto.Family;
import edu.e_g.service.FamilyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class FamilyController {
    private final FamilyService familyService;

    @PostMapping("/save")
    public ResponseEntity<String> saveFamily(@RequestBody @Valid Family family) {
        return Boolean.TRUE.equals(familyService.saveFamily(family)) ?
                ResponseEntity.ok("Family saved successfully") :
                ResponseEntity.badRequest().body("Failed to save family");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFamily(@RequestBody @Valid Family family) {
        return Boolean.TRUE.equals(familyService.updateFamily(family)) ?
                ResponseEntity.ok("Family updated successfully") :
                ResponseEntity.badRequest().body("Failed to update family");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Family>> getAllFamily() {
        return ResponseEntity.ok(familyService.getAllFamily());
    }

    @GetMapping("/getById")
    public ResponseEntity<Family> searchFamilyById(@RequestParam Long id) {
        try {
            Family family = familyService.searchFamilyById(id);
            return ResponseEntity.ok(family);
        } catch (Exception e) {
            log.error("Family not found");
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFamily(@RequestParam Long id) {
        return Boolean.TRUE.equals(familyService.deleteFamily(id)) ?
                ResponseEntity.ok("Family deleted successfully") :
                ResponseEntity.badRequest().body("Failed to delete family");
    }
}
