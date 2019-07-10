# German-Expats-Salary-Rate

This application based on several hundreds lines DB about expats who works in Germany.
It provides REST API CRUD functions.

List of technologies uses in the application: spring boot, maven, jpa, hibernate, tomcat, javadoc, junit4, log4j, mysql, bootstrap, thymeleaf.

#### Requirements:
JDK 1.8+

#### Request json examples:

Method	| Path	| Description | Example |
------------- | ------------------- | ------------- | ------------------------- |
GET	| /germanemployee/{id}/	| Get data by id	| http://localhost:8080/germanemployee/1/ |
GET	| /germanemployees/	| Get all data	| http://localhost:8080/ |
POST	| /germanemployee/	| Add new record	| {"date_point":"12/13/2016 14:19","age":1,"sex":"m","city":"Berlin","position":"test","experience_in_Europe":1,"total_experience":3,"salary":54000,"salary_1_year_ago":48000,"first_europe_salary":48000, "number_of_job_in_europe":1,"work_language":"test","company_size":"50-100","company_type":"startup","level":"Senior"} |
PUT	| /germanemployee/	| Update record	| {"id":1,"date_point":"12/13/2016 14:19","age":1,"sex":"m","city":"Berlin","position":"test","experience_in_Europe":1,"total_experience":3,"salary":54000,"salary_1_year_ago":48000,"first_europe_salary":48000,"number_of_job_in_europe":1,"work_language":"test","company_size":"50-100","company_type":"startup","level":"Senior"} |
DELETE	| /germanemployee/{id}/	| Delete record	by id | http://localhost:8080//germanemployee/373/ |



