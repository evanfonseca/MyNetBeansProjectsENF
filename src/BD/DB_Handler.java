/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Models.Aluno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ledunipiaget
 */
public class DB_Handler {
    
    private Connection con = null;
    private String server,porta,database,user,pass;
    
    public DB_Handler(String sv, String pt,String db,String u,String ps) throws SQLException, Exception{
        this.server=sv;
        this.porta=pt;
        this.database=db;
        this.user=u;
        this.pass=ps;
        
        
    }
    
    public Connection getConnection() throws Exception{
        
        String link="jdbc:mysql://"+this.server+":"+this.porta+"/"+this.database;
        Connection connect = null;
        try 
            {  
                Class.forName("com.mysql.jdbc.Driver");
                this.con=DriverManager.getConnection(link,this.user,this.pass);
            
            } catch (Exception e) {
                        throw e;
                        
            } 
        return this.con;
    }
   


    public void InserirAluno(Aluno a) throws Exception{
        this.getConnection();
        
        String sql = "INSERT INTO alunos(Nome, Morada, Curso,Telefone)VALUES(?,?,?,?)";
        PreparedStatement statement = this.con.prepareStatement(sql);
        statement.setString(1,a.getNome());
        statement.setString(2,a.getMorada());
        statement.setString(3, a.getCurso());
        statement.setInt(4, a.getTelefone());
        statement.executeUpdate();
        
        this.con.close();

    }
    
    public boolean existeAluno(int id) throws Exception{
        this.getConnection();
        boolean existe=false;
        
        String query = "SELECT * FROM alunos where Id="+id;
        
        Statement st = this.con.createStatement();
  
      ResultSet rs = st.executeQuery(query);
      
      if(rs.next()){
          existe=true;
      }
        this.con.close(); 
        return existe;
    }
    
    public Aluno ObtemAluno(int id) throws Exception{
        this.getConnection();
        Aluno a=null;
        
        String query = "SELECT * FROM alunos where Id="+id;
        
        Statement st = this.con.createStatement();
  
        ResultSet rs = st.executeQuery(query);
        
        int idAluno=0;
        String Nome = "";
        String Morada = "";
        String Curso = "";
        int Telefone = 0;
         
        if (rs.next())
        {
            idAluno = rs.getInt("Id");
            Nome = rs.getString("Nome");
            Morada = rs.getString("Morada");
            Curso = rs.getString("Curso");
            Telefone = rs.getInt("Telefone");
        }
        a=new Aluno(idAluno, Nome, Curso, Morada, Telefone);
        
        this.con.close(); 
        return a;
    }

    public ArrayList<Aluno> ListaAlunos() throws SQLException, Exception{
        
        this.getConnection();

        
        Statement stmt=this.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from alunos");  

        Aluno a;
        int id = 0,tel;
        String nome, morada,curso;
        ArrayList<Aluno> listaAlunos=new ArrayList();
        while(rs.next()) {
            
            id = rs.getInt("Id");
            nome = rs.getString("Nome");
            morada = rs.getString("Morada");
            curso = rs.getString("Curso");
            tel = rs.getInt("Telefone");
            a = new Aluno(id, nome, curso, morada, tel);
            listaAlunos.add(a);    
        } 




        this.con.close();  
        
        
        return listaAlunos;

    }
}