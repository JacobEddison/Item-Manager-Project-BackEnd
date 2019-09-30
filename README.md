# Item-Manager-Project-BackEnd

Solo project assignment for QA.

## Index
[Brief](#brief)
   * [Solution](#solution)
   
[Architecture](#architecture)
   * [Multi Tier Architechture Diagram](#mla)
	
[Testing](#testing)
   * [Report](#report)

     
[Deployment](#depl)
   * [Technologies Used](#tech)
     
[Front End Design](#FE)

[Improvements for the Future](#improve)

[Authors](#auth)

<a name="brief"></a>
## The Brief

To create an OOP-based application with utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training. The application must manipulate two tables with full CRUD functionality.

<a name="solution"></a>
### Solution

I endeavored to create an application to allow the user to manage their items and loadouts in the game Destiny 2, this app would allow them to create edit and delete items and in turn use them to create update and delete loadouts.

<a name="architecture"></a>
## Architecture

<a name="mla"></a>
### Multi Tier Architecture Diagram
Please click on the diagram for a high resolution version:
![MTA](/documents/UML_Diagram.png)

This is a very high-level architecture diagram to demonstrate the architecture of the application. It does not include getters and setters, test classes, or constants classes. 


<a name="testing"></a>
## Testing

JUnit, Mockito and Selenium tests have been used for automated testing with codacy being used for static testing.

<a name="report"></a>
### Report

![Link to JUnit Tests](/documents/JUnitTests.png)
![Codacy Tests](/documents/Codacy1.png)
![](/documents/Codacy2.png)
![Selenium Test](/documents/Selenium.png)

Test coverage for the backend is at 88% and only one test was completed for selenium with hopes to create more soon.
Codacy showed very few errors in the backend most of which being code style, whilst many errors were found in the front end including 15 for security.

<a name="depl"></a>
## Deployment

The build, test and deployment process was automated using Jenkins, with a time trigger to pull from github.

This application can be deployed both locally and externally through a virtual machine.

![Deployment Pipeline](/documents/Pipeline.png)
<a name="tech"></a>
### Technologies Used

* H2 Database Engine - Database
* Java - BackEnd API
* JavaScript, HTML, CSS - FrontEnd Website
* Jenkins - CI Server
* Docker - Package Management
* Maven - Dependency Management
* Codacy, JUnit, Selenium - Testing
* [Git](https://github.com/JacobEddison/Project-FrontEnd) - VCS
* [Trello](https://trello.com/b/8LMTInIm/solo-project) - Project Tracking
* GCP - Hosting

<a name="FE"></a>
## Front End Design
### Wireframes
I seam to have misplaced my draw.io wireframes however i have the origional sketches I made and will update this as soon as possible.

![Old Wireframes](/documents/Wireframe_1.pdf)

### Final Appearance

![FrontEnd Screenshots](/documents/FrontEnd1.png)
![](/documents/FrontEnd2.png)

<a name="improve"></a>
## Improvements for the Future

I would like to fix issues with writing to the second table and improve the relations between the two databases to make them simplier to manage.

I would like to add filtering to the class pages so that loadouts and items only show for their specific class.

In the future i would like to implement the bungie API so that item information can be pulled from the players actual account and loadouts can be equiped to players in real time, this will however remove much of the CRUD functionality of my project as there are limits to what can be manipulated on the APIs database.

<a name="auth"></a>
## Authors

Jacob Eddison


