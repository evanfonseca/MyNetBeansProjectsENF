/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteSide;

import Models.Aluno;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ledunipiaget
 */
public class Cliente {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        

        int op=0,telefone;
        String nome,curso,morada;
        ArrayList<Aluno> l= new ArrayList<>();
        
        while(op!=4){
                
                System.out.println("============================");
                System.out.println("Escolhe uma Opção");
                System.out.println("1 - Registrar Aluno");
                System.out.println("2 - Procurar Aluno");
                System.out.println("3 - Consultar Alunos");
                System.out.println("4 - Sair");
                op = s.nextInt();
      
               try {
                Interface i = (Interface) Naming.lookup("//localhost/myRMIMySQL");

                
                switch(op)
                {
                    case 1:
                    {   
                        Aluno a= new Aluno();
                        System.out.println("Introduza o nome");
                        nome=s.next();
                        a.setNome(nome);
                        System.out.println("Introduza a morada");
                        morada=s.next();
                        a.setMorada(morada);
                        System.out.println("Introduza o curso");
                        curso=s.next();
                        a.setCurso(curso);
                        System.out.println("Introduza o telefone");
                        telefone=s.nextInt();
                        a.setTelefone(telefone);
                        
                        i.Registrar_Aluno(a);
                        
                        break;
                    }

                    case 2:
                    {   
                        System.out.println("Introduza o Id do aluno");
                        int id=s.nextInt();
                        
                        if(i.existe_Aluno(id))
                            {   
                                Aluno a=i.Obtem_Aluno(id);
                                System.out.println(a.toString());
                            }
                        else 
                            {
                                System.out.println("Não existe aluno com este Id!");
                            }
                            
                        break;
                    }

                    case 3:
                    {

                            l =i.ConsultarAlunos();
        
                            for(Aluno a: l){
                                System.out.println(a.toString());
                            }
                        break;
                    }

                    default: break;
                }

            } catch (Exception e) {
            }
                
        }
                
    }
    
}
