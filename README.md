java 21
Springboot 3.4.0
H2 db


## Spring Transaction Propagation Behaviors

The following are the various transaction propagation types supported by Spring:

- **`REQUIRED`**  
  Joins an existing transaction if available; otherwise, creates a new one.

- **`REQUIRES_NEW`**  
  Always starts a new transaction, suspending any existing one.

- **`MANDATORY`**  
  Must run within an existing transaction. Throws an exception if none exists.

- **`NEVER`**  
  Must run without a transaction. Throws an exception if a transaction exists.

- **`NOT_SUPPORTED`**  
  Runs without a transaction. Suspends any existing transaction during execution.

- **`SUPPORTS`**  
  Runs within a transaction if one exists; otherwise, runs non-transactionally.

- **`NESTED`**  
  Executes within a nested transaction if a current transaction exists.  
  Allows rollback of the nested transaction independently from the outer transaction.
