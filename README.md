 Banking Management System
A comprehensive Java-based banking application that demonstrates object-oriented programming principles, exception handling, and clean architecture design.
 Table of Contents

Overview
Features
Architecture
SOLID Principles Implementation
Project Structure
Installation
Usage
Class Documentation
Exception Handling
Future Enhancements
Contributing
License

 Overview
The Banking Management System is a console-based application that simulates core banking operations. It provides functionality for managing customer accounts, processing transactions, and maintaining transaction history with a focus on clean code principles and robust error handling.
Key Highlights

Object-Oriented Design: Implements inheritance, polymorphism, and abstraction
SOLID Principles: Follows all five SOLID principles for maintainable code
Type Safety: Uses custom exceptions for robust error handling
Modular Architecture: Clear separation of concerns across packages
User-Friendly Interface: Console-based menu system with formatted output

 Features
Account Management

 Create multiple account types (Checking, Savings)
 View all accounts with detailed information
 Search for specific accounts by account number
 Track account balances and status
 Calculate total balance across all accounts


 Architecture
The application follows a layered architecture pattern:
┌─────────────────────────────────────┐
│         User Interface Layer        │
│            (Main.java)              │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│       Business Logic Layer          │
│  (AccountManager, TransactionMgr)   │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│         Domain Model Layer          │
│  (Account, Transaction, Customer)   │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│         Utility Layer               │
│  (InputReader, TablePrinter)        │
└─────────────────────────────────────┘

 SOLID Principles Implementation
1. Single Responsibility Principle (SRP) 
2. Open/Closed Principle (OCP) 
3. Liskov Substitution Principle (LSP) 
4. Interface Segregation Principle (ISP) 
5. Dependency Inversion Principle (DIP) 


 Project Structure
banking-system/
│
├── src/
│   ├── account/
│   │   ├── Account.java                 # Abstract base class
│   │   ├── CheckingAccount.java         # Checking account implementation
│   │   ├── SavingsAccount.java          # Savings account implementation
│   │   ├── AccountManager.java          # Account collection manager
│   │   ├── IFeeAccount.java            # Fee capability interface
│   │   ├── IInterestBearing.java       # Interest capability interface
│   │   ├── IOverdraftable.java         # Overdraft capability interface
│   │   └── IMinimumBalance.java        # Minimum balance interface
│   │
│   ├── customers/
│   │   └── Customer.java                # Customer entity
│   │
│   ├── transactions/
│   │   ├── Transaction.java             # Transaction entity
│   │   └── TransactionManager.java      # Transaction history manager
│   │
│   ├── exceptions/
│   │   ├── AccountNotFoundException.java
│   │   ├── InsufficientFundsException.java
│   │   ├── InvalidAmountException.java
│   │   └── ViewAccountException.java
│   │
│   ├── utils/
│   │   ├── InputReader.java            # Console input handler
│   │   ├── TablePrinter.java           # Table formatting interface
│   │   └── ConsoleTablePrinter.java    # Console table implementation
│   │
│   └── main/
│       └── Main.java                    # Application entry point
│
├── README.md
└── .gitignore

 Installation
Prerequisites

Java Development Kit (JDK) 8 or higher
Any Java IDE (IntelliJ IDEA)
