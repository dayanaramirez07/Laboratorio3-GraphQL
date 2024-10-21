# Sistema de Gestión de Vuelos

## Descripción
Este proyecto es una aplicación de gestión de vuelos desarrollada en **Spring Boot**, con una **API GraphQL** que permite realizar consultas y mutaciones sobre los vuelos. La aplicación utiliza **MySQL** para la persistencia de datos, y está contenedorizada mediante **Docker**. Para el monitoreo y visualización de métricas, se integran **Prometheus** y **Grafana**.

## Características
- Crear vuelos, Consultar por ID, Consultar todos los vuelos.
- Búsqueda de vuelos por origen y destino.
- Integración con GraphQL para consultas flexibles.
- Persistencia de datos en MySQL.
- Monitoreo de métricas con Prometheus y visualización con Grafana.
- Despliegue de la aplicación usando Docker y Docker Compose.

## Tecnologías Utilizadas
- **Spring Boot**: Framework principal para la lógica del backend.
- **GraphQL**: Sistema de consultas y mutaciones.
- **MySQL**: Base de datos relacional para la persistencia de datos.
- **Docker**: Para contenedorización de la aplicación.
- **Prometheus**: Herramienta de monitoreo para la recolección de métricas.
- **Grafana**: Plataforma de visualización de métricas.

## Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes requisitos:
- **Java 17**
- **Docker**
- **Maven**

## Instalación y Ejecución
Sigue los siguientes pasos para clonar y ejecutar el proyecto:

1. Clona el repositorio:
   ```bash
   git clone https://github.com/dayanaramirez07/Laboratorio3-GraphQL.git
2. Ve al directorio del proyecto.
3. Construye la imagen de Docker:
   ```bash
   docker-compose build
4. Ejecuta los contenedores con Docker Compose:
   ```bash
   docker-compose up
5. La aplicación estará disponible en `http://localhost:8080`.

## Endpoints Principales
### Mutaciones (Mutations)
- **addFlight**: Permite agregar un nuevo vuelo al sistema.
  ```graphql
  mutation {
    addFlight(
      flightNumber: "AB123",
      origin: "NYC",
      destination: "LAX",
      departureTime: "2024-12-01T10:00:00",
      arrivalTime: "2024-12-01T14:00:00",
      price: 299.99,
      passengers: 150
    ) {
      id
      flightNumber
      origin
      destination
      departureTime
      arrivalTime
      price
      passengers
    }
  }

### Consultas (Queries)
- **allFlights**: Devuelve una lista de todos los vuelos.
  ```graphql
  query {
    allFlights {
      id
      flightNumber
      origin
      destination
      departureTime
      arrivalTime
      price
      passengers
    }
  }

- **flightById**: Devuelve un vuelo específico por su ID.
  ```graphql
  query {
    flightById(id: "1") {
      id
      flightNumber
      origin
      destination
      departureTime
      arrivalTime
      price
      passengers
    }
  }

- **searchFlights**: Devuelve una lista de vuelos que coinciden con los criterios de origen y destino.
  ```graphql
  query {
    searchFlights(origin: "NYC", destination: "LAX") {
      id
      flightNumber
      origin
      destination
      departureTime
      arrivalTime
      price
      passengers
    }
  }

## Monitoreo
- Prometheus estará disponible en `http://localhost:9090`.
- Grafana estará disponible en `http://localhost:3000` con las métricas expuestas para visualización.
