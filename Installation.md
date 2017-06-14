# Installation

We are using Spring Boot with Maven and use Travis-CI for automatic Tests and Deployment.  
Addidionally we use Heroku for our Server, because you can get one for free.

## Local Installation
Just use some modern IDE and pull our Git.
Run mvn clean install and run the Spring Boot Application (FactRacingApplication.java).

## Deploy to Heroku Server
You can use Travis-CI with a Fork of this Git and the only thing you have to change is the Key-Value-Pairs in Travis-CI for the .travis.yml to push the application to the correct Heroku site.  
Mentioned Keys:
- $heroku_key
- $heroku_app

For automatic Sonar:
- $sonar_org
- $sonar_key
