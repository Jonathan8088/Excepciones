/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * @author Jonathan
 */
@ApplicationException(rollback = false)
public class ValidaExcepcion extends Exception{

    public ValidaExcepcion(String mensaje) {
        super(mensaje);
    }
    
    
    
}
