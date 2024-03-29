# Managing a collection in a database

## Adding a Collection

````
use school
db.students.insertOne({
    name: "John",
    age: 30,
    subjects: ["Math", "Science"]
})
````

## To view the collections in the database

````
use school
show collections
````

## To view the documents in a collection

````
use school
db.students.find()
````