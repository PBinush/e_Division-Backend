package edu.e_g.service.impl;

import edu.e_g.dto.Family;
import edu.e_g.entity.FamilyEntity;
import edu.e_g.repository.FamilyRepository;
import edu.e_g.service.FamilyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyServiceImpl implements FamilyService {
    final FamilyRepository familyRepository;
    final ModelMapper mapper;

    @Override
    public boolean saveFamily(Family family) {
        if (family == null || family.getNumberOfMembers() == 0 ){
            throw new IllegalArgumentException("Invalid Family");
        }
        return Optional.ofNullable(
                mapper.map(familyRepository.save(mapper.map(family,FamilyEntity.class)),Family.class)
        ).isPresent();
    }

    @Override
    public List<Family> getAllFamily() {
        return familyRepository.findAll()
                .stream()
                .map(familyEntity -> mapper.map(familyEntity,Family.class))
                .toList();
    }

    @Override
    public Family searchFamilyById(Long id) {
        if (id == null ){
            throw new IllegalArgumentException("Invalid id");
        }
        return familyRepository.findById(id)
                .map(familyEntity -> mapper.map(familyEntity,Family.class))
                .orElseThrow(() -> new RuntimeException("family Not Found"));
    }

    @Override
    public boolean updateFamily(Family family) {
        if (family == null || family.getNumberOfMembers() == 0 ) {
            throw new IllegalArgumentException("Invalid user");
        }
        return familyRepository.findById(family.getFamilyId())
                .map(existing -> familyRepository.save(mapper.map(family, FamilyEntity.class)))
                .map(saved -> mapper.map(saved, Family.class))
                .isPresent();
    }

    @Override
    public boolean deleteFamily(Long id) {
        if (id == null ){
            throw new IllegalArgumentException("Invalid id");
        }
        familyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user Not Found"));
        familyRepository.deleteById(id);
        return true;
    }
}



