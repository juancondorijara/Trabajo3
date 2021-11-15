package modelo;

import lombok.Data;

@Data

public class Serializar {
    
    private int IDDEM;
    private String SERDEM;
    private String DESDEM;
    private byte[] BYTDEM;
    
    public Serializar() {
    }

//    public void setBYTDEM(byte[] bytes) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
}
