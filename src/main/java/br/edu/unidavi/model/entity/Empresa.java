package br.edu.unidavi.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Empresa implements Serializable {
    @Id
    @SequenceGenerator(name="empresa_seq",sequenceName="empresa_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="empresa_seq")
    private Long id;
    private String nome;
    private Long documento;
    
    public Long getId() {
   	 return id;
    }
    public void setId(Long id) {
   	 this.id = id;
    }
    public String getNome() {
   	 return nome;
    }
    public void setNome(String nome) {
   	 this.nome = nome;
    }
    public Long getDocumento() {
   	 return documento;
    }
    public void setDocumento(Long documento) {
   	 this.documento = documento;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", documento=" + documento +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
