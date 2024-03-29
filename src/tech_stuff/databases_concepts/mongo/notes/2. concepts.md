# What is a MONGODB DATABASE?
It is a no-sql database that stores data in the form of documents similar to JSON objects.

# Important Terminologies
## Collection
A collection is a group of documents stored in MongoDB, which are analogous to the tables in relational databases.

## Document
A document is the same as a row in RDBMS. It is single entry in the database is referred to as a collection.

## Embedded Document (https://www.educative.io/courses/mongodb-complete-guide/qV49WGV9VJy)
An embedded document is a document that is nested inside another document. They are sometimes referred to as child documents.
Example: The address field in the following document is an embedded document.
```
{
    "_id": "1",
    "name": "John",
    "age": 30,
    "address": {
        "street": "Main Street",
        "city": "New York",
        "state": "NY"
    }
}
```

## Filter Query
A filter query fetches collections from a document based on the specified criteria.

## Projection Query
A projection is used to select specific fields from the documents in a collection. It is used to limit the amount of data that is returned from a query.

## Operators
Operators are used to perform different filters or other operations on a collection or document.

## Aggregation
Aggregation is a process of combining data from multiple sources. It is used to perform complex data processing tasks.

## Aggregation Pipeline
They are used to perform aggregations or join operations on collections.

## GRIDFS
It is a specification for storing and retrieving large files in MongoDB. \n
It divides files into parts, or chunks, and stores each of those chunks as a separate document.

## When Should We Use the MongoDB Database?
1. Stores data in the form of documents similar to JSON objects.
2. It is a schema-less database.
3. It supports auto-sharding. Sharding is a method of storing data records across many server instances. \n 
   - The NoSQL framework is natively designed to support automatic distribution of the data across multiple servers including the query load.
4. It supports replication. MongoDB replication is the process of creating a copy of the same data set in more than one MongoDB server. \n
   - It is used to ensure that the data is available in case of a failure.
5. It supports indexing. Indexing is a process of creating a data structure that improves the speed of data retrieval.
   - Indexing can be done on document level and embedded document level.
6. Can support large data sets via use of GRIDFS.
7. It provides a way to perform complex data queries via aggregation and aggregation pipelines.