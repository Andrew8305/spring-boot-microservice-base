#!/bin/bash

test -f /etc/bootstrapped && exit

# Install needed packages
sudo apt-get update
sudo apt-get install -y apt-transport-https ca-certificates

# GPG
sudo apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D

# Update source list
echo "deb https://apt.dockerproject.org/repo ubuntu-trusty main" | sudo tee /etc/apt/sources.list.d/docker.list

# Dependency packages
sudo apt-get update
sudo apt-get install linux-image-extra-$(uname -r) linux-image-extra-virtual

# Docker engine
sudo apt-get install -y docker-engine

# Docker compose
sudo sh -c "curl -L https://github.com/docker/compose/releases/download/1.8.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose"
sudo chmod +x /usr/local/bin/docker-compose

# Create docker containers
cd /home/vagrant/docker
sudo docker-compose build

# Mark file
date | sudo tee /etc/bootstrapped
