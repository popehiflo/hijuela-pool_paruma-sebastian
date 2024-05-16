import dao.BD;
import model.Odontologo;
import service.OdontologoService;

public class OdontologoEjemplo {

    public static void main(String[] args) {
        BD.crearTablas();
        Odontologo odontologo = new Odontologo(789, "Odontologo","Dental");
        OdontologoService odService = new OdontologoService();
        odService.guardarOdontologo(odontologo);
        odService.listarTodos().toString();
    }
}
