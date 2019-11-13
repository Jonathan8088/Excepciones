/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entity.Usuario;
import Excepciones.LengthExcepcion;
import Excepciones.ValidaExcepcion;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Logica {

    public void businessMethod() {
    }
    
    
    public void guadaJCR(Usuario usuario, String confirma){
        try {
            
            validarContraseña(usuario.getContrasena(), confirma);
        } catch (ValidaExcepcion e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void validarContraseña(String contrasena, String confirma) throws ValidaExcepcion{
        if(!contrasena.equals(confirma)){
            throw new ValidaExcepcion("Las contraseñas no coinciden");
        }
    }
    
    public void largoContraseña(String contrasena) throws LengthExcepcion{
        if(contrasena.length()>10){
            throw new LengthExcepcion("La contraseña es demasiado larga");
        }
    }

    

}
