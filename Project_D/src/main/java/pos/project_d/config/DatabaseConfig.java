package pos.project_d.config;

import java.util.Base64;

public class DatabaseConfig {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/naughtylistnisara";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "SEFIQWdvYXRtaWxrMTIzIQ==";
    
    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getDbUser () {
        return DB_USER;
    }

    public static String getDbPass() {
        return new String (Base64.getDecoder().decode(DB_PASS));
    }
}