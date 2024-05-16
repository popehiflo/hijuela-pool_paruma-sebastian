package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoNoBD implements iDao<Odontologo> {

    private static final Logger logger= Logger.getLogger(OdontologoDaoNoBD.class);
    private List<Odontologo> listaNoPersistente = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        listaNoPersistente.add(odontologo);
        logger.info("Guardado no persistente" + odontologo);
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
        logger.info("listado no persistente" + listaNoPersistente);
        return listaNoPersistente;
    }
}
