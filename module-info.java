module project1 {
    requires java.sql;
    
    requires org.json; // Add this line to include org.json

    exports healthcare_backend;  // Export the application package
}