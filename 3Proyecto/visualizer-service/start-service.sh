#!/usr/bin/env bash

#docker service create --replicas 1 --name visualizer-service -l=apiRoute='/visualizer' -p 8080:8080 dockersamples/visualizer
docker service create --replicas 1 -p 8080:8080 --name visualizer-service dockersamples/visualizer
