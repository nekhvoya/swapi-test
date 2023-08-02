# The Star Wars API tests

Tests for SWAPI are implemented in Java using the following libraries:
* Rest Assured (to implement of the calls to the API endpoints)
* JUnit5 (as a test runner)
* AssertJ (to implement assertions)

## Prerequisites

* JDK 17 (Zulu distribution was used for this project)
* Maven
* Java IDE (e.g., IntelliJ IDEA)

### How to run tests

Tests can be run using a JUnit runner from your IDE. In order to run the tests you need to right-click the test you'd like to run
(or the tests parent directory if you'd like to run all the tests in the directory) and select `Run 'Tests in dev.swapi.tests''`.