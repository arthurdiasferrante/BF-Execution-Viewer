package com.bfvisualizer.interpreter.dto.execution;

import java.util.List;
import com.bfvisualizer.interpreter.model.Frame;

public record ExecutionResponseDTO(String finalOutput, List<Frame> frames, String generatedBfCode) {
}
