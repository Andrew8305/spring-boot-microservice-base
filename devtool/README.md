## Overview

#### postgres

* host: drjoy.rep
* port: 5432

#### mongodb

* host: drjoy.rep
* port: 27017


## Setup on Windows

#### Install application

 * `windows/apps/vagrant_1.9.5.msi`
 * `windows/apps/VirtualBox-5.1.22-115126-Win.exe`


#### Verification

Run command prompt as administrator

```
C:\ vagrant --version
Vagrant 1.9.5
```

#### Install vagrant plugin

```
C:\ vagrant plugin install vagrant-hostsupdater
```

#### Create vagrant box

```
C:\ cd devtool/windows
C:\ vagrant up
Bringing machine 'default' up with 'virtualbox' provider...
...
==> default: creating postgres
==> default: Creating mongo
```

#### Install ssh client

Cygwin, MinGW, Git or Tera Term etc...

#### Login to vagrant

* id: vagrant
* password: vagrant

Installed Cygwin, MinGW or Git

```
C:\ vagrant ssh
```

Verification whether the container is started

```
$ sudo docker ps
CONTAINER ID        IMAGE             ...
xxxxx               drjoy/mongo       ...
xxxxx               drjoy/postgres    ...
```

## Setup on macOS Sierra

#### Install docker

  * [Download docker](https://download.docker.com/mac/stable/Docker.dmg)
  * [Official install document](https://docs.docker.com/docker-for-mac/install/)

#### Verification

Run terminal application

docker

```
$ docker version
Client:
  Version: 17.xx...
  ...
Server:
  Version: 17.xx...  
```

docker-compose

```
$ docker-compose version
docker-compose version 1.xx
...
OpenSSL version: ...
```

#### Create docker host machine

Change directory

```
$ cd ./mac
```

Run once

```
$ ./setup.sh
```

#### Run docker container

```
$ docker-compose up -d
Starting postgres
Starting mongo
```

Verification whether the container is started

```
$ docker ps
CONTAINER ID        IMAGE             ...
xxxxx               drjoy/mongo       ...
xxxxx               drjoy/postgres    ...
```
