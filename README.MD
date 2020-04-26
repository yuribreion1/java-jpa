# Java project using Java Persistence API(JPA)

The application created for this case is a banking where the accounts are created and managed

## Packages

- br.com.alura.bank.models
  - Account.java - Class responsible for the account attributes.
  
- br.com.alura.bank.test
  - ChangeAmount.java - Test class created to add amount column to the account
  - TestCreateAccount.java - Test class used to insert new accounts into the table
  - TestTableAccount.java - Class used to create account table in the database
  
## Dependencies

- Hibernate ORM
- DB2 JDBC driver

## Database

For this project, I'm using DB2 on cloud to avoid any local configuration that is not part of this training

## JPA States

- Managed
  - During this state, Java specification have entity control in terms of synchronization, every change in each attribute will change the model

- Detached
 - Every statement outside the EntityManager will be detached, in other words, every change in this moment won't reflect in the model
 
- Removed
  - This state there is no synchronization with the model and the item was removed from the database

 