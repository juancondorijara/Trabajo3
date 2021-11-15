package dao;

import java.sql.PreparedStatement;
import java.util.List;
import modelo.Serializar;

public class SerializarImpl extends Conexion implements ICRUD<Serializar> {
    
    @Override
    public void registrar(Serializar serializar) throws Exception {
        String sql = "insert into DEMO (SERDEM, DESDEM) values (?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, serializar.getSERDEM());
            ps.setString(2, serializar.getDESDEM());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en RegistrarD " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Serializar obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEstado(Serializar obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restaurarEstado(Serializar obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Serializar> listarTodos(int tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
    
}
