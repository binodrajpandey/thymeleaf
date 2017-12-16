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
public class DefaultController {
    @GetMapping("/")
    public String home1(){
        return "home";
        
    }
    this will open your home.html page.
3. Now, lets create template for our project. for this we are going to create header for navigation bar. So create header.html file under templates/fragments.
4. Write following code
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Bootstrap 4 Example</title>
        <meta charset="utf-8" />
    <div th:fragment="header-css">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous" />
     
    </div>
</head>
<body>
    <div th:fragment="header">
        <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="#">Logo</a>

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

</html>

5. now in home.html write following code:
    <div th:replace="fragments/header :: header-css" /> on header
    <div th:replace="fragments/header :: header" /> on body 
and don't forget to include xmlns for thymeleaf in html tag.
6. now create user.html page and write same codes in previous step.
7. In DefaultController.java file write following code:
@GetMapping("/user")
    public String user() {
        return "/user";
    }
 8. similary you can create department.html, student.html, admin.html, about.html etc and write associated controller handler mapping

