# XA Datasource for Jboss Fuse

## Overview

This datasource.xml defines the JDBC DataSources that will be used for accessing the relational database. We are using OSGI blueprint to define the data source bean and publish it into the OSGi Service Registry by putting datasource.xml file into jboss_fuse_6.3.0/deploy/ directory.

### OSGI Service Registry

After datasource bundle is started, we can see the osgi registry object by the use of Fuse console.

First, find the bundle id for the bundle datasource.xml. You may use grep command to search for datasource as follows and then use ls bundle_id for the details of bunlde.
```
JBossFuse:karaf@root> list | grep datasource
[ 444] [Active     ] [Created     ] [       ] [   80] datasource.xml (0.0.0)
JBossFuse:karaf@root> ls 444

Bundle 444 provides:
--------------------
aries.xa.exceptionSorter = known
aries.xa.name = mysqlDS
aries.xa.pooling = true
aries.xa.poolMaxSize = 5
aries.xa.poolMinSize = 0
datasource.name = MySQL
objectClass = [javax.sql.XADataSource]
osgi.jndi.service.name = jdbc/mysqldb
osgi.service.blueprint.compname = mysql-ds
service.id = 674
----
aries.managed = true
aries.xa.aware = true
aries.xa.exceptionSorter = known
aries.xa.name = mysqlDS
aries.xa.pooling = true
aries.xa.poolMaxSize = 5
aries.xa.poolMinSize = 0
datasource.name = MySQL
objectClass = [javax.sql.DataSource]
osgi.jndi.service.name = jdbc/mysqldb
osgi.service.blueprint.compname = mysql-ds
service.id = 675
service.ranking = 1000
----
objectClass = [org.osgi.service.blueprint.container.BlueprintContainer]
osgi.blueprint.container.symbolicname = datasource.xml
osgi.blueprint.container.version = 0.0.0
service.id = 676
```

## Authors

*  * * Rabindra Sahoo* *  - * Initial work*  - [sahoora-nath](https://github.com/sahoora-nath)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this demo project.
