# Selenium Automation Testing Project: Identify Courses
 
## Project Overview
 
This Selenium automation testing project focuses on automating tasks related to the coursera.org website. 
The primary objectives include searching for courses, capturing course details, navigating through the portal, 
filling form, and capturing error message. The project uses various dependencies and libraries to facilitate automation.
 
## Project Structure
 
### 1. Maven Repository
 
- **Maven Version**: 3.12.1
 
### 2. Dependencies
 
- **Apache POI**
 - Version: 5.2.4
 - Purpose: Used for reading and writing Excel files, facilitating data-driven testing.
 
- **TestNG**
 - Version: 7.9.0
 - Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
- **Extent Report**
 - Version: 5.1.1
 - Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
- **Selenium**
 - Version: 4.16.1
 - Purpose: Enables interaction with web elements, navigation, and form submission in the browser.

- **Jenkins Integration**
 -Jenkins is employed for continuous integration. Ensure Jenkins is set up with necessary configurations to execute the automation scripts.
 
- **Maven**
 -Maven version 3.8.1 is the build automation tool for managing dependencies and building the project. Maven simplifies the project structure and management.
 
- **Selenium Grid**
 -Selenium Grid is utilized for parallel test execution. Grid version 3.141.59 ensures optimal distribution of test cases across multiple nodes.
 
- **Git**
 -Git is the version control system used for tracking changes in the source code. Version 2.35.0 is used for collaboration and version management.
 
## Automation Test Flow
 
1. **Open coursera.org page**
 - Navigate to coursera.org.
 
2. **Validate the page**
 - Verify navigation to coursera.org.
 
3. **Search for Web Development courses**
 - Click on the search bar.
 - Provide input 'Web Development" and click on search button.
 
4. **Select criteria**
 - Select 'Beginner' from Level.
 - Select 'English' from Language.
 
5. **Get course details**
 - Select the first course and get informations (Name, Rating, Total learning hours).
 - Select the second course and get informations (Name, Rating, Total learning hours).
 - Store the information in Excel sheet.
 
6. **Search for Language Learning courses**
 - Click on Coursera logo.
 - Provide input 'Language Learning' and click on search button.
 
7. **Get course details**
 - Select 5 languages.
 - Print total count of courses under each language for every level (Beginner, Intermediate, Advanced, Mixed).
 - Store the information in Excel sheet.
 
8. **Navigate to form**
 - Click on 'For Enterprise'.
 - Click on 'For Universities'.
 - Click on 'Solutions'.
 
9. **Fill form details**

 - Fill the form with random inputs (Full name, Business email, Job title etc).
 - Click on 'Continue'.
 
10. **Capture the Email error message**
 - Capture and print the email error message displayed.
 
## How to Run the Tests
 
1. **Open Eclipse IDE:**
 - Launch Eclipse IDE on your machine.
 
2. **Import Project:**
 - Select `File` -> `Import` from the menu.
 - Choose `Existing Maven Projects` and click `Next`.
 - Browse to the directory where you cloned the repository and select the project.
 
3. **Update Maven Project:**
 - Right-click on the project in the Project Explorer.
 - Choose `Maven` -> `Update Project`.
 - Click `OK` to update dependencies.

4. **Set Up Configuration**
 - Open the 'src/test/resources/config.properties' file.
 - Update any configuration parameters like browser type, URLs, etc., as needed.
 
5. **Run Test Suite:**
 - Locate the test suite file (e.g., `src/test/java/TestSuite.java`).
 - Right-click on the file and choose `Run As` -> `TestNG Suite`.
 
6. **View Reports:**
 - After execution, open the 'reports' folder.
 - Find the Extent Report HTML file for detailed test reports.
 
## Author Information
 
- **Srishti Priya**
 