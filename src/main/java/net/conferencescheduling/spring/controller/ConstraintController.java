package net.conferencescheduling.spring.controller;

import net.conferencescheduling.spring.model.entity.ConstraintDto;
import net.conferencescheduling.spring.service.ConstraintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/constraint")
public class ConstraintController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ConstraintService constraintService;

    @PostMapping("/create")
    public ResponseEntity<net.conferencescheduling.spring.model.dto.ConstraintDto> createConstraint(@RequestBody net.conferencescheduling.spring.model.dto.ConstraintDto constraintDto) {

        ConstraintDto constraintRequest = modelMapper.map(constraintDto, ConstraintDto.class);

        ConstraintDto constraint = constraintService.createConstraint(constraintRequest);

        // convert entity to DTO
        net.conferencescheduling.spring.model.dto.ConstraintDto constraintResponse = modelMapper.map(constraint, net.conferencescheduling.spring.model.dto.ConstraintDto.class);

        return new ResponseEntity<>(constraintResponse, HttpStatus.CREATED);
    }

}
