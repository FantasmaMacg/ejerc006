# Proyecto Ejerc006

Este proyecto es una aplicación de gestión de aulas, edificios, mesas y sillas utilizando Spring Boot y JPA.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- `controller`: Contiene los controladores REST para manejar las solicitudes HTTP.
- `model`: Contiene las clases de modelo que representan las entidades de la base de datos.
- `repository`: Contiene las interfaces de repositorio que extienden.
- `service`: Contiene las clases de servicio que implementan la lógica de negocio.

## Códigos de Pruebas (Ejemplos con `curl`)

.

**1. Añadir (Crear)**

*   **Añadir un Edificio:**

    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"nombre": "Edificio A", "direccion": "Calle Principal, 123"}' http://localhost:8080/edificios
    ```

*   **Añadir un Aula:**

    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"nombre": "Aula 101", "capacidad": 30}' http://localhost:8080/aulas
    ```

*   **Añadir una Mesa:**

    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"numero": 1, "tipo": "escritorio"}' http://localhost:8080/mesas
    ```

*   **Añadir una Silla:**

    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"numero": 1, "tipo": "plastico"}' http://localhost:8080/sillas
    ```

**2. Ver (Leer)**

*   **Ver todos los Edificios:**

    ```bash
    curl http://localhost:8080/edificios
    ```

*   **Ver un Edificio específico (por ID):**

    ```bash
    curl http://localhost:8080/edificios/1
    ```

*   **Ver todas las Aulas:**

    ```bash
    curl http://localhost:8080/aulas
    ```

*   **Ver todas las Mesas:**

    ```bash
    curl http://localhost:8080/mesas
    ```

*   **Ver todas las Sillas:**

    ```bash
    curl http://localhost:8080/sillas
    ```

**3. Actualizar (Modificar)**

*   **Actualizar un Edificio (por ID):**

    ```bash
    curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "nombre": "Edificio Central", "direccion": "Avenida Principal, 45"}' http://localhost:8080/edificios/1
    ```

*   **Actualizar un Aula (por ID):**

    ```bash
    curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "nombre": "Aula Central", "capacidad": 50}' http://localhost:8080/aulas/1
    ```

*   **Actualizar una Mesa (por ID):**

    ```bash
    curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "numero": 2, "tipo": "escritorio"}' http://localhost:8080/mesas/1
    ```

*   **Actualizar una Silla (por ID):**

    ```bash
    curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "numero": 2, "tipo": "plastico"}' http://localhost:8080/sillas/1
    ```

**4. Eliminar (Borrar)**

*   **Eliminar un Edificio (por ID):**

    ```bash
    curl -X DELETE http://localhost:8080/edificios/1
    ```

*   **Eliminar un Aula (por ID):**

    ```bash
    curl -X DELETE http://localhost:8080/aulas/1
    ```

*   **Eliminar una Mesa (por ID):**

    ```bash
    curl -X DELETE http://localhost:8080/mesas/1
    ```

*   **Eliminar una Silla (por ID):**

    ```bash
    curl -X DELETE http://localhost:8080/sillas/1
    ```
