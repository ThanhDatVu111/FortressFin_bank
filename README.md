**FortressFin Banking Application**

FortressFin is a Java-based banking application that simulates basic banking operations such as depositing, withdrawing, transferring funds, and viewing transaction history. The application integrates with MySQL to securely store user data.

**Features**
Sign Up
Allows users to create an account by providing necessary information.
Utilizes MySQL database to store user data securely.

Login
Enables users to access their account securely by entering their username and password.
Validates user credentials using MySQL database.

Deposit
Allows users to deposit funds into their account.
Updates the account balance in the MySQL database.

Withdraw
Allows users to withdraw funds from their account.
Updates the account balance in the MySQL database.

Transfer
Facilitates fund transfer between user accounts.
Validates recipient information and updates account balances accordingly in the MySQL database.

Pin Change
Enables users to change their PIN for added security.
Updates the PIN in the MySQL database.

Transaction History
Provides users with a summary of their past transactions.
Retrieves transaction data from the MySQL database.

Main Menu
Displays a main menu allowing users to interact with different functionalities/classes.
Users can navigate between features such as deposit, withdraw, transfer, pin change, and more by clicking button.

**Project Structure**
Balance.java: Handles account balance related operations.
Custom_connection.java: Manages the connection to the MySQL database.
Deposit.java: Implements deposit functionality.
Login.java: Manages user authentication and login process.
Main.java: Main class that displays user interface and navigates between different functionalities.
Pin.java: Handles PIN change operations.
Signup1.java, Signup2.java, Signup3.java: Classes responsible for user sign up process.
TransactionHistory.java: Retrieves and displays transaction history.
Transfer.java: Implements fund transfer functionality.
Tutorial.java: Provides tutorial and guide for users.
Withdraw.java: Implements fund withdrawal functionality.


**Usage**
Clone the repository to your local machine.
Import the project into your preferred Java IDE.
Set up MySQL database and configure connection details in Custom_connection.java.
Run Login.java to launch the application.
Explore various banking features using the intuitive user interface.

**Contributing**
Contributions are welcome! If you have any suggestions or feature requests, feel free to open an issue or submit a pull request.

**License**
This project is licensed under the MIT License.
