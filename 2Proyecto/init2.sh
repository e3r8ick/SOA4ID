#!/usr/bin/env bash

function setup-swarm {

  echo '···························'
  echo '·· setting up the swarm  >>>> ··'
  echo '···························'

  echo '···························'
  echo '·· CREANDO las VM  >>>> ··'
  echo '···························'

  VBoxManage startvm manager

  VBoxManage startvm worker 

  echo '···························'
  echo '·· iniciando el swarm  >>>> ··'
  echo '···························'

  eval $(docker-machine env manager)

  echo '···························'
  echo '·· preparando los servicios  >>>> ··'
  echo '···························'

  docker stack rm sportec

  docker stop $(docker ps -aq)
  docker rm $(docker ps -aq)

  echo '···························'
  echo '·· deploy de los servicios  >>>> ··'
  echo '···························'

  docker stack deploy -c docker-compose.yml sportec

  docker run -it -d -p 5000:8080 -v /var/run/docker.sock:/var/run/docker.sock dockersamples/visualizer

  docker run -d -p 5001:8080 jenkinsci/blueocean

  docker run -d -p 5002:3000 darkventus/news-service

  docker run -d -p 5003:3001 darkventus/users-service

  docker run -d -p 5004:3002 darkventus/sports-service
}

function setup-images {

    # go inside the docker folder again
    cd _docker_setup

    echo '···························'
    echo '·· creating microservices images >>>>  ··'
    echo '···························'

    # we start all our microservices
    (bash < create-images.sh)

   cd ..
}

function setup-services {

    # go inside the docker folder again
    cd _docker_setup

    echo '···························'
    echo '·· starting up the microservices >>>>  ··'
    echo '···························'

    # we start all our microservices
    (bash < start-services.sh)

   cd ..
}

function status {
  eval `docker-machine env manager1`
  # we verify the docker swarm
  docker node ls

  # we verify our docker services
  docker service ls
}

function main {
  setup-swarm
  #setup-mongo
  setup-images
  setup-services
  status
}

main
