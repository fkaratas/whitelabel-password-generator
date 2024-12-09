# Whitelabel Password Generator [![Build Status](https://github.com/fkaratas/whitelabel-password-generator/workflows/Build/badge.svg)](https://github.com/fkaratas/whitelabel-password-generator/actions/workflows/build.yml) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fkaratas_whitelabel-password-generator&metric=coverage)](https://sonarcloud.io/summary/overall?id=fkaratas_whitelabel-password-generator)

Whitelabel Password Generator (WPG) is a simple Spring Boot application to host your own Password Generator running in a browser. Extend or brand it according to your needs. A running example can be found [here](https://www.pwd-generator.com).

## Building

**WPG** requires at least **Java 17** to compile and has been tested with versions of up **Java 21**. In order to build **WPG** simply clone the repository or download the sources and build it via command line: 
```
./mvnw clean verify
```

## How to use it

Since WPG is a runnable Spring Boot application, the easiest way to get started is to build the application as a runnable jar
```
./mvnw clean package
```

and then simply running it

```
java -jar <folder and name of jar file>
```

Please refer to the official Spring Boot documentation for further information on how to [deploy Spring Boot applications](https://docs.spring.io/spring-boot/3.4/how-to/deployment/index.html)

## License

[MIT License](LICENSE)
