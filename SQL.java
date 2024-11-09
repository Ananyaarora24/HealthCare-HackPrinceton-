package healthcare_backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQL {
	
    static String url = "jdbc:mysql://localhost:3306/hackPrinceton";
    static String root_user = "root";
    static String root_password = "Password321";
    private Connection connection = null; 
    private Statement statement = null; 
    
    public void Manager() {
        this.url = url;
        this.root_user = root_user;
        this.root_password = root_password;	
        this.connection = connection;      
    }
    public void connect() throws SQLException {
        Connection connection = null;
        statement = connection.createStatement(); 
        try {
            connection = DriverManager.getConnection(url, root_user, root_password);
            System.out.println("Connection established.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
        this.connection = connection;
    }
 /*mysql> show tables
    -> ;
+-------------------------+
| Tables_in_hackprinceton |
+-------------------------+
| HealthMetrics           |
| Lifestyle               |
| MedicalHistory          |
| OvulationFertility      |
| Symptoms                |
| Users                   |
+-------------------------+
6 rows in set (0.00 sec)

mysql> describe HealthMetric;
ERROR 1146 (42S02): Table 'hackprinceton.healthmetric' doesn't exist
mysql> describe HealthMetrics;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| metric_id      | int          | NO   | PRI | NULL    | auto_increment |
| user_id        | int          | YES  | MUL | NULL    |                |
| date           | date         | YES  |     | NULL    |                |
| weight         | decimal(5,2) | YES  |     | NULL    |                |
| blood_pressure | varchar(7)   | YES  |     | NULL    |                |
| blood_sugar    | decimal(5,2) | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
6 rows in set (0.01 sec)

mysql> describe Lifestyle;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| lifestyle_id   | int          | NO   | PRI | NULL    | auto_increment |
| user_id        | int          | YES  | MUL | NULL    |                |
| date           | date         | YES  |     | NULL    |                |
| sleep_duration | decimal(3,1) | YES  |     | NULL    |                |
| exercise_type  | varchar(50)  | YES  |     | NULL    |                |
| diet_type      | varchar(50)  | YES  |     | NULL    |                |
| stress_level   | int          | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)

mysql> describe MedicalHistory;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| history_id     | int          | NO   | PRI | NULL    | auto_increment |
| user_id        | int          | YES  | MUL | NULL    |                |
| condition_name | varchar(100) | YES  |     | NULL    |                |
| diagnosis_date | date         | YES  |     | NULL    |                |
| family_history | tinyint(1)   | YES  |     | NULL    |                |
| medications    | text         | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
6 rows in set (0.01 sec)

mysql> describe OvulationFertility;
+-----------------+--------------+------+-----+---------+----------------+
| Field           | Type         | Null | Key | Default | Extra          |
+-----------------+--------------+------+-----+---------+----------------+
| ovulation_id    | int          | NO   | PRI | NULL    | auto_increment |
| user_id         | int          | YES  | MUL | NULL    |                |
| ovulation_date  | date         | YES  |     | NULL    |                |
| basal_body_temp | decimal(4,2) | YES  |     | NULL    |                |
| cervical_mucus  | varchar(20)  | YES  |     | NULL    |                |
| sexual_activity | tinyint(1)   | YES  |     | NULL    |                |
+-----------------+--------------+------+-----+---------+----------------+
6 rows in set (0.00 sec)

mysql> describe Symptoms;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| symptom_id    | int         | NO   | PRI | NULL    | auto_increment |
| user_id       | int         | YES  | MUL | NULL    |                |
| date          | date        | YES  |     | NULL    |                |
| mood          | varchar(50) | YES  |     | NULL    |                |
| pain_level    | int         | YES  |     | NULL    |                |
| fatigue_level | int         | YES  |     | NULL    |                |
| pms_symptoms  | text        | YES  |     | NULL    |                |
+---------------+-------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)

mysql> describe Users;
+------------+--------------+------+-----+-------------------+-------------------+
| Field      | Type         | Null | Key | Default           | Extra             |
+------------+--------------+------+-----+-------------------+-------------------+
| user_id    | int          | NO   | PRI | NULL              | auto_increment    |
| name       | varchar(100) | YES  |     | NULL              |                   |
| age        | int          | YES  |     | NULL              |                   |
| weight     | decimal(5,2) | YES  |     | NULL              |                   |
| height     | decimal(5,2) | YES  |     | NULL              |                   |
| email      | varchar(100) | YES  |     | NULL              |                   |
| created_at | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+------------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.01 sec)

mysql> 
*/
    public void Create_Tables() throws SQLException {
    	String Users = "CREATE TABLE Users ("
    			+ "        user_id INT PRIMARY KEY AUTO_INCREMENT,"
    			+ "        name VARCHAR(100),"
    			+ "        age INT,"
    			+ "        weight DECIMAL(5, 2),"
    			+ "        height DECIMAL(5, 2),"
    			+ "        email VARCHAR(100),"
    			+ "        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
    	String Symptoms ="CREATE TABLE Symptoms ("
    			+ "       symptom_id INT PRIMARY KEY AUTO_INCREMENT,"
    			+ "       user_id INT,"
    			+ "       date DATE,"
    			+ "       mood VARCHAR(50),"
    			+ "       pain_level INT, "
    			+ "       fatigue_level INT, "
    			+ "       pms_symptoms TEXT, "
    			+ "       FOREIGN KEY (user_id) REFERENCES Users(user_id))";
    	String OvulationFertility ="CREATE TABLE OvulationFertility ("
    			+ "       ovulation_id INT PRIMARY KEY AUTO_INCREMENT,"
    			+ "       user_id INT,"
    			+ "       ovulation_date DATE,"
    			+ "       basal_body_temp DECIMAL(4, 2),"
    			+ "       cervical_mucus VARCHAR(20),"
    			+ "       sexual_activity BOOLEAN, "
    			+ "       FOREIGN KEY (user_id) REFERENCES Users(user_id))";
    	String MedicalHistory ="CREATE TABLE MedicalHistory ("
    			+ "       history_id INT PRIMARY KEY AUTO_INCREMENT,"
    			+ "       user_id INT,"
    			+ "       condition_name VARCHAR(100),"
    			+ "       diagnosis_date DATE,"
    			+ "       family_history BOOLEAN,"
    			+ "       medications TEXT, "
    			+ "       FOREIGN KEY (user_id) REFERENCES Users(user_id))";
    	String HealthMetrics =" CREATE TABLE HealthMetrics (\n"
    			+ "       metric_id INT PRIMARY KEY AUTO_INCREMENT,"
    			+ "       user_id INT,"
    			+ "       date DATE,"
    			+ "       weight DECIMAL(5, 2),"
    			+ "       blood_pressure VARCHAR(7),"
    			+ "       blood_sugar DECIMAL(5, 2),"
    			+ "       FOREIGN KEY (user_id) REFERENCES Users(user_id))";
    	statement.execute(Users);
    	statement.execute(Symptoms);
    	statement.execute(OvulationFertility);
    	statement.execute(MedicalHistory);
    	statement.execute(HealthMetrics);
    				
    }
   

}
