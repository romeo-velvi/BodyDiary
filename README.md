

<H1 align="center">PROG3 PROJECT</H1>
<!--  README  -->

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/velvi-stud/Prog3">
    <img src="/src/icons/routine.png" alt="Logo" width="126" height="126">
  </a>
</p>
  <h3 align="center">BodyDiary</h3>

  <p align="center">
    <br />
    <a href="https://github.com/velvi-stud/Prog3">
    <strong>Explore the docs »</strong></a>
    <br />
    <a href="https://github.com/velvi-stud/Prog3/issues">Report Bug</a>
    <br />
    <a href="https://github.com/velvi-stud/Prog3/issues">Request Feature</a>
  </p>




<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#element-explanation">Element expenation</a></li>
    <ul>
        <li><a href="#derbydb-schema"> DerbyDB schema</a></li>
      </ul>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
BodyDiary is a management software application that allows you to keep track of all the most important body measurements such as weight, waist, hips, thighs, biceps and to calculate some anthropometric measures such as percentage of fat mass, percentage of lean mass, height-waist ratio and waist-hips. Giving the possibility to immediately visualize the changes of your body statistics over time, since the data is automatically synchronized in the DB and represented in the graphs created. It is also possible to download your information on files in pdf or docx format.



### Built With
This project was built using:
* Eclipse as IDE for java
* SceneBuilder as FXML constructor
* Drow_io to drow diagrams
* DerbyDb to storage data

User librery:
- <b>JavaFX</b>: is an open source, next generation client application platform for desktop, mobile and embedded systems built on Java.  It is a collaborative effort by many individuals and companies with the goal of producing a modern, efficient, and fully featured toolkit for developing rich client applications. JavaFX also is used with <b>SceneBuilder</b> that is an open source tool that allows for drag and drop design of JavaFX user interfaces.platform for desktop, mobile and embedded systems built on Java.  It is a collaborative effort by many individuals and companies with the goal of producing a modern, efficient, and fully featured toolkit for developing rich client applications.
- <b>DerbyDB</b>: is, an  [Apache DB subproject](http://db.apache.org/), is an open source relational database implemented entirely in Java and available under the  [Apache License, Version 2.0](http://db.apache.org/derby/license.html). Some key advantages include:
	- Derby has a small footprint -- about 3.5 megabytes for the base engine and embedded JDBC driver.
	-  Derby is based on the Java, JDBC, and  [SQL](https://cwiki.apache.org/confluence/display/DERBY/SQLvsDerbyFeatures)  standards.
	-  Derby provides an embedded JDBC driver that lets you  [embed](http://db.apache.org/derby/papers/DerbyTut/embedded_intro.html)  Derby in any Java-based solution.	
	-  Derby also supports the more familiar client/server mode with the  [Derby Network Client JDBC driver and Derby Network Server](http://db.apache.org/derby/papers/DerbyTut/ns_intro.html).
	-  Derby is easy to install, deploy, and use.
- <b>iText</b>: is a [library](https://en.wikipedia.org/wiki/Library_(computer_science) "Library (computer science)") for creating and manipulating [PDF](https://en.wikipedia.org/wiki/Portable_Document_Format "Portable Document Format") files in [Java](https://en.wikipedia.org/wiki/Java_(programming_language) "Java (programming language)").
-  <b> Apache poi </b>: is a Library for creation and manipulation of doc file.


<!-- GETTING STARTED -->
## Getting Started


### Prerequisites
You need to have java installed on your system. You can get the java from [here](http://www.oracle.com/technetwork/java/javase/downloads/index.html).


### Installation
1. Clone the repo on a specific folder (or open directly using Eclipse in File --> Import -> Git -> Projects from git -> Clone URI) using following link
  ```sh
  $ https://github.com/velvi-stud/BodyDiary-Project.git
  ```
2. Open the foalder in a project IDE and make sure to set in run configuration VM Arguments the line :
``` 
--module-path ".\lib\javaFX-17.0.0.1\lib" --add-modules=javafx.controls,javafx.fxml
``` 
3. And launch the program using that configuration. 


<!-- USAGE EXAMPLES -->
## Usage
When BodyDiary app is open you can see the start page that can allow you to start login or sing up.
When you are logged, you will see directly the home of the app,
otherwise you have to sing up to be identified.
When you are in the home, you can see, on the left of a page:
- Button to insert data.
- Button to watch the antropometric measurment.
- Button to set and watch goals.
- Button to download the measurement in a specific format.

On the right, you can see a list of graphs that represent a line chart of the measurament (such as biceps, weight, waistline and so on) and its progress.
On the vertcal axis there are the values of the measure,  on the horizontal axis there are the date of the single measure.


## Element explanation

### DerbyDB schema
The Database used ```LearnFlow_mongoDB``` is composed by three tables
* ```UserData``` is the first table that store the user data such as:
    * Email
    * Name
    * Surname
    * Password
    * Gender
    * Birth date
* ```UserMeasure``` is the table and it's used to store user's measurments data:
    * Email
	* Date
	* weight
	* thighs	
	* chest 	
	* height 	
	* forearms 
	* biceps	
	* hips
	* waistline
	* calfs
 * ```UserGoals``` is the third table and it's used to store user's body goals:
    * Email
	* Date	
	* Type
	* Goal 



<!-- CONTACT -->
## Contact

Romeo Velvi - romeo.velvi001@studenti.uniparthenope.it <br>
Pasquale Casoria - pasquale.casoria001@studenti.uniparthenope.it <br>

Project Link: [https://github.com/velvi-stud/BodyDiary-Project](https://github.com/velvi-stud/BodyDiary-Projec)



<!-- LICENSE -->
## License
_Apache license 2.0_
