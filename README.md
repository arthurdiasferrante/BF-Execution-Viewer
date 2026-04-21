# Brainf*ck Visualizer API

Java 21 + Spring Boot backend for Brainf*ck execution with step-by-step state snapshots.

This project exposes HTTP endpoints that run Brainf*ck code and return execution data designed for front-end visualization (memory snapshots, pointer position, output, and generated BF code).

## Tech Stack

- Java 21
- Spring Boot 4.x
- Maven Wrapper
- MapStruct
- Lombok

## What It Provides

- Raw Brainf*ck execution through REST
- Calculator operations implemented through Brainf*ck scripts
- Frame-by-frame memory snapshots for replay/visualization
- Stateless service behavior suitable for concurrent requests

## API Endpoints

### `POST /api/execute`

Executes raw Brainf*ck code.

**Request body**

```json
{
  "code": "++++++++[>++++++++<-]>+.",
  "inputData": ""
}
```

**Response shape**

```json
{
  "finalOutput": "A",
  "frames": [
    {
      "memorySnapshot": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      "dataPointer": 0
    }
  ],
  "generatedBfCode": "++++++++[>++++++++<-]>+."
}
```

### `POST /calculator`

Builds and executes a Brainf*ck program for a selected operation.

**Request body**

```json
{
  "num1": 12,
  "num2": 7,
  "operation": "soma"
}
```

## Project Structure

- `controller/` HTTP API layer
- `service/` execution and orchestration logic
- `mapper/` DTO mapping (`MapStruct`)
- `model/` execution frame model
- `resources/scripts/` Brainf*ck operation scripts

## Run Locally

### Windows (PowerShell)

```powershell
cd interpreter
.\mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
cd interpreter
./mvnw spring-boot:run
```

Default URL: `http://localhost:8080`

## Run Tests

### Windows

```powershell
cd interpreter
.\mvnw.cmd test
```

### Linux/macOS

```bash
cd interpreter
./mvnw test
```
