# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.245.2/containers/java/.devcontainer/base.Dockerfile

# [Choice] Java version (use -bullseye variants on local arm64/Apple Silicon): 11, 17, 11-bullseye, 17-bullseye, 11-buster, 17-buster
ARG VARIANT="21"
FROM mcr.microsoft.com/vscode/devcontainers/java:1-${VARIANT}

WORKDIR /source

COPY models models
COPY trade-service trade-service
COPY settings.gradle .

WORKDIR trade-service

EXPOSE 18092

RUN ./gradlew build
ENTRYPOINT ./gradlew bootRun
