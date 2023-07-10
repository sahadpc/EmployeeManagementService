API Documentation For Employee Management Service
--------------------------------------------------
POST /auth/register :- adding admin details in the database like email and password  

POST /auth/generate :- api for generating the token by authenticating the admin details giving at the time of login

POST /auth/validate :- api for validating the token by fetching header,payloader and signature

POST /emp/addEmployee :- api for saving the employee in the database

GET /emp/employee :- api for getting a list of all employees that are stored in the database

POST /emp/addDepById/{"id"} :- api for adding dependent for the employee having employeeId=id

GET /emp/showDepById/{"id"} :- api for fetching all the dependent of the employee having employeeId=id

GET /emp/deleteById/{"id"} :- api for deleting all the records of employees from the database having employeeId=id

POST /emp/updateEmployee/{"id"} :- api for updating the employee details based on the employeeId=id

GET /emp/sortBySalary :- api for getting a list of all employees from the database in the sorted order based on salary

GET /emp/page/{"pageNo"} :- api for fetching the paginated list of employees by passing page number as a parameter 

GET /emp/page/{"pageNo"} :- api for fetching the paginated list of employees in the sorted order of their  salary  by passing page number, sort field and sort direction as parameter

