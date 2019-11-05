# java-8-journey 
Project to play around with java 8, lambda expression

## Terminologies
Concept inside the java.util.stream.Collectors:
* GroupingBy collector is used for grouping objects by some property and storing results in a Map instance
* PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance and collects Stream elements into a Map instance that stores Boolean values as keys and collections as values. Under the “true” key, you can find a collection of elements matching the given Predicate and under the “false” key, you can find a collection of elements not matching the given Predicate.

Simplest Form of Lambda expression

```java
new SomeInterface() {  
 @Override  
     public SomeType someMethod(args) { body }  
 }
 To
 (args) -> { body }
```

Expression for Lambda body
* In Lambda we can use expression instead of block
* If method has a void return type, then automatically no value will be returned
* Previous version

```java
	return (s1.charAt(s1.length()-1) - s2.charAt(s2.length()-1) );
```

* Lambda with expression for body

```java
	s1.charAt(s1.length()-1) - s2.charAt(s2.length()-1) ;
```

## Java 8 inbuilt functional interface
* Function<T, R> - take a T as input, return an R as output
* Predicate<T> - take a T as input, return a boolean as output
* Consumer<T> - take a T as input, perform some action and don't return anything
* Supplier<T> - with nothing as input, return a T
* BinaryOperator<T> - take two T's as input, return one T as output, useful for "reduce" operations
* IntConsumer - take an int as input, perform some action and don't return anything
* IntUnaryOperator - an operation on a single int-valued operand that produces an int-valued result

## A Lambda Expression Is an Anonymous Method
* The lambda expression must return a result that is compatible with the result of the functional interface method
* If the result is void, the lambda body is void-compatible
* Signature must be the same as the functional interface method's signature
* The lambda expression can throw only those exceptions for which an exception type or an exception supertype is declared in the functional interface method's throws clause

## Local Variables in Lambda Expressions
* The lambda expression scope is the same as the enclosing scope
* Final and effectively final (http://stackoverflow.com/questions/20938095/difference-between-final-and-effectively-final)
* With explicit declaration 

```java
	final int size = somevalue;
	doSomething(someArg -> use(size));
```

* Effectively final:

```java
	int size = somevalue;
	doSomething(someArg -> use(size));
```

* Avoid NullPointerException

```java  
if (contract != null && contract.getEmployee() != null
   contract.getEmployee().getAddresses() != null
     contract.getEmployee().getAddresses().isEmpty() == false
        contract.getEmployee().getAddresses().get(0) != null
            contract.getEmployee().getAddresses().get(0).getZipcode() != null) {

    return contract.getEmployee().getAddresses().get(0).getZipcode();

} else {
    return getSomewhereElseTheZipCode();
}
```

equals

```java
return Optional.ofNullable(contract)
    .map(c -> c.getEmployee())
    .map(e -> e.getAddresses())
    .flatMap(e -> e.getAddresses().stream().findFirst())
    .map(a -> a.getZipcode())
    .orElseGet(getSomewhereElseTheZipCode());
```

## Reference 
- http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
