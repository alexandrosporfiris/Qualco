# Qualco

Installation instructions:
1. Go to "application.properties" and make the necessary changes
2. Run mvn clean install at parent folder
3. Extract the preconfigured Apache Tomcat server 
4. Copy "ROOT.war" from backend/target folder to server's "webapps" folder
5. Run "startup.bat" (Windows) or "startup.sv" (Linux)
6. The application should run at localhost:8080


# Warning: On application startup a migration script will run to create the given database and add 2 new Table Views needed for the implementation.
