# feature/exceptions

This branch implements **custom and centralized exception handling** for the Bank Account Management System to improve reliability and enforce business rules.

##  Purpose

* Handle invalid operations gracefully
* Enforce domain rules using custom exceptions
* Improve debugging and user feedback

##  What’s Included

* Custom exception classes (e.g. account, transaction, customer errors)
* Exceptions thrown at service/domain level
* Structured `try-catch` handling in application flow
* Clear, descriptive error messages

##  Exceptions Package

```
src/exceptions/
 ├── AccountNotFoundException.java
 ├── InsufficientBalanceException.java
 ├── InvalidAmountException.java
 ├── CustomerNotFoundException.java
 └── TransactionException.java
```

##  Usage

```bash
git switch feature/exceptions
```

Run the app and test invalid scenarios (e.g. overdraft, invalid input).

##  Status

✔ Feature complete
✔ Ready for review and merge

---

**Author: Emmanuel Mensah Peprah
