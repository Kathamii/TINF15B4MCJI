Fact Racing

# Software Architecture Document

Version 1.2

### Revision History

| Date       | Version | Description           | Author     |
|:-----------|:--------|:----------------------|:-----------|
| 24/11/2016 | 1.0     | Initial draft         | Janik Ritz |
| 27/11/2016 | 1.1     | First Content         | Janik Ritz |
| 29/11/2016 | 1.2     | Most Content Finished | Janik Ritz |

## Table of Contents

1. Introduction  
    1.1 Purpose  
    1.2 Scope  
    1.3 Definitions, Acronyms, and Abbreviations  
    1.4 References  
    1.5 Overview  
2. Architectural Representation  
3. Architectural Goals and Constraints  
4. Use-Case View  
    4.1 Use-Case Realizations  
5. Logical View  
    5.1 Overview
    5.2 Architecturally Significant Design Packages
6. Process View   
7. Deployment View    
8. Implementation View    
    8.1 Overview  
    8.2 Layers  
9. Data View (optional)  
10. Size and Performance  
11. Quality  

# Software Architecture Document 

### 1. Introduction

This document provides information about how the architecture of FactRacing is build. FactRacing is therefore influenced by the provided information.

#### 1.1	Purpose

This document provides a comprehensive architectural overview of the system, using a number of different architectural views to depict different aspects of the system. It is intended to capture and convey the significant architectural decisions which have been made on the system.

#### 1.2	Scope

This projects Framework is Spring with MVC (and possibly other). This influences the relations between Model, View and Controller. This also affects the communication to any database.

#### 1.3	Definitions, Acronyms, and Abbreviations

| Acronym/Abbreviation | Description/Definition  |
|:---------------------|:------------------------|
| MVC                  | Model, View, Controller |

#### 1.4	References

| Title                                                                                                              | Version | Date       | Organisation |
|:-------------------------------------------------------------------------------------------------------------------|:--------|:-----------|:-------------|
| [FactRacingClassDiagram](/docs/ClassDiagrams/FactRacingClassDiagram.png)                                           | ?       | 27/11/2016 | GamesCobold  |
| [Use-Cases Overview](/docs/Use-Cases/Use-Case%20Overview%201.0.png)                                                | 1.0     | 27/11/2016 | GamesCobold  |
| [Use-Case Create Game Room](/docs/Use-Cases/Create%20Game%20Room/CreateGameRoomSpecification.md)                   | 1.0     | 27/11/2016 | GamesCobold  |
| [Use-Case Enter Game Room by Link](/docs/Use-Cases/Enter%20Game%20Room%20By%20Link/UseCase-EnterGameRoomByLink.md) | 1.0     | 27/11/2016 | GamesCobold  |

#### 1.5	Overview

This document contains relevant information about the framework we used and the architectural goals that should be reached

### 2.	Architectural Representation

Our Application is web-based and consist of Spring with MVC and Hibernate.  
The Architecture of Spring with MVC can be portrayed with the following image:  
![MVC Spring Archtitecture](/docs/Software_Architecture/MVC-Architecture.png)

### 3.	Architectural Goals and Constraints 

We used the Spring Framework, which was developed by Pivotal Software.
> The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform. Although the framework does not impose any specific programming model, it has become popular in the Java community as an alternative to, replacement for, or even addition to the Enterprise JavaBeans (EJB) model. The Spring Framework is open source.
> > Wikipedia, 29/11/2016  

### 4.	Use-Case View 

N/A

#### 4.1	Use-Case Realizations

N/A

### 5.	Logical View

Our Project is parted into Model (+ Database), View and Controller. Here You can see the different parts.  

##### Model

#### 5.1	Overview

![Model - Class Diagram](/docs/ClassDiagrams/FactRacingClassDiagram.png)

##### View

![View - Class Diagram](//TODO)

##### Controller

![Controller - Class Diagram](/docs/ClassDiagrams/ControllerDiagram.png)  

#### 5.2	Architecturally Significant Design Packages

N/A

### 6.	Process View 

N/A

### 7.	Deployment View 

![Deployment Simple](/docs/Software_Architecture/Deployment.png)

### 8.	Implementation View 

N/A

#### 8.1	Overview

N/A

#### 8.2	Layers

N/A

### 9.	Data View (optional)

N/A yet

### 10.	Size and Performance

N/A

### 11.	Quality 

N/A
