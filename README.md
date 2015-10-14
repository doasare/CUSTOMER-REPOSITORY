CRUD Customer Module
===================

##Scenario
An insurance company needs a system to manage their customer data.  A software engineering team is working on the story below.

*As a system user, I want to add new customer data into the system. After added, I can view a certain customer, and a customer list. Of course, I am also able to modify the data as well as remove it from the system.* 

Using Junit for TDD/BDD approach. created simple repository component used to handle fluent crud operations
##

1. Creating a single customer
it check if credentials are entered correctly for the new customer to list
it creates a customer with the validated information
it adds the customer to the list of customers
Test => GET REQUEST, on endpoints = “/create/{id}" 
- functionality adds a newly created customer object to customerRepository 
- visible when list functionality is called

endpoints = 
“/create/{id}" 
“/create/" 

parameters expected:

firstName, required = true
lastName, required = true
email, required = false
phone, required = false



2. Updating a single customer
it looks for the customer using an identifier attribute
it checks that the customer exists otherwise ends with an exception error
it validates the entry data otherwise ends with an exception error
it replaces existing data with new data
it confirms successful operation
Test => PUT REQUEST, on endpoints = “/update/{id}" 
- find existing customer object in customerRepository with current values
- replaces current values with new data
- existing entry now contains new

endpoints = 
“/update/{id}" 

parameters expected:

firstName, required = true
lastName, required = true
email, required = false
phone, required = false

3. Deleting a single customer
it looks for the customer using an identifier attribute
it checks that the customer exists otherwise ends with an exception error
it deletes entry from customers list 
it confirms success operation
Test => DELETE REQUEST, on enpoints = "/delete/{id}"
- Removes existing entry in customerRepository

endpoints = 
“/delete/{id}" 

parameters expected:

N/a

4. Reading a single customer
it looks for the customer using an identifier attribute
it returns customer’s information otherwise returns nothing
Test => GET REQUEST, on endpoint = "/find/{id}"
- returns existing customer objects from customerRepository

endpoints = 
“/find/{id}" 

parameters expected:

N/a

5. Listing all customers
it returns all customer’s information otherwise returns nothing
Test => GET REQUEST, on endpoint = "/"
- returns all existing customer objects from customerRepository

endpoints = 
“/“ 

parameters expected:

N/a

by David Osseo-Asare
