#Using The Reflection API To Measure Stability

Student Name: Sean McGrath  
Student ID: G00316649   
Module: Advanced Object Oriented Software Development  
Lecturer: Dr John Healy  
https://github.com/seaniemc/OOReflectionGUIProject   


##Introduction

This program utilises the Reflection API, to calculate the Positional Stability(1) of each class contained with in a Jar file. The stability metric is calculated by finding both the Efferent(ce) and Afferent(ca) couplings of each class and then performing the following calculation, 1 = ce/ce + ca. To find the dependencies and different couplings of each class, we used the Reflection API. The application was built using the MVC design pattern. The application uses the Swing library to create GUI's, which the user interacts with.

##Deploying the Application

* To run this program, you need Java 8 installed.  
* Open command prompt, navigate to OOReflectionGUIProject
* Example of how to run the program
```
java -cp ./bin:./lib/test-jar.jar ie.gmit.sw.GUIView.Runner ./lib/test-jar.jar

```

##Design Pattern and Features

####MVC
The program follows the MVC pattern. As we are using a GUI for the application, the MVC pattern works quiet well. 
The project structure is as follows

```
OOProjectGui
│       
│
└───Controller
    |--CalculateCouplings
    |--ClassList
    |--ClassMap
    |--Data
    |--DatabaseConnector
    |--PopulateAdjacency
    |--Readable
    |--ReadinJarFile
└───GUIView
    │--AdjacencySummary
    │--AdjacencySummaryTable
    |--AppSummary
    |--AppWindow
    |--CustomControl
    |--Runner
    |--TypeSummaryTableModel
└───Model
    |--AdjacencyList
    |--Measurement
      
```

####Strategy
In Strategy pattern, a class behaviour or its algorithm can be changed at run time. By using this pattern, we could easily 
create classes which would implement the Readable interface and could import different file types e.g. zip.

```
public interface Readable {
    ClassList init(String var1) throws IOException, NoSuchMethodException;
}

```

####Adjacency List 
The program creates an Adjacency List for each class and is represented in the GUI. The list is stored in the AdjacencyList class which has a HashMap as a parameter

####Custom GUI 
I created my own table to represent the returning Adjacency list. 

####Database 
I partially implemented a DB40 database but the functionality is not quite finished :) 

##Reflection 

The reflection API is used to gather data about the classes. It analysis the classes taken from the Jar file. 
* Check Data about fields
* Check parameters of constructors
* Check is class an interface or does it implement one
* Checks the method parameter’s with in each class
* Method return types


#References
http://tutorials.jenkov.com/java-reflection/index.html  
https://www.youtube.com/watch?v=agnblS47F18  
http://www.newthinktank.com/2012/09/java-reflection-video-tutorial/  

http://www.headfirstlabs.com/books/hfdp/  
https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm  
http://www.tutorialspoint.com/swing/  

http://www.odbms.org/wp-content/uploads/2013/11/db4o-7.10-tutorial-java.pdf  





