package services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import modelo.Serializar;

public class SerializarS {

    public static void main(String[] args) throws Exception {
        String SERDEM = "password";
        String securePassword = securePassword_SHA_1(SERDEM);
        System.out.println(securePassword);
        securePassword = securePassword_SHA_256(SERDEM);
        System.out.println(securePassword);
        securePassword = securePassword_SHA_512(SERDEM);
        System.out.println(securePassword);

//        Serializar serializar = new Serializar();
//        serializar.setSERDEM("Prueba");
//        SerializarS.serializa(serializar);
//        serializar.setDESDEM("[B@15db9742");
//        SerializarS.deserializa(serializar);
    }
    
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
    
    public static String securePassword_MD5(String SERDEM) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(SERDEM.getBytes());
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
    
    public static String securePassword_SHA_1(String SERDEM) {
        Serializar serializar = new Serializar();
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(SERDEM.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
            serializar.setDESDEM(generatedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public static String securePassword_SHA_256(String SERDEM) {
        Serializar serializar = new Serializar();
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(SERDEM.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
            serializar.setDESDEM(generatedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public static String securePassword_SHA_512(String SERDEM) {
        Serializar serializar = new Serializar();
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(SERDEM.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
            serializar.setDESDEM(generatedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
}
