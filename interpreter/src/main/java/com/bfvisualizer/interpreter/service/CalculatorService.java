package com.bfvisualizer.interpreter.service;

import com.bfvisualizer.interpreter.dto.calculator.CalculatorResponseDTO;
import com.bfvisualizer.interpreter.dto.execution.ExecutionResponseDTO;
import com.bfvisualizer.interpreter.mapper.CalculatorMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class CalculatorService {

    private final ResourceLoader resourceLoader;
    private final BrainfuckInterpreter interpreter;
    private final CalculatorMapper mapper;

    public CalculatorService(BrainfuckInterpreter interpreter, ResourceLoader resourceLoader, CalculatorMapper mapper) {
        this.interpreter = interpreter;
        this.resourceLoader = resourceLoader;
        this.mapper = mapper;
    }

    public CalculatorResponseDTO calculate(int n1, int n2, String operation) throws IOException {
        String bfCode = "";

        bfCode = injectNumber(bfCode, n1);
        bfCode = injectNumber(bfCode, n2);
        bfCode = appendOperation(bfCode, operation);

        ExecutionResponseDTO execution = interpreter.interpret(bfCode, "");

        return mapper.toCalculatorResponse(execution);
    }

    private String injectNumber(String currentBfCode, int number) {
        StringBuilder sb = new StringBuilder(currentBfCode);
        String paddedNumber = String.format("%08d", number);

        for (char digitChar : paddedNumber.toCharArray()) {
            int digit = digitChar - '0';
            sb.append("+".repeat(digit)).append(">");
        }
        return sb.toString();
    }

    public String appendOperation(String currentBfCode, String operation) throws IOException {
        String path = "classpath:scripts/" + operation + ".bf";
        Resource resource = resourceLoader.getResource(path);

        if (!resource.exists()) {
            throw new IllegalStateException("Script não encontrado: " + operation);
        }

        String opCode = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        return currentBfCode + "<" + opCode;
    }
}
