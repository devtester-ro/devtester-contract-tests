# devtester-contract-tests

###  Basic example of Consumer driven contract testing using Pact JVM

Provider Side:
- App that returns a `bus-stop` json `response`
- Can be altered in order for the `contract to break`
- Note that in order for the contract tests to work `bs-app` - needs to be started.

Client Side:
- Integration with `bs-app` that consumes the respons
- Has `1 test` that generates - `BusServiceClient-BusService.json`
- Provides a state -> "There is a bus with number 613 arriving to Hammersmith bus station"
- Once generated you can use `mvn pact:publish` and `mvn pact:verify`

Verifier:
- Nice demonstration how to use the `State` where it was defined within the `client` e.g. -> `There is a bus with number 613 arriving to Hammersmith bus station`
- How to use the `pact folder` within the project or docker `pact-broker`
```java
//@PactFolder("../pacts") // Point where to find pacts (See also section Pacts source in documentation)
@PactBroker(host = "localhost", port = "8113") // Point where to find pacts (in this case the broker)
```

How to Install:

- Run `docker-compose up`
- Open `http://localhost:8113/` (broker website)
- Once `pact:publish` is executed - it will automatically upload to the broker
- Once `pact:verify` is executed - it will update the state of the contract against the 2 microservices

Materials:

- Kafka - https://docs.pact.io/recipes/kafka
- Pact to Jenkins - https://kreuzwerker.de/en/post/integrating-contract-tests-into-build-pipelines-with-pact-broker-and
- Showcase of Contract testing - https://youtu.be/-6x6XBDf9sQ