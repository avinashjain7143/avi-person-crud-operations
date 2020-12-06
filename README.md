# avi-person-crud-operations
Avi person crud operations is a spring boot rest api build for maintaining the contact repository,
 in which user can add, delete, edit, count, get the person.
 
These are few functionality of this API and their respective end points :
- Get Person by ID : <host>:<port>/person/<ID>
- Get Person count : <host>:<port>/person/count
- Get List of person : <host>:<port>/person
- Add a person : <host>:<port>/person/put/<ID> {Request contains a json of person object to be added}
- Edit existing person : <host>:<port>/person/put/<ID> {Request contains a json of person object to be edit}
- Delete a person : <host>:<port>/person/delete/<ID>

Sample JSON request : 

	{
        "id": 1,
        "fName": "Avinash",
        "lName": "Jain",
    }


Technology stack : Spring boot, Hibernate, JPA, JAVA 8, Maven, Postman (To run the API), Eclipse IDE, GIT, Mocking, jUnit

Folder structure : src/main/java
						com.avi
							controller -> front rest controller class
							model -> JPA entity pojo class
							repository -> Crud repository class
					src/main/resources
						Application.properties -> port no
					Pom.xml -> contains artifact id, dependencies and plugin
					src/test/java
						com.avi -> Test classes
					
Instructions to run the application :
			Git clone application
			Import in to Eclipse (or whatever you like)
			Convert to maven project
			Right click project -> Maven -> update project
			clean
			install
			build
			Go to AviApplication
			Right click on main method
			Run as JAVA application (or spring boot app)
			Use above instructed endpoints to access different services of the API
			Happy coding :)
			
			

