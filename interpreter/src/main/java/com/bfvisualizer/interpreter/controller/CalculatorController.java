package com.bfvisualizer.interpreter.controller;

import com.bfvisualizer.interpreter.dto.calculator.CalculatorRequestDTO;
import com.bfvisualizer.interpreter.dto.calculator.CalculatorResponseDTO;
import com.bfvisualizer.interpreter.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<CalculatorResponseDTO> createOperation(@RequestBody CalculatorRequestDTO requestDTO) throws IOException {
        CalculatorResponseDTO responseDTO = service.calculate(requestDTO.num1(), requestDTO.num2(), requestDTO.operation());

        return ResponseEntity.ok(responseDTO);
    }
}
