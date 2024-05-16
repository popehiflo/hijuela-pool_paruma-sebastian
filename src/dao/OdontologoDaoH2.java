package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements iDao<Odontologo> {

    private static final Logger logger= Logger.getLogger(OdontologoDaoH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGO (NRO_MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";
    private static final String SQL_SELECT="SELECT * FROM ODONTOLOGO";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("inicando la operacion de guardado");
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1, odontologo.getNroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute(); //CUANDO SE EJECUTE SE VAN A GENERAR ID
            ResultSet rs= psInsert.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }


        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("inicando la operacion de listado");
        Connection connection=null;
        List<Odontologo> lista = new ArrayList<>();
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_SELECT);

            psInsert.execute(); //CUANDO SE EJECUTE SE VAN A GENERAR ID
            ResultSet rs= psInsert.executeQuery();
            while (rs.next()){
                Odontologo odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setNroMatricula(rs.getInt(2));
                odontologo.setNombre(rs.getString(3));
                odontologo.setApellido(rs.getString(4));
                lista.add(odontologo);
            }
            logger.info(lista);


        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return lista;
    }
}
