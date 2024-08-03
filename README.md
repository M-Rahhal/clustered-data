## Overview

The Deals Application is a Spring Boot application designed to manage financial deals. It allows you to save deal information to a MySQL database, handles exceptions, and logs information using interceptors and aspects.

## Features

- **Deal Management**: Save financial deals with details including unique deal ID, currencies, timestamp, and amount.
- **Custom Validations**: Implementations for unique deal IDs, valid currency codes, and timestamp formats.
- **Exception Handling**: Global exception handler to provide meaningful error responses.
- **Logging**: Utilizes HTTP interceptors and aspect-oriented programming (AOP) for comprehensive method-level logging.
- **Database Integration**: Uses MySQL for persistent storage, configured via Docker.

## Prerequisites

- **Java JDK 21**
- **Maven**
- **Docker** (for running the application and MySQL in containers)
- **MySQL** (configured through Docker)

## Running the application
## Build the Application
  **./mvnw clean package**

## Run the Application with Docker
  **docker-compose up --build**

## Usage
## API Endpoints:
    **Endpoint: POST /api/deals** 
    **Request body** 
    {
        "deal-id": 1,
        "from-currency": "USD",
        "to-currency": "EUR",
        "deal-time-stamp": "2024-08-01T12:00:00",
        "deal-amount": 1000.00
    }

## Custom Validations
  **Unique Deal ID:** Ensures the deal ID is unique in the database.
  **Currency Code:** Validates that the currency code is one of the predefined codes.
  **Timestamp:** Validates that the timestamp adheres to acceptable formats.

## Exception Handling
  The application features a global exception handler that catches and returns appropriate HTTP   error responses for different types of exceptions.

## Logging
  **HTTP Interceptors:** Log incoming requests and responses.
  **Aspects:** Log method execution details and arguments.

## Testing
  Unit tests are provided for:
    **Custom validators**
    **Service layer**
    **Controller layer**

    

  
