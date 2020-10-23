# Remote Method Invocation - Simple Chat

### In this project I've developed a simple chatting application using the Java RMI. 

##### Java Remote Method Invocation (Java RMI) 
is a Java API that performs remote method invocation, the object-oriented equivalent of remote procedure calls (RPC), with support for direct transfer of serialized Java classes and distributed garbage-collection.

The original implementation depends on Java Virtual Machine (JVM) class-representation mechanisms and it thus only supports making calls from one JVM to another. The protocol underlying this Java-only implementation is known as Java Remote Method Protocol (JRMP). 

Usage of the term RMI may denote solely the programming interface or may signify both the API and JRMP, IIOP, or another implementation, whereas the term RMI-IIOP (read: RMI over IIOP) specifically denotes the RMI interface delegating most of the functionality to the supporting CORBA implementation.

The basic idea of Java RMI, the distributed garbage-collection (DGC) protocol, and much of the architecture underlying the original Sun implementation, come from the "network objects" feature of Modula-3.

### The Concept
1) The server creates an, as it's called, __**registry**__ on the default port __**1099**__ and binds its implementation methods under a directory name.
```
Registry registry = LocateRegistry.createRegistry(1099);
registry.bind("server", server);
```
2) The client will try to locate that registry provoding the server's IP and the port (1099)
```
Registry registry = LocateRegistry.getRegistry("localhost", 1099);
ServerInterface server = (ServerInterface) registry.lookup("server");
```
3) In case that the connection is successful, clients and the server can start exchanging data.

In this example, I have developed a simple chat application.
A connected client will send a message to the server, and upon receiving, the server will broadcast it to all of its connected clients.

### Release
- You can find the exported .jar files under \Release together with the .bat files to run them via Command Prompt.
```
start cmd.exe /k "java -jar **(filename)**.jar"
```
- You can find the pre-compiled binaries under \Release\executables to try it out yourself!
```
RunServer.exe password is 'server'
RunClient.exe password is 'client'
```

![PoC](release/video.gif)

##### Happy Coding!