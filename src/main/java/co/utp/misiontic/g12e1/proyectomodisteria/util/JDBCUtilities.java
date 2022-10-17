package co.utp.misiontic.g12e1.proyectomodisteria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    //BD PENDIENTE
    private static final String UBICACION_BD="";

    public static Connection getConnection() throws SQLException {
        String url ="jdbc:mysql:"+ UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}
