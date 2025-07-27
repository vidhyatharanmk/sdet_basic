# SDET Basic practices

1. Implement the following program using Java OOPs concepts:
	- Create the following three classes and corresponding variables and methods:
		- *Account (Base Class):* Include `Interest` as one variable and a corresponding method to calculate interest and add it to the account.
		- *SavingsAccount (Derived Class):* Implement overridden methods of the Account class.
		- *CurrentAccount (Derived Class):* Implement overridden methods of the Account class.

    - ***Solution: [bankacc.java](./bankacc.java)***
2. Implement the following program using Python:
	- Create a Python class `Student` with three variables: `Name`, `Grade`, and `Age`.
	- Create a `display()` method to display the Name, Grade, and Age of an object created using the Student class.
	- Create another class `School` which inherits from the Student class and create another method `SchoolStudentDisplay()` which displays Name, Grade, and Age for objects created using the School class.

    - ***Solution: [display.py](./display.py)***

3. Launch Firefox and verify the MakeMyTrip logo is present on the page.
	- Implement using Selenium with WebDriver.
	- URL: https://www.makemytrip.com/

4. Launch Chrome, click on Flights, and select OneWay to enter FROM and TO locations.
	- Find the WebElements (Flights, OneWay, FROM, and TO) using XPaths.
	- URL: https://www.makemytrip.com/
	- Note: While implementing the above program, write generic functions to interact with the browser.

5. Implement programs 3 and 4 using TestNG concepts and write them using the `@Test` annotation.
	- To launch the browser (repeated code), maintain it in the `@BeforeMethod` annotation.
	- Generate TestNG HTML reports and find the test results.

6. Create a Maven project and implement all the programs in the Maven project.
	- Add all the necessary JARs and run all the programs using Maven commands.

7. Create a branch in GitHub, write all the programs in that branch, and push the code into the same branch.
	- Share the GitHub details to evaluate.

8. Create a collection in Postman and create positive and negative cases for the below APIs. Use HTTP methods to get valid responses:
	- GET: https://api.restful-api.dev/objects/5
	- POST: https://api.restful-api.dev/objects
	- PUT: https://api.restful-api.dev/objects/5
	- DELETE: https://api.restful-api.dev/objects/7
	- Note: The ID will be auto-generated, so no need to send it while posting a new record.
	- Verify the HTTP status codes while running positive and negative test cases.

9. Create a Thread Group in a Test Plan using JMeter (use the below URL to send requests and get the server response):
	- Use assertions in JMeter to validate the responses.
	- Use assertion results (listeners concept).
	- URL: https://www.makemytrip.com/

10. Launch Chrome and verify the W3Schools logo is present on the page.
	- Implement using Selenium with WebDriver (implement it in Python and use pytest fixtures).
	- URL: https://www.w3schools.com/

    - ***Solution: [w3schools.py](./w3schools.py)***
