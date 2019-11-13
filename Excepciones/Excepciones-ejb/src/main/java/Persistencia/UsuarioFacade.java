/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entity.Usuario;
import Excepciones.LengthExcepcion;
import Excepciones.ValidaExcepcion;
import Interfaces.AbstractFacade;
import Interfaces.NumerosFacadeLocal;
import Interfaces.UsuarioFacadeLocal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jonathan
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_Excepciones-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @EJB
    NumerosFacadeLocal numeroLocal;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void guadaPSR(Usuario usuario, String confirma) {
        try {
            em.persist(usuario);
            validarContraseña(usuario.getContrasena(), confirma);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void validarContraseña(String contrasena, String confirma) throws ValidaExcepcion {
        if (!contrasena.equals(confirma)) {
            throw new ValidaExcepcion("Las contraseñas no coinciden");
        }
    }

    public void largoContraseña(String contrasena) throws LengthExcepcion {
        if (contrasena.length() > 10) {
            throw new LengthExcepcion("La contraseña es demasiado larga");
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void guadaPCR(Usuario usuario, String confirma) {
       
            em.persist(usuario);
            numeroLocal.numerosAleatorios();
            largoContraseña(usuario.getContrasena());
            

    }

    @Override
    public void guardaJCR(Usuario usuario, String confirma) {
        em.persist(usuario);
        numeroLocal.numerosAleatoriosR();
    }

    @Override
    public void guardaJSR(Usuario usuario, String confirma) {
        em.persist(usuario);
        numeroLocal.numerosAleatoriosSR();
    }

}
