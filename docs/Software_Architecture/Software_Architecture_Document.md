Fact Racing
# Software Architecture Document

Version 1.0
 
### Revision History
|Date	|Version	|Description	|Author|
|----------|----------|----------|----------|
|24/11/2016|1.0| Initial draft| Janik Ritz|
|27/11/2016|1.1| First Content| Janik Ritz|
	
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
This Document describes the scope
[The introduction of the Software Architecture Document provides an overview of the entire Software Architecture Document. It includes the purpose, scope, definitions, acronyms, abbreviations, references, and overview of the Software Architecture Document.]

#### 1.1	Purpose
This document provides a comprehensive architectural overview of the system, using a number of different architectural views to depict different aspects of the system. It is intended to capture and convey the significant architectural decisions which have been made on the system.

[This section defines the role or purpose of the Software Architecture Document, in the overall project documentation, and briefly describes the structure of the document. The specific audiences for the document is identified, with an indication of how they are expected to use the document.]
#### 1.2	Scope
This projects Framework is Spring with MVC (and possibly other). This influences the relations between Model, View and Controller. This also affects the communication to any database.

#### 1.3	Definitions, Acronyms, and Abbreviations
[This subsection provides the definitions of all terms, acronyms, and abbreviations required to properly interpret the Software Architecture Document.  This information may be provided by reference to the project’s Glossary.]

#### 1.4	References
| Title | Version | Date | Organisation |
|-------|---------|------|--------------|
|[FactRacingClassDiagram](/docs/ClassDiagrams/FactRacingClassDiagram.png)| ? | 27/11/2016 | GamesCobold|
|[Use-Cases Overview](/docs/Use-Cases/Use-Case%20Overview%201.0.png)| 1.0 | 27/11/2016 | GamesCobold|
|[Use-Case Create Game Room](/docs/Use-Cases/Create%20Game%20Room/CreateGameRoomSpecifications.md)| 1.0 | 27/11/2016 | GamesCobold|
|[Use-Case Enter Game Room by Link](/docs/Use-Cases/Enter%20Game%20Room%20By%20Link/UseCase-EnterGameRoomByLink.md)| 1.0 | 27/11/2016 | GamesCobold|
[This subsection provides a complete list of all documents referenced elsewhere in the Software Architecture Document. Identify each document by title, report number (if applicable), date, and publishing organization. Specify the sources from which the references can be obtained. This information may be provided by reference to an appendix or to another document.]

#### 1.5	Overview
This document contains relevant information about the framework we used and the architectural goals that should be reached

### 2.	Architectural Representation 

### 3.	Architectural Goals and Constraints 
[This section describes the software requirements and objectives that have some significant impact on the architecture; for example, safety, security, privacy, use of an off-the-shelf product, portability, distribution, and reuse. It also captures the special constraints that may apply: design and implementation strategy, development tools, team structure, schedule, legacy code, and so on.]
### 4.	Use-Case View 
N/A
#### 4.1	Use-Case Realizations
N/A

### 5.	Logical View 
[This section describes the architecturally significant parts of the design model, such as its decomposition into subsystems and packages. And for each significant package, its decomposition into classes and class utilities. You should introduce architecturally significant classes and describe their responsibilities, as well as a few very important relationships, operations, and attributes.]
#### 5.1	Overview
[This subsection describes the overall decomposition of the design model in terms of its package hierarchy and layers.]
#### 5.2	Architecturally Significant Design Packages
[For each significant package, include a subsection with its name, its brief description, and a diagram with all significant classes and packages contained within the package. 
For each significant class in the package, include its name, brief description, and, optionally, a description of some of its major responsibilities, operations, and attributes.]
### 6.	Process View 
N/A
### 7.	Deployment View 
[This section describes one or more physical network (hardware) configurations on which the software is deployed and run. It is a view of the Deployment Model. At a minimum for each configuration it should indicate the physical nodes (computers, CPUs) that execute the software and their interconnections (bus, LAN, point-to-point, and so on.) Also include a mapping of the processes of the Process View onto the physical nodes.]
### 8.	Implementation View 
N/A
#### 8.1	Overview
N/A
#### 8.2	Layers
N/A
### 9.	Data View (optional)
[A description of the persistent data storage perspective of the system. This section is optional if there is little or no persistent data, or the translation between the Design Model and the Data Model is trivial.]
### 10.	Size and Performance
[A description of the major dimensioning characteristics of the software that impact the architecture, as well as the target performance constraints.]
### 11.	Quality 
[A description of how the software architecture contributes to all capabilities (other than functionality) of the system: extensibility, reliability, portability, and so on. If these characteristics have special significance, such as safety, security or privacy implications, they must be clearly delineated.]
