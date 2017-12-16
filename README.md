# spring web application

### Step1: Backend Project Setup
1. Create spring-boot-intializer project with dependencies:
a. spring-security
b. spring-boot-devtools
c. thymeleaf
d. spring-data-jpa
e. mysql-connector
2. Create Entity called 'Department' with attributes departmentId and name.
3. Create DepartmentRepository interface and extend JPARepository interface.
4. Create DepartmentController and write different methods for CRUD operations.
5. Configure database in application.yml or in application.properties file.
6. Run and see result using postman

### Step2: FrontEnd Setup.
You are done in back-end, now lets do following steps for front-end.
1. Create different html files like home.html, about.html, department.html, login.html etc file in templates folder under `src/main/resources`, and modify it as per your need.</br>
2. Create Default Controller and write following code:</br>
`public class DefaultController {`</br>
   ` @GetMapping("/")`</br>
   ` public String home1(){`</br>
        `return "home";`</br>
        
   ` }`</br>
    this will open your home.html page.
3. Now, lets create template for our project. for this we are going to create header for navigation bar. </br>So create header.html file under `templates/fragments`.
4. Write following code
`<!DOCTYPE html>`</br>
`<html xmlns:th="http://www.thymeleaf.org">`</br>
    `<head>`</br>
       ` <title>Bootstrap 4 Example</title>`</br>
        `<meta charset="utf-8" />`</br>
    `<div th:fragment="header-css">`</br>
       ` <meta name="viewport" content="width=device-width, initial-scale=1" />`</br>
        `<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous" />`</br>
     
   ` </div>`</br>
`</head>`</br>
`<body>`</br>
   ` <div th:fragment="header">`</br>
       ` <nav class="navbar navbar-expand-sm bg-primary navbar-dark">`</br>
           ` <!-- Brand/logo -->`
            `<a class="navbar-brand" href="#">Logo</a>`</br>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/admin">Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/department">Department</a>
                </li>

            </ul>

               </nav>

    </div>
</body>

</html></br>

5. Now in home.html write following code:</br>
   ` <div th:replace="fragments/header :: header-css" /> ` inside header section </br>
   ` <div th:replace="fragments/header :: header" /> ` inside body section </br>
and don't forget to include xmlns for thymeleaf in html tag.</br>
Similarly write same code for every page.
