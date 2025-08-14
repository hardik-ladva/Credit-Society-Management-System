
# Credit Society Management System

This is a Java-based console application designed to efficiently manage a credit society. It provides functionalities for managing shareholders, handling loans, maintaining a day book, and generating final account summaries. The project uses **MySQL** as the backend database for data storage.

---

## Features

### Shareholder Management
- Add new shareholders with personal and ID details.
- Edit existing shareholder information.
- View shareholder details.

### Loan Department
- Issue new loans to shareholders.
- Calculate interest and total payable amounts automatically.
- Close loans and update records.

### Day Book
- Track daily share fund collections.
- Track daily loan disbursements.

### Final Account
- View total share fund.
- View total loan fund.

---

## Technologies Used
- **Java** – For application logic and console interface.
- **MySQL** – For database management.
- **JDBC** – For database connectivity with Java.

---

## Installation and Setup

1. **Clone the repository**
```bash
git clone https://github.com/hardik-ladva/Credit-Society-Management-System.git
```

2. **Set up MySQL Database**
   - Create a database named `project`.
   - Create required tables `login`, `shareHolder`, and `loanDep` according to the application structure.
   - Example table structures:
```sql
CREATE TABLE login (
    uname VARCHAR(50),
    passwrd VARCHAR(50)
);

CREATE TABLE shareHolder (
    sid INT PRIMARY KEY,
    name VARCHAR(100),
    dob DATE,
    issueDate DATE,
    address VARCHAR(255),
    idProofName VARCHAR(50),
    idProofNumber VARCHAR(50),
    refrence VARCHAR(100)
);

CREATE TABLE loanDep (
    sid INT,
    loanNo INT PRIMARY KEY,
    loanAmount INT,
    intrest INT,
    payableAmount INT,
    intrestAmount INT
);
```

3. **Update Database Credentials**
   - In `conn.java`, ensure the MySQL username and password match your local setup:
```java
c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
```

4. **Run the Application**
   - Compile Java files:
```bash
javac main.java conn.java
```
   - Run the application:
```bash
java main
```

---

## Usage
- On startup, the application asks for a username and password.
- Navigate through menus to manage shareholders, loans, view day books, or generate final accounts.

---

## Contribution
Feel free to fork this project and enhance its functionality, such as adding a GUI, reporting features, or automated interest calculations.

---

## License
This project is open-source.
