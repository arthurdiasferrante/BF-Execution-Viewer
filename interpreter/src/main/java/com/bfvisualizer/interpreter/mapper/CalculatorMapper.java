package com.bfvisualizer.interpreter.mapper;

import com.bfvisualizer.interpreter.dto.calculator.CalculatorResponseDTO;
import com.bfvisualizer.interpreter.dto.execution.ExecutionResponseDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CalculatorMapper {

    @Mapping(target = "executionDetails", source = "execution")
    @Mapping(target = "result", source = "execution", qualifiedByName = "memoryToResult")
    CalculatorResponseDTO toCalculatorResponse(ExecutionResponseDTO execution);

    @Named("memoryToResult")
    default int memoryToResult(ExecutionResponseDTO execution) {
        if (execution == null || execution.frames() == null || execution.frames().isEmpty()) {
            throw new IllegalStateException("Execution without frames to extract result");
        }

        var lastFrame = execution.frames().get(execution.frames().size() - 1);
        int[] memory = lastFrame.getMemorySnapshot();
        if (memory == null || memory.length < 24) {
            throw new IllegalStateException("Invalid memory snapshot to extract result");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 16; i <= 23; i++) {
            sb.append(memory[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
                                      