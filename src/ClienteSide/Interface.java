/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteSide;

import Models.Aluno;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author ledunipiaget
 */
public interface Interface extends Remote{
    
    public void Registrar_Aluno(Aluno a) throws RemoteException;
    
    public Aluno Obtem_Aluno(int id) throws RemoteException;
    
    public ArrayList<Aluno> ConsultarAlunos() throws RemoteException;
    
    public boolean existe_Aluno(int id) throws RemoteException;
    
    
    
}
