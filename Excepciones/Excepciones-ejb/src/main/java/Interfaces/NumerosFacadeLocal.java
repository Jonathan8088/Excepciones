/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Numeros;
import Entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jonathan
 */
@Local
public interface NumerosFacadeLocal {

    void create(Numeros numeros);

    void edit(Numeros numeros);

    void remove(Numeros numeros);

    Numeros find(Object id);

    List<Numeros> findAll();

    List<Numeros> findRange(int[] range);

    int count();
    
    void numerosAleatorios();
    
    void numerosAleatoriosR();
    
    void numerosAleatoriosSR();
    
}
