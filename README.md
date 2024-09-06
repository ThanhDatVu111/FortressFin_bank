# 🏦 FortressFin Banking Application
FortressFin is a comprehensive Java-based banking application that simulates essential banking operations, including deposits, withdrawals, fund transfers, and transaction history tracking. The application securely integrates with MySQL to manage user data and ensures a seamless banking experience.

## ⚙️ Tech Stack
Java for backend operations

MySQL for secure data storage

JDBC for database connectivity

Swing for graphical user interface (GUI)

## 🔋 Features
Sign Up
Users can create an account by providing necessary information, which is securely stored in the MySQL database.

Login
Secure login functionality that validates user credentials against the database to allow access to accounts.

Deposit Funds
Enables users to deposit money, updating the account balance stored in the database.

Withdraw Funds
Allows users to withdraw money from their account, with real-time balance updates in MySQL.

Fund Transfer
Facilitates secure fund transfers between accounts, validating recipient information and updating balances accordingly.

PIN Change
Users can enhance security by updating their account PIN, stored securely in the database.

Transaction History
Provides users with a detailed history of their past transactions by fetching data from the database.

Main Menu Interface
A user-friendly interface that allows users to navigate through different functionalities including deposits, withdrawals, transfers, and more.

## 📂 Project Structure
Balance.java
Manages operations related to account balances.

Custom_connection.java
Establishes and manages the MySQL database connection.

Deposit.java
Implements the deposit functionality, updating user accounts.

Login.java
Handles user authentication and login processes.

Main.java
The main driver class responsible for user interface and feature navigation.

Pin.java
Handles PIN updates and security management.

Signup1.java, Signup2.java, Signup3.java
Classes responsible for the multi-step user sign-up process.

TransactionHistory.java
Retrieves and displays user transaction history from the MySQL database.

Transfer.java
Manages fund transfers between user accounts.

Tutorial.java
Provides a user tutorial for first-time users navigating the application.

Withdraw.java
Manages the withdrawal of funds from user accounts.

## 🚀 Quick Start
Follow these steps to set up and run the project locally.

**Prerequisites**
Ensure the following are installed on your machine:

Java (JDK 11 or later)

MySQL

IDE (e.g., IntelliJ IDEA, Eclipse)

**Setup & Installation**
Clone the Repository:
git clone https://github.com/ThanhDatVu111/FortressFin_bank.git


**Configure MySQL:**
Create a MySQL database for the application.

Update the database connection details in Custom_connection.java.

**Run the Application:**
Open the project in your preferred Java IDE.

Run Login.java to start the banking app interface.

## 🏗️ Contributing
Contributions are always welcome! Whether it's bug fixes, new features, or improving documentation, feel free to fork the repository, make changes, and submit a pull request.

This version highlights the key technical aspects while maintaining a clean and professional tone. It also provides more structure and better readability for recruiters or potential collaborators.
