#!/bin/bash

# create host
docker-machine create --driver virtualbox drjoy.rep

# verify
docker-machine ls

# create container
docker-compose build

# verify
docker ps -a
