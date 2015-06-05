To run the project you have to follow next simple steps:

Check the requirements:
1. Web server: Tomcat 7 or 8
2. JVM Version: 1.8
3. Database: MySQL
4. Maven Version: 3.3

Steps to run the project:
1. Getting of the project.
1.1. Download the project and unzip it

2. Preparation of Tomcat for deploying the project
2.1. Go to the folder in which tomcat is installed and open the file /conf/tomcat-users.xml
2.2. Inside the tag <tomcat-users> put some next tags:
		<role rolename="manager-script" />
		<role rolename="manager-gui" />
		<user username="maven" password="maven" roles="manager-gui,manager-script" />
2.3. Save this file

3. Preparation of pom.xml
3.1. In pom.xml find the next properties and set the correct parameters depends of your web server and database:
		<properties>
			<db.name>transport</db.name>
			<db.driver>com.mysql.jdbc.Driver</db.driver>
			<db.url>jdbc:mysql://localhost:3306/</db.url>
			<db.url.name>${db.url}${db.name}</db.url.name> 
			<db.username>root</db.username>
			<db.password>root</db.password>
			<db.dialect>org.hibernate.dialect.MySQLDialect</db.dialect>
			<tomcat.url>http://localhost:8084</tomcat.url>
			<tomcat.deploy.url>${tomcat.url}/manager/text</tomcat.deploy.url>
			<tomcat.deploy.server>localhost-Tomcat7</tomcat.deploy.server>
		</properties>
3.2. Save this file

4. Run Tomcat

5. Go to the root folder of the project

6. Run maven by the command: 
mvn db:drop db:create db.schema clean tomcat7:deploy

7. If you need to redeploy the project, use next command:
mvn db:drop db:create db.schema clean tomcat7:redeploy

8. If you don't need to initialize DB, use next command:
mvn clean tomcat7:redeploy

In the test database presence of the following users:
root  with Administrator privileges,
dis1 and dis2 with Dispatcher privileges,
driver1, driver2, driver3, driver4, driver5 with Driver privileges.

For all users password is "root"
