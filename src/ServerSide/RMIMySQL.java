/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSide;

import BD.DB_Handler;
import ClienteSide.Interface;
import Models.Aluno;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ledunipiaget
 */
public class RMIMySQL extends UnicastRemoteObject implements Interface{
    private DB_Handler dao;

    public RMIMySQL(DB_Handler dao) throws RemoteException{
        this.dao = dao;
    }
    
    

    
    public void Registrar_Aluno(Aluno a) throws RemoteException {
        
        System.out.println("ServerSide.RMIMySQL.Registrar_Aluno()");
        try {
            
            this.dao.InserirAluno(a);
        } catch (Exception ex) {
            Logger.getLogger(RMIMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public Aluno Obtem_Aluno(int id) throws RemoteException{
        Aluno a=new Aluno();
        try {
            a = this.dao.ObtemAluno(id);
        } catch (Exception ex) {
            Logger.getLogger(RMIMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(a.toString());
        return a;
    }

    
    public ArrayList<Aluno> ConsultarAlunos() throws RemoteException {
        
        ArrayList<Aluno> listaAlunos =new ArrayList<Aluno>();
        
        
        
        try {
                listaAlunos = this.dao.ListaAlunos();
                
        } catch (Exception ex) {
            Logger.getLogger(RMIMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAlunos;
    }

   
    public boolean existe_Aluno(int id) throws RemoteException {
        boolean existe = false;
        try {
            existe = dao.existeAluno(id);
        } catch (Exception ex) {
            Logger.getLogger(RMIMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
}
