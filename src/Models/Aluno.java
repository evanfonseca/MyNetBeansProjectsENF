package Models;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ledunipiaget
 */
public class Aluno implements Serializable{
    
    private int id;
    private String Nome, Curso, Morada;
    private int telefone;

    public Aluno(int id, String Nome, String Curso, String Morada, int telefone) {
        this.id = id;
        this.Nome = Nome;
        this.Curso = Curso;
        this.Morada = Morada;
        this.telefone = telefone;
    }

    public Aluno() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getMorada() {
        return Morada;
    }

    public void setMorada(String Morada) {
        this.Morada = Morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", Nome=" + Nome + ", Curso=" + Curso + ", Morada=" + Morada + ", telefone=" + telefone + '}';
    }
    
    
    
    
}
