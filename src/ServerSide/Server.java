/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSide;

import BD.DB_Handler;
import Models.Aluno;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ledunipiaget
 */
public class Server {
    
    
     public static void main(String[] args) throws SQLException, Exception {
        DB_Handler db= new DB_Handler("localhost", "3306", "mydb", "mydb_U", "mydb_P");
        
        try{
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            r.rebind("myRMIMySQL", new RMIMySQL(db));
            System.out.println("Servidor Conectado....");
            /*
            if(db.existeAluno(1))
                            {
                                Aluno a=db.ObtemAluno(1);
                                System.out.println(a.toString());
                            }
                        else 
                            {
                                System.out.println("Não existe aluno com este Id!");
                            }
            */
            
        }catch (RemoteException e){
            System.out.println("Servidor Não Conectado.");
        }
        
        
        /*
        ArrayList<Aluno> l =db.ListaAlunos();
        
        for(Aluno a: l){
            System.out.println(a.toString());
        }
        */
        
    }
    
}
