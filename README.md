🧪 **Selenium Automation Framework – OrangeHRM**

(Under Development 🚧)

📌 **Project Overview**

This repository contains a Selenium WebDriver-based automation framework developed for testing the OrangeHRM web application.
The framework is built using Java, Maven, and TestNG, following industry-standard design principles such as Page Object Model (POM) and reusable utilities.

⚠️ Note: This project is currently under active development. Features, test coverage, and structure may evolve over time.

🛠️ **Tech Stack**

**Language**: Java
**Automation Tool**: Selenium WebDriver
**Build Tool**: Maven
**Test Framework**: TestNG
**Design Pattern**: Page Object Model (POM)
**Logging**: Log4j2
**Reporting**: Spark Report
**Version Control**: Git & GitHub

## 📂 Project Structure
```text
SeleniumProject
├── src/main/java
│   ├── com.demoproject.actiondriver
│   │   └── ActionDriver.java
│   ├── com.demoproject.base
│   │   ├── BaseApiTest.java
│   │   └── BaseClass.java
│   ├── com.demoproject.listeners
│   │   └── TestListener.java
│   ├── com.demoproject.pages
│   │   ├── HomePage.java
│   │   └── LoginPage.java
│   └── com.demoproject.utilities
│       └── ConfigReader.java
│
├── src/main/resources
│   ├── config.properties
│   └── log4j2.xml
│
├── src/test/java
│   └── com.demoproject.tests
│       ├── DummyTest.java
│       ├── DummyTest2.java
│       ├── EmployeeDBVerificationTest.java
│       ├── HomePageTest.java
│       └── LoginPageTest.java
│
├── src/test/resources
│   ├── screenshots
│   ├── SparkReport
│   │   └── SparkReport.html
│   └── testdata
│
├── testng.xml
├── logs
├── target
└── README.md
```




🚧 **Current Status**

This project is under development.
Ongoing work includes:

Expanding test coverage
Improving API test integration
Enhancing reporting
Adding data-driven testing

🚀 **Planned Enhancements**

Parallel execution
CI/CD integration (GitHub Actions / Jenkins)
Allure / Extent report integration
Database-driven test validation
Improved exception handling

⭐**Why This Project**

Demonstrates real-world Selenium framework design
Shows strong understanding of automation architecture
Scalable and maintainable structure
Suitable for enterprise-level automation growth



