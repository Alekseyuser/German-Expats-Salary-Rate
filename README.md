# German-Expats-Salary-Rate

This application based on several hundreds lines DB about expats who works in Germany.
It provide standart CRUD functions using json requests.
No frontend for this moment.
List of technologies uses in the application: spring boot, maven, tomcat, javadoc, junit4, log4j, mariaDB.
DB has deployed to remote VDS to ensure portability.

#### Requirements:
JDK 1.8+

#### Request json examples:

Method	| Path	| Description | Example |
------------- | ------------------- | ------------- | ------------------------- |
GET	| /germanemployee/{id}/	| Get data by id	| http://localhost:8080/germanemployee/1/ |
GET	| /germanemployees/	| Get all data	| http://localhost:8080/germanemployees/ |
POST	| /germanemployee/	| Add new record	| {"date_point":"12/13/2016 14:19","age":1,"sex":"m","city":"Berlin","position":"test","experience_in_Europe":1,"total_experience":3,"salary":54000,"salary_1_year_ago":48000,"first_europe_salary":48000, "number_of_job_in_europe":1,"work_language":"test","company_size":"50-100","company_type":"startup","level":"Senior"} |
PUT	| /germanemployee/	| Update record	| {"id":1,"date_point":"12/13/2016 14:19","age":1,"sex":"m","city":"Berlin","position":"test","experience_in_Europe":1,"total_experience":3,"salary":54000,"salary_1_year_ago":48000,"first_europe_salary":48000,"number_of_job_in_europe":1,"work_language":"test","company_size":"50-100","company_type":"startup","level":"Senior"} |
DELETE	| /germanemployee/{id}/	| Delete record	by id | http://localhost:8080//germanemployee/373/ |


#### To do list:
- implement simple UI using smartless html templates;
- implement pagination using PagingAndSortingRepository.
