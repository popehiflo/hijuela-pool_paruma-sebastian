package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger logger= Logger.getLogger(BD.class);

    private static final String SQL_DROP_CREATE_ODONTOLOGO="DROP TABLE IF EXISTS ODONTOLOGO; " +
            "CREATE TABLE ODONTOLOGO (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY, NRO_MATRICULA INT NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)";

    private static final String SQL_PRUEBA="INSERT INTO ODONTOLOGO (NRO_MATRICULA, NOMBRE, APELLIDO) VALUES(123,'Pool','Hijuela'),(456,'Sebastian','Paruma');";

    public static void crearTablas(){
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE_ODONTOLOGO);
            statement.execute(SQL_PRUEBA);
            logger.info("tabla odontologo creada con exito");

        }catch (Exception e){
            logger.warn(e.getMessage());
        }

    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/pool-sebastian","sa","sa");
    }
}
