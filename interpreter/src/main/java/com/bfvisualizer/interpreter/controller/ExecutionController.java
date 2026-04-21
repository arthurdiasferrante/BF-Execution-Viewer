package com.bfvisualizer.interpreter.controller;

import com.bfvisualizer.interpreter.dto.execution.ExecutionRequestDTO;
import com.bfvisualizer.interpreter.dto.execution.ExecutionResponseDTO;
import com.bfvisualizer.interpreter.service.BrainfuckInterpreter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/execute")
public class ExecutionController {

    private final BrainfuckInterpreter interpreter;

    public ExecutionController(BrainfuckInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    @PostMapping
    public ResponseEntity<ExecutionResponseDTO> execute(@RequestBody ExecutionRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new IllegalArgumentException("Request body cannot be null");
        }

        String code = requestDTO.code() == null ? "" : requestDTO.code();
        String inputData = requestDTO.inputData() == null ? "" : requestDTO.inputData();

        ExecutionResponseDTO responseDTO = interpreter.interpret(code, inputData);
        return ResponseEntity.ok(responseDTO);
    }
}
