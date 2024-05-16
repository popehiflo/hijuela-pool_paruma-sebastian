package service;

import dao.OdontologoDaoH2;
import dao.iDao;
import model.Odontologo;

import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoDao;

    public OdontologoService() {
        this.odontologoDao = new OdontologoDaoH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return odontologoDao.listarTodos();
    }
}
