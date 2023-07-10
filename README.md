API Documentation For Employee Management Service
--------------------------------------------------
POST /auth/register :- adding admin details in the database like email and password
POST /auth/genarate :- api for generate the token by authenticatig the admin details giving at the time of login
POST /auth/validate :- api for validating the token by fetching header,payloader and signature

POST /emp/addEmployee :- api for saving the employee in the data base
GET /emp/employee :- api for getting list of all employee that are stored in the database
POST /emp/addDepById/{"id"} :- api for adding dependent for the employee havinf employeeId=id
GET /emp/showDepById/{"id"} :- api for fetching all the dependend of the employee having employeeId=id
GET /emp/deleteById/{"id"} :- api for deleting all the records of employee from the database having employeeId=id
POST /emp/updateEmployee/{"id"} :- api for updating the employee details based on the employeeId=id
GET /emp/sortBySalary :- api for getting list of all employee from the data base in the sorted order based on salary
GET /emp/page/{"pageNo"} :- api for fetchin paginated list of employee by passing pagenumber as parameter 
GET /emp/page/{"pageNo"} :- api for fetching paginated list of employee in the sorted order of their  salary  by passing pagenumber.sortfield and sort direction as parameter

