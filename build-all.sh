#!/bin/bash

function progress() {
    local GREEN CLEAN
    GREEN='\033[0;32m'
    CLEAN='\033[0m'
    printf "\n${GREEN}$@  ${CLEAN}\n" >&2
}

set -e

# Docker image prefix
REGPREFIX=binblee

cd eureka
./gradlew build
progress "Building eureka image ..."
docker tag $(docker build -t ${REGPREFIX}/demo-eurekaserver -q .) ${REGPREFIX}/demo-eurekaserver:$(date -ju "+%Y%m%d-%H%M%S")
cd -

cd bookservice
./gradlew build
progress "Building booservice image ..."
docker tag $(docker build -t ${REGPREFIX}/demo-bookservice -q .) ${REGPREFIX}/demo-bookservice:$(date -ju "+%Y%m%d-%H%M%S")
cd -

cd web
./gradlew build
progress "Building web image ..."
docker tag $(docker build -t ${REGPREFIX}/demo-web -q .) ${REGPREFIX}/demo-web:$(date -ju "+%Y%m%d-%H%M%S")
cd -
