package controlador;

import services.SerializarS;
import modelo.Serializar;
import dao.SerializarImpl;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;

@Data

//Notación CDI
@Named(value = "serializarC")
//@Dependent
@SessionScoped
public class SerializarC implements Serializable {

    private Serializar serializar;
    private SerializarImpl dao;

    public SerializarC() {
        serializar = new Serializar();
        dao = new SerializarImpl();
    }
    
    public void registrar() throws Exception {
        try {
            dao.registrar(serializar);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registrado con Éxito"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Al Registrar"));
            System.out.println("Error en serializa_C " + ex.getMessage());
        }
    }
    
    public void limpiar() {
        serializar = new Serializar();
    }
    
    public void serializa() throws Exception {
        try {
            SerializarS.serializa(serializar);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Serializado con Éxito"));
        } catch (Exception ex) {
            System.out.println("Error en serializa_C " + ex.getMessage());
        }
    }
    
    public void deserializa() throws Exception {
        try {
            SerializarS.deserializa(serializar);
//            serializar.setDESDEM(serializar.getDESDEM());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Serializado con Éxito"));
        } catch (Exception ex) {
            System.out.println("Error en deserializa_C " + ex.getMessage());
        }
    }
    
    public void securePassword_MD5() throws Exception {
        try {
            String SERDEM = serializar.getSERDEM();
            serializar.setDESDEM(SerializarS.securePassword_MD5(SERDEM));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Serializado con Éxito"));
        } catch (Exception ex) {
            System.out.println("Error en securePassword_MD5_C " + ex.getMessage());
        }
    }
    
    public void securePassword_SHA_1() throws Exception {
        try {
            String SERDEM = serializar.getSERDEM();
            serializar.setDESDEM(SerializarS.securePassword_SHA_1(SERDEM));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Serializado con Éxito"));
        } catch (Exception ex) {
            System.out.println("Error en securePassword_SHA_1_C " + ex.getMessage());
        }
    }
    
    public void securePassword_SHA_256() throws Exception {
        try {
            String SERDEM = serializar.getSERDEM();
            serializar.setDESDEM(SerializarS.securePassword_SHA_256(SERDEM));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Serializado con Éxito"));
        } catch (Exception ex) {
            System.out.println("Error en securePassword_SHA_256_C " + ex.getMessage());
        }
    }
    
    public void securePassword_SHA_512() throws Exception {
        try {
            String SERDEM = serializar.getSERDEM();
            serializar.setDESDEM(SerializarS.securePassword_SHA_512(SERDEM));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Serializado con Éxito"));
        } catch (Exception ex) {
            System.out.println("Error en securePassword_SHA_512_C " + ex.getMessage());
        }
    }
    
}
