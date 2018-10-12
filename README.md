[![codecov.io](https://github.com/mail2aashi/RetailDiscountCalculator/blob/master/src/test/resources/codecovarage/index.html).

[![UML class Diagrams](https://github.com/mail2aashi/RetailDiscountCalculator/tree/master/src/main/resources/uml).
# RetailDiscountCalculator

This is a Java Maven Applcation for Calculating PayinAmount Based on specifics Creteria provided below.

1. User is Store employee 30% on Bill Amount 

2. User is Affiliate  30% Discount on Bill Amount 
3. If User is a Customer for 2 Years 5% Discount on Bill Amount .
4. If Bill Amount is more than 100 each 100 will get 5% Discount.
5. No Discount  for Grocery. 
6. At a time user will get 1 type of Discount. 

# System Requirements 

JDK 1.8

Maven

IDE Eclipse(Optional)


# Application Tools

Java 1.8

Eclipse Oxygen

Maven 3

Jacoco plugin for code Coverage

Junit


# Running  Application locally

1. Install Java and Maven and set the Envirornment variables.
2. clone the project Source code RetailDiscountCalculator from github to specific workspace.
3. take the controll to pom.xml file project and compile the project
	
command:	mvn compile
	
4. Run the test cases and generate the code code coverage

command:	mvn test
Code coverage location : C:\FinalAssignement\RetailDiscountCalculator\target\jacoco-ut\
Test Classes: com.assignment.domain.DomainObjectTest.java
			  com.assignment.service.RetailDiscountCalculatorTest.java

# Running  Application in IDE

Import the cloned project to eclipse as maven project
 
Right click  -> run As -> maven test

# Generating   Code coverage from Command Prompt

Run the test cases and generate the code code coverage

command:	mvn test

# Generating  Code coverage in  Eclipse IDE


Right click  -> run As -> maven test   
