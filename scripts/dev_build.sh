#!/bin/bash

DOCKER_IMAGE="cogboard/cogboard-app"

# login to docker hub
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin

# push recently builded image
docker push ${DOCKER_IMAGE}:${VERSION}-SNAPSHOT