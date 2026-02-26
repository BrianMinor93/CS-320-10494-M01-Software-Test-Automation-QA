# CS-320-10494-M01-Software-Test-Automation-QA
Module 7 Requirement

Overview

This repository showcases my work from CS 320: Software Test Automation & Quality Assurance. The included artifacts demonstrate my ability to:
Create unit tests using code to uncover defects
Apply requirement-driven testing strategies
Validate input constraints and enforce object integrity
Use automated testing (JUnit) to ensure software reliability
Analyze and reflect on testing approaches

The portfolio artifacts included here represent my work from Project One and Project Two.

Portfolio Artifacts Included

Project One – Contact Service Implementation

Files included:
Contact.java
ContactService.java
ContactTest.java
ContactServiceTest.java

This project demonstrates:

Object validation through constructors and setters
Enforcement of requirement constraints (length limits, non-null fields)
Service-layer logic for add, update, and delete operations
JUnit-based automated unit testing
Negative testing and boundary value testing
High method and branch coverage across core functionality

Project Two – Summary & Reflection Report

This report documents:

Software testing strategies used (unit testing, boundary testing, negative testing)
Coverage analysis and validation techniques
Evaluation of test effectiveness
Reflection on software quality assurance practices

Reflection
How can I ensure that my code, program, or software is functional and secure?

I ensure functionality by writing requirement-driven unit tests that validate both expected behavior and failure cases. Each requirement is translated into one or more JUnit tests that verify correct outcomes and proper exception handling. I use boundary value testing and negative testing to confirm that invalid inputs are rejected and that objects cannot enter invalid states.
Security begins with strict input validation. Constructors and setters enforce constraints such as non-null values and maximum field lengths. Automated testing ensures these protections remain intact during future code changes. I also review coverage reports to confirm that both success and failure paths are exercised, reducing the likelihood of untested logic.

How do I interpret user needs and incorporate them into a program?

I interpret user needs by breaking requirements into specific, testable rules. Instead of assuming expected behavior, I align implementation directly with documented constraints. I then create unit tests that validate each rule individually. This requirement-driven approach ensures traceability between user expectations and program behavior. Every implemented feature corresponds to a defined requirement and is verified through automated testing.

How do I approach designing software?

I approach software design by separating responsibilities into clear layers:

Data Model Layer – Defines objects with strict validation rules.
Service Layer – Handles operations such as add, update, and delete.
Testing Layer – Verifies both correct functionality and defensive behavior.

I follow the Arrange–Act–Assert pattern in unit tests to maintain clarity and readability. I design tests to be small, focused, and independent, making debugging and maintenance more efficient. This layered approach results in software that is easier to maintain, safer to modify, and protected by automated regression testing.

Skills Demonstrated

Java Development
JUnit 5 Testing
Test-Driven / Requirement-Driven Development
Boundary Value Analysis
Negative Testing
Code Coverage Analysis
Object-Oriented Design
Software Quality Assurance

This repository reflects my ability to design, implement, and test software in a structured and professional manner consistent with industry quality assurance practices.
