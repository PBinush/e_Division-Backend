package edu.e_g.service;

import edu.e_g.dto.Family;

import java.util.List;

public interface FamilyService {
    boolean saveFamily(Family family);
    List<Family> getAllFamily();
    Family searchFamilyById(Long id);
    boolean updateFamily(Family family);
    boolean deleteFamily(Long id);
}