# 🧠 Brainfuck Visualizer & Execution Engine

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen?style=for-the-badge&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

A professional-grade **Spring Boot REST API** that transforms Brainfuck from a "black box" into a transparent, visual experience. This engine doesn't just execute code; it captures every state change—memory tape, data pointer, and output—returning a complete "execution replay" designed for modern front-end visualization.

---

## The Vision: Making the Abstract Tangible

Brainfuck is a minimalist esoteric language. While a basic interpreter is a common exercise, this project evolves it into a professional toolset.

By migrating from a monolithic CLI to a **Stateless REST Architecture**, the project now features:
* **Step-by-Step Snapshotting:** Capturing the memory state after every single instruction.
* **Algorithmic Transparency:** Visualizing how a BF-based calculator "thinks" through cells and pointers.
* **Modern Interoperability:** A decoupled back-end ready to serve high-performance React visualizers.

---

## Architecture & Clean Code

The project follows the **SOLID** principles and a layered **MVC (Model-View-Service)** pattern.

### Key Components:
* **REST Controllers:** Handles incoming requests for calculations and raw execution.
* **Orchestration Services:** Manages the lifecycle of BF code generation and execution flow.
* **Data Transfer Objects (DTOs):** Utilizing **Java 21 Records** for immutable, concise data transport.
* **Mappers:** Powered by **MapStruct** to seamlessly transform internal execution states into clean API responses.
* **Domain Model:** Optimized Frame snapshot system that records the state of the first 20 memory cells.

---

## Tech Stack

* **Java 21:** Using modern features like Records and optimized pattern matching.
* **Spring Boot 4.x:** Providing a robust web layer and Dependency Injection.
* **MapStruct:** Automating the mapping between execution results and Response DTOs.
* **Lombok:** Eliminating boilerplate code for better maintainability.
* **Jackson:** Efficient serialization of complex execution Frames into structured JSON.

---

## API Reference

### Execute Raw Brainfuck
POST /api/execute
Runs any BF code and returns a full list of memory snapshots.

### Calculator Logic
POST /calculator
Generates a BF script for math operations, executes it, and returns the result with the visual "replay."

---

## Portfolio Angle

* **State Machine Snapshotting:** Instead of just a final value, the engine "photographs" the tape at every step, creating a timeline of the execution.
* **Resource Management:** Dynamic loading of .bf scripts from the classpath using Spring's ResourceLoader.
* **Thread Safety:** Strictly stateless service design, preventing memory overlap between concurrent users.
* **Evolution:** A complete architectural migration from a "while-loop" CLI to a scalable, production-ready Web API.

---

## How to Run

1. Clone the repository:
   git clone https://github.com/arthurdiasferrante/BF-Execution-Viewer.git

2. Build the project:
   mvn clean install

3. Launch the application:
   mvn spring-boot:run

---

“Coding in Brainfuck is a headache. Visualizing it shouldn't be.” Developed by **Arthur Dias Ferrante** – Computer Science Student & Gastronomy Graduate.