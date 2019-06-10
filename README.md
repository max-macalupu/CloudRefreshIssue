**Description:** This project allows to replicate the refresh endpoint issue that cause a datasource shutdown.

Run the project:
`mvn spring-boot:run`

In Order To Replicate The Datasource Shut Down, Do The Next Api Calls:
- `curl -X GET http://localhost:9000/greeting;`
- `curl -X POST http://localhost:9000/actuator/refresh;`
- `curl -X GET  http://localhost:9000/greeting;`
