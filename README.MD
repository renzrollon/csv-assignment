## CSV Coding Challenge

You are given the task of writing a simple program which reads from a given CSV file and saves the data in
a database. This challenge can be completed in about 2 hours, however there is no time limit as such.

##### Attachments

- `sales.csv`: The csv file which your program needs to parse. It is a small list of sales made in a store.
- `schema.sql`: The DDL for the database your program needs to use. This DDL is written for a MySQL DB,
  however you may use any DB of your choosing as long as the constraints are the same.

##### Guidelines

- The program needs to be written in Java or .Net (if your application is for a .Net role).
- Create your solution as if you were in a real-life project and it would have to be shipped into production after you are done
  (read that again, and REALLY consider it in your approach).
- For the purpose of this exercise you can assume that we already have a database containing the necessary tables; you don't need
  to include the database itself in your solution.
- Please include a short readme when returning your solution describing decisions and assumptions you made during development.
- Please submit as a ZIP file over either email or DropBox/Google Drive/etc - do NOT push to a public repository.
- For .Net submissions we require: Use .Net Core and it must be possible to compile and run on Linux


### Solution
#### Assumptions:
- CSV file sources are located in local directory
- Enough memory to load all the csv file sizes
- Header names for the csv file won't change. (I might use a less simple solution to handle changing header names)
- Loaded data is to be saved in a NEW table

#### Decisions:
- Jackson DataFormat library for reading CSV: for simple implementation and annotations
- Spring Data JPA for persistence: less boilerplate code
- StoreOrderService: loop each object and skip saving those with Exceptions
- CSVLoader: generic reading of CSV
- DBEvolveService: initializer (with toggle) of database 

#### To run (Maven):
mvn clean spring-boot:run

or

mvn clean test


