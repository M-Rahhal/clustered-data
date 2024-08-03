
PROJECT_NAME = clustered-data
JAR_FILE = target/$(PROJECT_NAME)-0.0.1-SNAPSHOT.jar
DOCKER_IMAGE = $(PROJECT_NAME):latest
DOCKERFILE = Dockerfile
DOCKER_COMPOSE_FILE = docker-compose.yml
all: build
build:
	@echo "Building the project..."
	./mvnw clean package
run: build
	@echo "Running the project..."
	java -jar $(JAR_FILE)
docker-build: build
	@echo "Building Docker image..."
	docker build -t $(DOCKER_IMAGE) -f $(DOCKERFILE) .
docker-compose-up: docker-build
	@echo "Starting Docker containers..."
	docker-compose -f $(DOCKER_COMPOSE_FILE) up
docker-compose-down:
	@echo "Stopping Docker containers..."
	docker-compose -f $(DOCKER_COMPOSE_FILE) down
clean:
	@echo "Cleaning the project..."
	./mvnw clean
docker-rm:
	@echo "Removing Docker image..."
	docker rmi $(DOCKER_IMAGE)
test:
	@echo "Running tests..."
	./mvnw test
.PHONY: all build run docker-build docker-compose-up docker-compose-down clean docker-rm test
