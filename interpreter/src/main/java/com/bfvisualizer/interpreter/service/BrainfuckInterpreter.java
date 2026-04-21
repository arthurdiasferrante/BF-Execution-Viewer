package com.bfvisualizer.interpreter.service;

import com.bfvisualizer.interpreter.dto.execution.ExecutionResponseDTO;
import org.springframework.stereotype.Service;

import com.bfvisualizer.interpreter.model.Frame;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrainfuckInterpreter {

    public ExecutionResponseDTO interpret(String code, String inputData) {
        int[] memory = new int[30000];
        int pointer = 0;
        int codePointer = 0;
        int inputPointer = 0;

        StringBuilder output = new StringBuilder();
        List<Frame> frames = new ArrayList<>();

        while (codePointer < code.length()) {
            char command = code.charAt(codePointer);

            switch (command) {
                case '>' -> pointer = (pointer + 1) % memory.length;
                case '<' -> pointer = (pointer - 1 < 0) ? memory.length - 1 : pointer - 1;
                case '+' -> memory[pointer] = (memory[pointer] + 1) % 256;
                case '-' -> memory[pointer] = (memory[pointer] == 0) ? 255 : memory[pointer] - 1;
                case '.' -> output.append((char) memory[pointer]);
                case ',' -> {
                    if (inputData != null && inputPointer < inputData.length()) {
                        memory[pointer] = inputData.charAt(inputPointer++);
                    } else {
                        memory[pointer] = 0;
                    }
                }
                case '[' -> {
                    if (memory[pointer] == 0) {
                        int loop = 1;
                        while (loop > 0) {
                            codePointer++;
                            if (codePointer >= code.length()) break;
                            if (code.charAt(codePointer) == '[') loop++;
                            else if (code.charAt(codePointer) == ']') loop--;
                        }
                    }
                }
                case ']' -> {
                    if (memory[pointer] != 0) {
                        int loop = 1;
                        while (loop > 0) {
                            codePointer--;
                            if (codePointer < 0) break;
                            if (code.charAt(codePointer) == '[') loop--;
                            else if (code.charAt(codePointer) == ']') loop++;
                        }
                    }
                }
            }
            frames.add(new Frame(memory, pointer));
            codePointer++;
        }
        return new ExecutionResponseDTO(output.toString(), frames, code);
    }
}