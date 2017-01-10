#Using The Reflection API To Measure Stability

Student Name: Sean McGrath  
Student ID: G00316649   
Module: Advanced Object Oriented Software Development  
Lecturer: Dr John Healy  
https://github.com/seaniemc/OOReflectionGUIProject   


##Introduction

This program utiles the Reflection API, to calculate the Positional Stability(1) of each class contained with in a Jar file. The stability metric is calculate by finding both the Efferent(ce) and Afferent(ca) couplings of each class and then performing the following calculation, 1 = ce/ce + ca. In order to find find the dependancies and different couplings of each class, we used the Reflection API. The application was built using the MVC design pattern. The application uses the Swing libaray to create GUI's, which the user interacts with.

##Deploying the Application

* To run this program you need Java 8 installed.  
* Open command prompt, navigate to OOReflectionGUIProject
* Example of how to run the program
```
java -cp ./bin:./lib/test-jar.jar ie.gmit.sw.GUIView.Runner ./lib/test-jar.jar

```

##Design Pattern and Features

The program follows the MVC patern. As we are using a GUI for the application the MVC pattern works quiet well. 
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
