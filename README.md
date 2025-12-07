
# Airline Reservation System

A simple desktop Airline Reservation System implemented in Java with Swing-based GUIs and JDBC-backed persistence. The project demonstrates a complete (minimal) workflow for airline managers and passengers: creating and maintaining flights, registering passengers, and booking tickets.

**Features**
- **Flight Management:** Add, modify, and delete flights using manager (gérant) interfaces.
- **Passenger Flow:** Passenger registration, login, and profile management.
- **Booking:** Search flights and book/cancel tickets with basic seat handling.
- **View Flights:** GUI screens to list and filter available flights.

**Architecture & Components**
- **UI Layer:** Swing GUIs located in `Air_Line_Reservation/src/Gui_Package/` (e.g., `Gui_Main.java`, `Gui_Add_Flight.java`).
- **Business / DB Layer:** Database operations are implemented under `Air_Line_Reservation/src/gerant_connection/` and `Air_Line_Reservation/src/passenger_connection/`.
- **Entry Points:** `Air_Line_Reservation/src/main1.java` and `Air_Line_Reservation/src/Gui_Package/Gui_Main.java` launch the application windows.

**Technologies Used**
- **Language:** Java (JDK 8+ compatible)
- **UI Toolkit:** Swing (`javax.swing`)
- **Database Access:** JDBC (`java.sql.*`) with `DriverManager` and `PreparedStatement`
- **Database:** MySQL (example JDBC URL `jdbc:mysql://localhost:3306/Airline` used in code)

**Database Notes**
- The code expects a MySQL database named `Airline` and uses a default connection in several classes: host `localhost`, user `root`, password `0000` (please change these for your environment).
- Typical tables inferred from the code: `Passenger`, `Flight`, `Airplane`, `Ticket`.

Sample minimal SQL schema (example — adapt column types/constraints as required):
```sql
CREATE TABLE Airplane (
	airplane_id INT AUTO_INCREMENT PRIMARY KEY,
	model VARCHAR(100),
	total_seats INT
);

CREATE TABLE Flight (
	flight_id INT AUTO_INCREMENT PRIMARY KEY,
	airplane_id INT,
	origin VARCHAR(100),
	destination VARCHAR(100),
	departure_time DATETIME,
	arrival_time DATETIME,
	price DECIMAL(10,2),
	seats_available INT,
	FOREIGN KEY (airplane_id) REFERENCES Airplane(airplane_id)
);

CREATE TABLE Passenger (
	passenger_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(200),
	email VARCHAR(200),
	phone VARCHAR(50),
	password VARCHAR(200)
);

CREATE TABLE Ticket (
	ticket_id INT AUTO_INCREMENT PRIMARY KEY,
	passenger_id INT,
	flight_id INT,
	booking_time DATETIME DEFAULT CURRENT_TIMESTAMP,
	status VARCHAR(50),
	FOREIGN KEY (passenger_id) REFERENCES Passenger(passenger_id),
	FOREIGN KEY (flight_id) REFERENCES Flight(flight_id)
);
```

**How to build & run (quick)**
Requirements: JDK 8+ and a running MySQL server.

From PowerShell (example):
```powershell
cd d:\Air\AirlineReservationSystem\Air_Line_Reservation\src
javac -d ..\bin *.java Gui_Package\*.java gerant_connection\*.java passenger_connection\*.java
java -cp ..\bin main1
```

Or open the project in an IDE (IntelliJ IDEA / Eclipse):
- Import as a plain Java project, add `d:\Air\AirlineReservationSystem\Air_Line_Reservation\src` as source root, ensure JDK is configured, then run `main1` or `Gui_Main`.

**Security & Improvements**
- Do not hard-code database credentials. Use environment variables or a configuration file.
- Add validation and stronger error handling for user input and DB operations.
- Consider adding a build system (`pom.xml` or `build.gradle`) to simplify compilation and packaging.
- Add migration scripts (Flyway or plain SQL) to manage schema creation and updates.

**Next steps I can help with**
- Add a `db/` folder with SQL migration scripts based on the sample schema.
- Create a `pom.xml` (Maven) to simplify building and running the project.
- Replace hard-coded DB credentials with a small config loader.

If you want one of these, tell me which and I'll prepare the files.
