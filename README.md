Coverage: SonarQube- 39.4%, Junit- 52.9%
# Inventory Management System Project - QA Consulting 

For this project I used Google Cloud Platform (GCP), MySQL database, SonarQube, Nexus, Java, JUnit and Mockito to create an inventory management system. It was written in Java and packaed using the CI Server Jenkins.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

1. Fork and clone the repo.
2. Create a Maven project in Eclpise.
3. Change the MySQL links.

### Prerequisites

If not already in place:

1. Install Java, Maven and Git.
2. Set up a MySQL instance. This can be done locally by installing SQL, or on Google cloud Platform which is how I chose to do it. For a guide on how to set up an instance on GCP, please click on this [link](https://cloud.google.com/sql/docs/mysql/quickstart).




## Running the tests

The tests were written using Mockito and Junit and cover the customer, items and order classes for the controllers, domains and services.

## Deployment

After the project has been forked and opened in the IDE. Go to the project folder which the project is located and open the command window in the folder. You should then be pointing to the location where the project is in your command window. Preform the following command:

         mvn clean install

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Jenkins](https://www.jenkins.io/) - CI Pipeline Tool
* [Eclipse](https://www.eclipse.org/) - IDE
* [Java](https://www.java.com/en/download/) - Code Base
* [JUnit](https://junit.org/junit4/) - Testing Tool
* [Mockito](https://site.mockito.org/) - Testing Tool
* [Google Cloud Platform](https://cloud.google.com/) - Cloud Host
* [SonarQube](https://www.sonarqube.org/) - Static Analysis Tool
* [Nexus](https://repository.apache.org/) - Artefact Repository
* [GitHub](https://github.com/) - Version Control System

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Luke Smyth-Osbourne** - *Continued from the initial forking to add a functionality for items, orders and order lines* - [sosbourneQA](https://github.com/sosbourneQA)


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* **Chris Perrins**  - [christophperrins](https://github.com/christophperrins) made the initial code base.
* **Nicholas Johnson**  - [nicholasjohnson](https://github.com/nickrstewarttds) taught the skills used in this project.

