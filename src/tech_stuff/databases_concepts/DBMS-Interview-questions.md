# DBMS Interview Questions

DBMS or Database Management System is a set of applications or programs that enable users to create and maintain a database. 
DBMS provides a tool or an interface for performing various operations such as inserting, deleting, updating, etc. 
into a database. It is software that enables the storage of data more compactly and securely as compared to a file-based system. 
A DBMS system helps a user to overcome problems like data inconsistency, data redundancy, etc. in a database and makes it more convenient and organized to use it.


## What is meant by a database?
Database is an organized, consistent, and logical collection of data that can easily be updated, accessed, and managed. 
Database mostly contains sets of tables or objects (anything created using create command is a database object) 
which consist of records and fields. A tuple or a row represents a single entry in a table. An attribute or a column represents the basic units of data storage, which contain information about a particular aspect of the table. DBMS extracts data from a database in the form of queries given by the user.

## Mention the issues with traditional file-based systems that make DBMS a better choice?
The absence of indexing in a traditional file-based system leaves us with the only option of scanning the full page and hence making the access of content tedious and super slow. 
The other issue is redundancy and inconsistency as files have many duplicate and redundant data and changing one of them makes all of them inconsistent. Accessing data is harder in traditional file-based systems because data is unorganized in them.
Another issue is the lack of concurrency control, which leads to one operation locking the entire page, as compared to DBMS where multiple operations can work on a single file simultaneously.
Integrity check, data isolation, atomicity, security, etc. are some other issues with traditional file-based systems for which DBMSs have provided some good solutions.

## Explain a few advantages of a DBMS.
1. Data Sharing: Data from a single database can be simultaneously shared by multiple users. Such sharing also enables end-users to react to changes quickly in the database environment.
2. Integrity constraints: The existence of such constraints allows storing of data in an organized and refined manner.
3. Controlling redundancy in a database: Eliminates redundancy in a database by providing a mechanism that integrates all the data in a single database.
4. Data Independence: This allows changing the data structure without altering the composition of any of the executing application programs.
5. Provides backup and recovery facility: It can be configured to automatically create the backup of the data and restore the data in the database whenever required.
6. Data Security: DBMS provides the necessary tools to make the storage and transfer of data more reliable and secure. Authentication (the process of giving restricted access to a user) and encryption (encrypting sensitive data such as OTP, credit card information, etc.) are some popular tools used to secure data in a DBMS.

## Explain different languages present in DBMS.
Following are various languages present in DBMS:
1. DDL(Data Definition Language): It contains commands which are required to define the database. E.g., CREATE, ALTER, DROP, TRUNCATE, RENAME, etc.
2. DML(Data Manipulation Language): It contains commands which are required to manipulate the data present in the database. E.g., SELECT, UPDATE, INSERT, DELETE, etc.
3. DCL(Data Control Language): It contains commands which are required to deal with the user permissions and controls of the database system.
E.g., GRANT and REVOKE.
4. TCL(Transaction Control Language): It contains commands which are required to deal with the transaction of the database. E.g., COMMIT, ROLLBACK, and SAVEPOINT.

## What is meant by Data Warehousing?
The process of collecting, extracting, transforming, and loading data from multiple sources and storing them into one 
database is known as data warehousing. A data warehouse can be considered as a central repository where data flows from 
transactional systems and other relational databases and is used for data analytics. 
A data warehouse comprises a wide variety of organization’s historical data that supports the decision-making process 
in an organization.

## What is a lock. 
### Explain the major difference between a shared lock and an exclusive lock during a transaction in a database.
A database lock is a mechanism to protect a shared piece of data from getting updated by two or more database users at the same time. 
When a single database user or session has acquired a lock then no other database user or session can modify that data until 
the lock is released.

### Shared Lock: 
A shared lock is required for reading a data item and many transactions may hold a lock on the same data item in a shared lock. Multiple transactions are allowed to read the data items in a shared lock.
### Exclusive lock: 
An exclusive lock is a lock on any transaction that is about to perform a write operation. This type of lock doesn’t allow more than one transaction and hence prevents any inconsistency in the database.

## What is meant by normalization and denormalization?
1. Normalization in a database is the process in which we organize the given data by minimizing the redundancy present 
   in a relation. In this, we eliminate the anomalies present, namely - update, insertion and deletion. 
   Normalization divides the single table into smaller tables and links them using relationships. 
   The different normal forms help us minimize redundancy in the database table.
   The main aim of normalization is to add, delete or modify a field in a table without altering the existing structure 
   of the table. Normalization is a multi-step process that puts data into tabular form by removing duplicated data from the relation tables.

   The normal forms are:
   - First Normal Form (1NF) - The table is in 1NF if it contains no repeating groups.
   - Second Normal Form (2NF) - The table is in 2NF if it is in 1NF and all non-key attributes are fully functional dependent on the primary key.
   - Third Normal - Form (3NF) - The table is in 3NF if it is in 2NF and no transitive dependencies. Transitive dependency means that a non-key attribute is dependent on another non-key attribute.
   - Boyce-Codd Normal Form (BCNF) - A table is in BCNF if it is in 3NF and every non-prime attribute is fully functional dependent on the primary key.
   - Fourth Normal Form (4NF) - A table is in 4NF if it is in BCNF and has no multi-valued dependencies. A multi-valued dependency occurs when one attribute depends on another attribute.
2. Denormalization is a database optimization technique in which we add redundant data to one or more tables. This can help us avoid costly joins in a relational database. Note that denormalization does not mean ‘reversing normalization’ or ‘not to normalize’. It is an optimization technique that is applied after normalization.

   Basically, The process of taking a normalized schema and making it non-normalized is called denormalization, and designers use it to tune the performance of systems to support time-critical operations.

   In a traditional normalized database, we store data in separate logical tables and attempt to minimize redundant data. We may strive to have only one copy of each piece of data in a database.

   For example, in a normalized database, we might have a Courses table and a Teachers table. Each entry in Courses would store the teacherID for a Course but not the teacherName. When we need to retrieve a list of all Courses with the Teacher’s name, we would do a join between these two tables.

   In some ways, this is great; if a teacher changes his or her name, we only have to update the name in one place.
   The drawback is that if tables are large, we may spend an unnecessarily long time doing joins on tables. 