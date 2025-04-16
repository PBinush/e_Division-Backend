package edu.e_g.service;

import edu.e_g.dto.Family;

import java.util.List;

public interface FamilyService {
    Boolean saveFamily(Family family);
    List<Family> getAllFamily();
    Family searchFamilyById(Long id);
    Boolean updateFamily(Family family);
    Boolean deleteFamily(Long id);
}
