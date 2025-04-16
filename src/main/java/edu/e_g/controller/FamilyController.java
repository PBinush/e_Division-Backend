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

}
