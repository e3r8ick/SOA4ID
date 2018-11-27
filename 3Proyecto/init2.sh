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

  docker-machine env manager

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

  docker run -d -p 5005:3006 darkventus/face-service
}

function main {
  setup-swarm
}

main
