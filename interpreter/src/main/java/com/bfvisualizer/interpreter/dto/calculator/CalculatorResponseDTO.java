package com.bfvisualizer.interpreter.dto.calculator;

import com.bfvisualizer.interpreter.dto.execution.ExecutionResponseDTO;

public record   CalculatorResponseDTO(int result, ExecutionResponseDTO executionDetails) {
}
