#!/usr/bin/env bash
curl -X GET \
  http://localhost:9000/greeting \
  -H 'Postman-Token: 53bf9f76-fe0c-4579-af07-c77eee6f8c03' \
  -H 'cache-control: no-cache';

curl -X POST \
  http://localhost:9000/actuator/refresh \
  -H 'Postman-Token: 470c0767-1a31-4f08-89b0-383f9f6bf48b' \
  -H 'cache-control: no-cache';

curl -X GET \
  http://localhost:9000/greeting \
  -H 'Postman-Token: 53bf9f76-fe0c-4579-af07-c77eee6f8c03' \
  -H 'cache-control: no-cache';
