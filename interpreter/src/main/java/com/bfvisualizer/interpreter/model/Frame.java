package com.bfvisualizer.interpreter.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
public class Frame {
    private final int[] memorySnapshot;
    private final int dataPointer;

    // esse ai vai devolver um JSON pro react
    // mais facil pra tu resolver
    public Frame(int[] fullMemory, int currentDataPointer) {
        this.dataPointer = currentDataPointer;
        this.memorySnapshot = Arrays.copyOf(fullMemory, 20);
    }
}
