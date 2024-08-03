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
