# Fact Racing Test Plan

## Revision History

| Date       | Version | Description           | Author           |
|:-----------|:--------|:----------------------|:-----------------|
| 03.05.2017 | 1.0     | Initial version       | Christian Vogel  |


## Table of Contents

1. Introduction
    1. Purpose
    2. Scope
    3. Intended Audience
    4. Document Terminology and Acronyms
    5. References
    6. Document Structure
2. Evaluation Mission and Test Motivation
    1. Background
    2. Evaluation Mission
    3. Test Motivators
3. Target Test Items
4. Outline of Planned Tests
   1. Outline of Test Inclusions
   2. Outline of other candidates for potential inclusion
   3. Outline of Test Exclusions
5. Test Approach
   1. Initial Test-Idea Catalogs and other reference sources
   2. Testing Techniques and Types
      1. Data and Database Integrity Testing
      2. Function Testing
      3. Business Cycle Testing
      4. Business Cycle Testing
      5. Performance Profiling
      6. Load Testing
      7. Stress Testing
      8. Volume Testing
      9. Security and Access Control Testing
      10. Failover and Recovery Testing
      11. Configuration Testing
      12. Installation Testing
6. Entry and Exit Criteria
   1. Test Plan
      1. Test Plan Entry Criteria
      2. Test Plan Exit Criteria
      3. Suspension and resumption criteria
   2. Test Cycles
      1. Test Cycle Entry Criteria
      2. Test Cycle Exit Criteria
      3. Test Cycle abnormal termination
7. Deliverables
   1. Test Evaluation Summaries
   2. Reporting on Test Coverage
   3. Perceived Quality Reports
   4. Incident Logs and Change Requests
   5. Smoke Test Suite and supporting Test Scripts
   6. Additional work products
      1. Detailed Test Results
      2. Additional automated functional Test Scripts
      3. Test Guidelines
      4. Traceability Matrices
8. Testing Workflow
9. Environmental Needs
   1. Base System Hardware
   2. Base Software Elements in the Test Environment
   3. Productivity and Support Tools
   4. Test Environment Configurations
10. Responsibilities, Staffing and Training Needs
   1. People and Roles
   2. Staffing and Training Needs
11. Iteration Milestones
12. Risks, Dependencies, Assumptions and Constraints
13. Management Process and Procedures
   1. Measuring and Assessing the Extent of Testing
   2. Assessing the deliverables of this Test Plan
   3. Problem Reporting, Escalation and Issue Resolution
   4. Managing Test Cycles
   5. Traceability Strategies
   6. Approval and Signoff

## 1. Introduction
### 1.1 Purpose
The purpose of the Iteration Test Plan is to gather all of the information necessary to plan and control the test effort for a given iteration. It describes the approach to testing the software, and is the top-level plan generated and used by managers to direct the test effort.
This Test Plan for Fact Racing supports the following objectives:
- Outlines the testing approach that will be used
- Identifies the required resources

### 1.2 Scope
This document addresses the following types and levels of testing:
- Java JUnit Tests
- Functional Tests

### 1.3 Intended Audience
The intended audience of the test plan are the project members and developers.

### 1.4 Document Terminology and Acronyms
n/a

### 1.5 References
n/a

### 1.6 Document Structure
n/a

## 2. Evaluation Mission and Test Motivation
### 2.1 Background
n/a

### 2.2 Evaluation Mission
n/a
### 2.3 Test Motivators
n/a

## 3. Target Test Items
n/a

## 4. Outline of Planned Tests
n/a

### 4.1 Outline of Test Inclusions
n/a

### 4.2 Outline of other candidates for potential inclusion
n/a

### 4.3 Outline of Test Exclusions
n/a

## 5. Test Approach
### 5.1 Initial Test-Idea Catalogs and other reference sources
n/a

### 5.2 Testing Techniques and Types
n/a

#### 5.2.1 Data and Database Integrity Testing
n/a

#### 5.2.2 Function Testing
|                         |                                                      |
|-------------------------|------------------------------------------------------|
| Technique Objective:    | Testing the functionality of the code                | 
| Technique:              | Testing the self-written code                        | 
| Oracles:                | Cucumber extension for Eclipse/IntelliJ + Java JUnit | 
| Success Criteria:       | All tests pass                                       | 
| Special Considerations: | n/a                                                  | 

#### 5.2.3 Business Cycle Testing
n/a

