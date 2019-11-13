/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entity.Numeros;
import Entity.Usuario;
import Interfaces.AbstractFacade;
import Interfaces.NumerosFacadeLocal;
import Interfaces.UsuarioFacadeLocal;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class NumerosFacade extends AbstractFacade<Numeros> implements NumerosFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_Excepciones-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    UsuarioFacadeLocal usuarioLocal;
    
    ArrayList<Numeros> lista = null;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NumerosFacade() {
        super(Numeros.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void numerosAleatorios() {
        Numeros numero = new Numeros();
        Random r = new Random();
        int num = r.nextInt(6)+1;
        numero.setNumero(num);
        em.persist(numero);

    }

    @Override
    public void numerosAleatoriosR() {
        Numeros numero = new Numeros();
        Random r = new Random();
        int num = r.nextInt(6)+1;
        numero.setNumero(num);
        em.persist(numero);
        lista.add(numero);
    }

    @Override
    public void numerosAleatoriosSR() {
        FileReader fr = null;
        try {
            Numeros numero = new Numeros();
            Random r = new Random();
            int num = r.nextInt(6)+1;
            numero.setNumero(num);
            em.persist(numero);
            fr = new FileReader("casa");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
