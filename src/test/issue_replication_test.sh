#!/usr/bin/env bash

curl -X GET http://localhost:9000/greeting;

curl -X POST http://localhost:9000/actuator/refresh;

curl -X GET  http://localhost:9000/greeting;
