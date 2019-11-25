# GraalVM Polyglot Fibonacci with Javascript

Demonstrate invoking a JavaScript function via the Polyglot API.
```
# sdk use java 19.3.0.r11-grl

# mvn clean package

# java -jar target/polyglot-fibonacci-1.0.0.jar 10
js.fibonacci(10)=55
python.fibonacci(10)=55
R.fibonacci(10)=55
``` 