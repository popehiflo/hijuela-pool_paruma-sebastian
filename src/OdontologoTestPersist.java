import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

public class OdontologoTestPersist {

    @Test
    public void listarTodos() {
        BD.crearTablas();
        Odontologo odontologo = new Odontologo(789, "Odontologo","Dental");
        OdontologoService odService = new OdontologoService();
        odService.guardarOdontologo(odontologo);
        odService.listarTodos().toString();
        Assertions.assertEquals(3, odService.listarTodos().size());
    }
}
