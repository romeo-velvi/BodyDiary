
<H1 align="center">PROG3 PROJECT</H1>
<!--  README  -->

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/velvi-stud/Prog3">
    <img src="/src/icons/icon.png" alt="Logo" width="126" height="126">
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
BodyDiary allows you to keep track of all the most important body measurements (weight, waist, hips, thighs, biceps and so on) on your PC. 
What's more, you can immediately represent changes in your body stats over time, the data is automatically synchronized into DB and into graphs created.
Work diligently on your training, the key to success is carefully monitoring your progress.
BodyDiary is a body measure tracker, weight and body mass index tracker and much blackberries. This application allows you to keep track of all the body relevant measurements and store them all in a database.
BodyDiary have some automatic antropometric calculator of body fat mass and lean mass percentage also height-waistline and waistline-hips ratio
Using BodyDiary application you can graphically represent your progress immediately. What could be more motivating than seeing a graph of your waist shrinking week by week of intense waist training?
Moreover BodyDiary can allow you to import a file (pdf or doc) containing the recent value of you measurement to your pc whit a simple click.



### Built With
This project was built using Java with DerbyDB as database.
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
1. Clone the repo on a specific folder
  ```sh
  $ git clone https://github.com/velvi-stud/Prog3
  ```
2. Open the foalder in a project IDE and make sure to set in run configuration VM Arguments the line :
``` 
--module-path ".\lib\javafx-sdk-17.0.0.1\lib" --add-modules=javafx.controls,javafx.fxml
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

Project Link: [https://github.com/velvi-stud/Prog3](https://github.com/velvi-stud/LearnFlow-v2)



<!-- LICENSE -->
## License
_Apache license 2.0_