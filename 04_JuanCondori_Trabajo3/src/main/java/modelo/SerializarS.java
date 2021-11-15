package modelo;

import services.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;
import modelo.Serializar;

public class SerializarS {

    public static void main(String[] args) throws Exception {
        Serializar serializar = new Serializar();
//        serializar.setSERDEM("Prueba");
//        SerializarS.serializa(serializar);
        serializar.setDESDEM("[B@15db9742");
        SerializarS.deserializa(serializar);
        
//        byte[] bytes = DatatypeConverter.parseBase64Binary("e64b78fc3bc91bcbc7dc232ba8ec59e0");
//        byte[] bytes = Base64.getDecoder().decode("e64b78fc3bc91bcbc7dc232ba8ec59e0");
//        System.out.println(bytes);
//        System.out.println("e64b78fc3bc91bcbc7dc232ba8ec59e0");

//        String input = serializar("Prueba");
//        System.out.println(input);

//        String str = "Prueba";
//        byte[] bytes = str.getBytes();
//        System.out.println(str.getBytes());
//        str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
//        System.out.println(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
//        byte[] bytes = {};
//        String str = new String(bytes, java.nio.charset.StandardCharsets.UTF_8);
//        System.out.println(str);

// TODO Auto-generated method stub
//        String msg = "Hola";
//        byte[] buff = new byte[1024];
//        buff = msg.getBytes("UTF-8");
//        System.out.println(buff);
//        String m = new String(buff);
//        System.out.println(m);
    }
    
//    public static void serializa(String input) throws Exception {
//        try {
//            byte[] bytes = new byte[1024];
//            bytes = input.getBytes("UTF-8");
//            System.out.println(bytes);
//        } catch (Exception ex) {
//            System.out.println("Error en serializa_S " + ex.getMessage());
//        }
//    }
//    
//    public static void deserializa(String output) throws Exception {
//        try {
//            Serializar serializar = new Serializar();
//            String input ;
//            byte[] bytes = new byte[1024];
//            bytes = input.getBytes("UTF-8");
//            output = new String(bytes);
//            System.out.println(output);
//        } catch (Exception ex) {
//            System.out.println("Error en deserializa_S " + ex.getMessage());
//        }
//    }
    
    public static void serializa(Serializar serializar) throws Exception {
        try {
            String input = serializar.getSERDEM();
            byte[] bytes = new byte[1024];
            bytes = input.getBytes("UTF-8");
            serializar.setBYTDEM(bytes);
            System.out.println(bytes);
        } catch (Exception ex) {
            System.out.println("Error en serializa_S " + ex.getMessage());
        }
    }
    
    public static void deserializa(Serializar serializar) throws Exception {
        try {
            String input = serializar.getSERDEM();
            byte[] bytes = new byte[1024];
            bytes = input.getBytes("UTF-8");
            String output = serializar.getDESDEM();
            output = new String(bytes);
            serializar.setSERDEM(new String(bytes));
            System.out.println(serializar.getSERDEM());
            System.out.println(output);
        } catch (Exception ex) {
            System.out.println("Error en deserializa_S " + ex.getMessage());
        }
    }
    
    public static String serialization(String input) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            //Now we need to zero pad it if you actually want the full 32 chars
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
