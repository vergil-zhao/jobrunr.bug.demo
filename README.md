# Jobrunr Problem Demo

This is a demo project to show a problem with Jobrunr.

## How to reproduce

1. Start the application
```shell
./gradlew bootRun
```

2. Call normal endpoint
```shell
curl http://localhost:8080/jobs/enqueue/normal
```

3. Call endpoint with problem
```shell
curl http://localhost:8080/jobs/enqueue/bug
```

4. Check the logs
```shell
# For normal endpoint should see
having fun with 1, 2

# For problem endpoint should see
java.lang.NullPointerException: You are passing null as a parameter to your background job for type long - JobRunr prevents this to fail fast.
```