#### 5.2.4 Business Cycle Testing
|                         |                                                      |
|-------------------------|------------------------------------------------------|
| Technique Objective:    | Testing the webpages for correct behavior            | 
| Technique:              | Create or modify tests for each window to verify proper navigation and object states for each application window and object. | 
| Oracles:                | Tests are successful if every interaction with the GUI could be performed and produces an logical answer. | 
| Required Tools:         | Cucumber                                             |
| Success Criteria:       | All tests pass successfully                          | 
| Special Considerations: | n/a                                                  | 

#### 5.2.5 Performance Profiling
n/a

#### 5.2.6 Load Testing
n/a

#### 5.2.7 Stress Testing
n/a

#### 5.2.8 Volume Testing
n/a

#### 5.2.9 Security and Access Control Testing
n/a

#### 5.2.10 Failover and Recovery Testing
n/a

#### 5.2.11 Configuration Testing
n/a

#### 5.2.12 Installation Testing
n/a

## 6. Entry and Exit Criteria
### 6.1 Test Plan
#### 6.1.1 Test Plan Entry Criteria
n/a

#### 6.1.2 Test Plan Exit Criteria
n/a

#### 6.1.3 Suspension and resumption criteria
n/a

### 6.2 Test Cycles
#### 6.2.1 Test Cycle Entry Criteria
n/a

#### 6.2.2 Test Cycle Exit Criteria
n/a

#### 6.2.3 Test Cycle abnormal termination
n/a

## 7. Deliverables
### 7.1 Test Evaluation Summaries
n/a

### 7.2 Reporting on Test Coverage
Test Coverage is evaluated on every push to the repository.

### 7.3 Perceived Quality Reports
n/a

### 7.4 Incident Logs and Change Requests
Travis CI for automated building and continuous testing.

### 7.5 Smoke Test Suite and supporting Test Scripts
n/a

### 7.6 Additional work products
#### 7.6.1 Detailed Test Results
n/a

#### 7.6.2 Additional automated functional Test Scripts
tbd

#### 7.6.3 Test Guidelines
n/a

#### 7.6.4 Traceability Matrices
n/a

## 8. Testing Workflow
User interface tests and function tests are executed at every push to the repository.

We integrated Sonarqube into our testing workflow. Every push onto the master and develop-branch will trigger a Sonarqube update. On our [Sonarqube-Page](https://sonarqube.com/organizations/factracing/projects) are many information and metrics related to our code provided.

## 9. Environmental Needs
### 9.1 Base System Hardware
|Resource | Quantity | Name and Type |
|----------|---------|---------------|
|Webserver | 1       | tbd/Type      |
|- Server Name  |    | tbd/Name      |
|- Database |        | tbd/Name      |

### 9.2 Base Software Elements in the Test Environment
|Software Element Name | Version | Type and Other Notes |
|----------------------|---------|----------------------|
| Mozilla Firefox      | diffrent| Internet Browser     |
| MySql                |         | Database             |
| Travis               |         | Test-Framework       |

### 9.3 Productivity and Support Tools
| Tool Category or Type | Tool Brand Name | Vendor or In-house | Version |
|-----------------------|-----------------|--------------------|---------|
| Test Management	    | Travis CI	      |                    |         |
| Project Management	| Jira            | Atlassian          |         |
| DBMS tools            | MySQL           |                    |         |

### 9.4 Test Environment Configurations
n/a

## 10. Responsibilities, Staffing and Training Needs
### 10.1 People and Roles
Every member of Fact Racing is Implementer and Test Designer. We all code and write tests for it.

### 10.2 Staffing and Training Needs
n/a

## 11. Iteration Milestones
tbd

## 12. Risks, Dependencies, Assumptions and Constraints
| Risk                            | Mitigation Strategy | Contingency (Risk is realized) |
|---------------------------------|---------------------|--------------------------------|
| Travis CI goes down             | external provider –-> no chance | Searching for an alternative + Run Tests locally |


## 13. Management Process and Procedures
n/a

### 13.1 Measuring and Assessing the Extent of Testing
n/a

### 13.2 Assessing the deliverables of this Test Plan
n/a

### 13.3 Problem Reporting, Escalation and Issue Resolution
n/a

### 13.4 Managing Test Cycles
n/a

### 13.5 Traceability Strategies
n/a

### 13.6 Approval and Signoff
n/a
