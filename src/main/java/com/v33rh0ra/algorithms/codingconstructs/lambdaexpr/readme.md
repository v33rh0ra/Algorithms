### Lambda Expressions
Support for Lambda expressions was introduced in Java 8.
A `lambda expression` is syntactic sugar for an anonymous class with single method whose type is inferred.

##### Syntax
`parameters -> body`: The compiler can use the context of the lambda expression to determine the functional interface being used and the type of the parameters.

#### rules

- Declaring type of parameters is optional.
- Using parentheses around the parameter is option in case of a single parameter.
- Using curly braces is optional, unless multiple statements are present.
- return keyword is optional in cases of a single expression that returns a value.

```java
() -> System.out.println(this);

(String str) -> System.out.println(str);

str -> System.out.println(str);

(str1, str2) -> s2.length() - s1.length();

(String str1, String str2) -> {
    return str2.length() - str1.length();
    };
// Expression to sort an array. 
// Here the lambda expression implements the
// Comparator interface to sort strings by length.            
Arrays.sort(strArray, (s1, s2)-> s2.length() - s1.length());

```
