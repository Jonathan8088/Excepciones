/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import Entity.Usuario;
import Interfaces.NumerosFacadeLocal;
import Interfaces.UsuarioFacadeLocal;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Jonathan
 */
@Named(value = "logica")
@SessionScoped
public class Operaciones implements Serializable{


    @EJB
    UsuarioFacadeLocal usuarioLocal;
    
    @EJB
    NumerosFacadeLocal numeroLocal;
    
    Cliente cliente;
    
    Usuario usuario;
    
    String confirmaContrasena;

    public Operaciones() {
        cliente = new Cliente();
        usuario = new Usuario();
    }
    
    public void ExcepcionJavaSR(Cliente cli, String confirma){
        usuario.setUsuario(cli.getUsuario());
        usuario.setContrasena(cli.getContrasena());
        usuarioLocal.guardaJSR(usuario, confirma);
    }
    
    public void ExcepcionJavaCR(Cliente cli, String confirma){
        usuario.setUsuario(cli.getUsuario());
        usuario.setContrasena(cli.getContrasena());
        usuarioLocal.guardaJCR(usuario, confirma);
    }
    
    public void ExcepcionPersonalizadaSR(Cliente cli, String confirma){
        usuario.setUsuario(cli.getUsuario());
        usuario.setContrasena(cli.getContrasena());
        usuarioLocal.guadaPSR(usuario, confirma);
    }
    
    public void ExcepcionPersonalizadaCR(Cliente cli, String confirma){
        usuario.setUsuario(cli.getUsuario());
        usuario.setContrasena(cli.getContrasena());
        usuarioLocal.guadaPCR(usuario, confirma);
        
        
    }

    public UsuarioFacadeLocal getUsuarioLocal() {
        return usuarioLocal;
    }

    public void setUsuarioLocal(UsuarioFacadeLocal usuarioLocal) {
        this.usuarioLocal = usuarioLocal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmaContrasena() {
        return confirmaContrasena;
    }

    public void setConfirmaContrasena(String confirmaContrasena) {
        this.confirmaContrasena = confirmaContrasena;
    }

    public NumerosFacadeLocal getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(NumerosFacadeLocal numeroLocal) {
        this.numeroLocal = numeroLocal;
    }
    
    
    
    
}
