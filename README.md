## Spring MVC Film C.R.U.D. Project

### Skill Distillery Group Project
##### Andrew Dufresne and Mark Coleman

Create a Film C.R.U.D. application that acts as a full stack web application. 


#### Project Description

The web app must be able to:
* Add a film to the database
* Update the information for a film in the database 
* Search for a film or list of films through keyword or ID search. 

The results are displayed using JSP pages given data through our controller. 
The web application and its associated database have been attached and uploaded to an amazon EC2 instance using Tomcat and MySQL.
All pages have been written in JSP with EL used for data retrieval.

This program displays a webpage with three sections. 
The first allows a user to input the required information to add a film to the database. Upon entering the information the film is entered into the database and automatically given a corresponding ID number from which the film can be easily retrieved with.
This form uses text input as well as drop down menus to choose predefined options.
At the bottom of the result page is an option to delete the film you have just created.

In the second section, the user may choose to search for a film by ID number or search for all films that match a specific keyword within its title or description.

The final section allows for the user to update the information of a film currently in the database. 

When any of these forms are submitted they are sent through the controller and a different result page is displayed. 

When any film is found all of its relevant information is displayed. 

It uses: 
* OOP design
	* Film/Actor/Category classes
	* DAO interface and DAOImpl for database query
	* Controller to act as the middleman
	* JSP pages to display the data to the user
* Takes input from a user through the use of JSP forms and GET and POST methods
* Gradle project using the STS tool suite 

##### Logic of calculations
The only logic needed to figure out this program were how to properly query from a mySQL database. I wouldn't consider it logic necessarily but it took some deliberate thought to get everything mapped correctly and talking nicely.


#### How To Run This Project
Run this through any browser by travelling to the following url. 

http://andrewddufresne.com:8080/MVCFilmSite/

The site loads directly to the webapp.
It is also linked to from both of our respective personal sites.


#### Lessons Learned and Struggles Encountered

There were struggles encountered and lessons learned throughout this project. As this was our first group project using multiple people on one repository there were some merge conflicts but nothing that didn't get handled quickly. More so, I struggled with delegation and really processing goals and steps to help split up the work and keep us both moving forward.
I became a lot more frustrated as this is the first project in which I truly stumbled and crept through it. I felt as though what I had originally thought I was grasping was still very far from being so. After completing it I feel a little more comfortable but I know there are a lot of questions I have still to answer.
As a group we ran into several issues with getting everything configured correctly. Whether it was forgetting a small line somewhere causing nothing to talk, or an extra comma because of a sloppy copy/paste after several hours, there were small things that showed me I need to take a step back from time to time so I don't get such tunnel vision. 
Overall this project was a great learning experience for me, and helped pin point a lot of areas that I can really focus in on and work out, both on the coding front and the teamwork front.