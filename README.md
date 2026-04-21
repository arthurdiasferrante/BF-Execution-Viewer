# Brainfuck Visualizer API

Backend em Java 21 + Spring Boot para executar Brainfuck e retornar frames de execucao para visualizacao no front-end.

## Stack

- Java 21
- Spring Boot 4.x
- Maven
- MapStruct

## Endpoints

- `POST /api/execute`
  - Executa codigo Brainfuck enviado no corpo da requisicao.
- `POST /calculator`
  - Monta e executa um script Brainfuck de operacao matematica.

## Exemplo de request

`POST /api/execute`

```json
{
  "code": "++++++++[>++++++++<-]>+.",
  "inputData": ""
}
```

## Rodando localmente

Windows (PowerShell):

```powershell
cd interpreter
.\mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
cd interpreter
./mvnw spring-boot:run
```

## Testes

Windows:

```powershell
cd interpreter
.\mvnw.cmd test
```

Linux/macOS:

```bash
cd interpreter
./mvnw test
```
