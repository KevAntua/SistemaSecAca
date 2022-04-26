package mx.ipn.upiicsa.udi.scasa.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        //var password = "SA49MVJ2021";
        //var password = "SA01JVD2021";
        //var password = "SA10ÁHE2021";
        //var password = "SA07CFH2021";
        var password = "SA03TCF2021";
        System.out.println("password = " + password);
        System.out.println("password encriptado = " + encriptarPassword(password));
        
    }
    
    public static String encriptarPassword(String password){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.encode(password);
    }
    
}
