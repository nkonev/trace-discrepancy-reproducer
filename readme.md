```bash
./mvnw spring-boot:run # or launch AaaApplication.main via IDE

# case 1
curl -i 'http://localhost:8060/api/aaa/login' -X POST -H 'Accept: application/json, text/plain, */*' -H 'Content-Type: application/x-www-form-urlencoded;charset=utf-8' -H 'X-XSRF-TOKEN: 724f5acd-3d1e-421b-a386-eb17dcacece8' -H 'Cookie: VIDEOCHAT_XSRF_TOKEN=724f5acd-3d1e-421b-a386-eb17dcacece8' --data-raw 'login=admin&password=admin'

# case 2
curl -i 'http://localhost:8060/internal/profile/auth' -X GET -H 'Accept: text/plain, */*'
```
