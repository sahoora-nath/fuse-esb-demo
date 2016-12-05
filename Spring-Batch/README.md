# Spring-Batch on Jboss Fuse

## Overview
This example will show you how to leverage the spring-batch with Jboss Fuse ESB. We will setup a derby/mysql DB and configure datasource, then Import data sources as OSGi services. Configure a batch item reader which reads messages from XML file and writes its content into a database and deploy that onto JBoss Fuse 6.3.0. 

## What You Will Learn

* how to set up derby/mysql datasource on osgi blueprint.
* how to configure a Spring JDBC template.
* how to configure a camel route and start batch from route.
* how to configure spring batch item reader/writer.
		 
### Prerequisites

Before building and running this example you need:

* Maven 3.3.9 or higher
* JDK 1.8
* JBoss Fuse 6.3.0
* mysql

### Files in the Example

* pom.xml - the Maven POM file for building the example.
* datasource.xml - contains the JDBC data source definition.
* beans.xml - import datasources as osgi service.
* features - contains the Apache Karaf features definition that allows for easy installation of this example.
* camel-context.xml - contains the transactional Camel routes.


## Setting up the database server

For this example, we will be using mysql community edition server or embedded derby server. Before installing the demo, we need to setup the server and create the database tables.

### Create the database tables.
In the db shell, run these following commands:
```
	CREATE TABLE STUDENTS_RESULT (
      id INT(12) NOT NULL auto_increment primary key,
      last_updated_date datetime,      
      student_name VARCHAR(30) NOT NULL,
      dob DATE NOT NULL,
      percentage  double NOT NULL
    );
```
To be sure the tables got created successfully, run one more command:
```
select *  from STUDENTS_RESULT;
```


## Deployment

Most of features bundles are available in fuse. You need to install the following bundle manually before deploying the JAR bundle in fuse.
```
features:install camel-spring-batch-core
features:install camel-bam
features:install camel-quartz2
install -s wrap:mvn:org.apache.derby/derby/10.13.1.1
install -s wrap:mvn:org.springframework.retry/spring-retry/1.1.0.RELEASE
install -s wrap:mvn:javax.batch/javax.batch-api/1.0 

```
## Authors

*  * * Rabindra Sahoo* *  - * Initial work*  - [sahoora-nath](https://github.com/sahoora-nath)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this demo project.
