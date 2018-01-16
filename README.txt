YOTI assignment - Roomba

One example change.

- I have developed the code in 
NetBeans 8.2
Java version 1.8.0_121
Mongodb version 3.4.7
Maven version 3.5.0

- Build and Run the web application 

In Netbeans open the project
"Clean and Build" the project
"Run" the project (Select RoombaApplication.java as Main class)
I deployed the Web service in Apache Tomcat (8.5.15)

- To test the application
The url to make a request to "http://localhost:8080/roomba"
I used Advanced Rest Client (Google chrome plugin) to post the requests
Content type should be "application/json"

I have included the exported request file from ARC herewith (arc-export-6-9-2017-Request)
You can use it to import in the ARC plugin and make your own request.

Alternatively Postman can also be used.

The request and responses are stored in the mongodb in database named "test"
and the collection name is "requestResponse"

Querry the database to view all reuests and responses.
In mongo shell run following commands
>use test
>db.test.requestResponse.find().pretty();
