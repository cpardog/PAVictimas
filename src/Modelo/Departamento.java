/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Departamento {
    private String nombre_Departamento;
    private Short codigo_Departamento;

    public Departamento() {
    }

    public Departamento(String nombre_Departamento, Short codigo_Departamento) {
        this.nombre_Departamento = nombre_Departamento;
        this.codigo_Departamento = codigo_Departamento;
    }

    public String getNombre_Departamento() {
        return nombre_Departamento;
    }

    public void setNombre_Departamento(String nombre_Departamento) {
        this.nombre_Departamento = nombre_Departamento;
    }

    public Short getCodigo_Departamento() {
        return codigo_Departamento;
    }

    public void setCodigo_Departamento(Short codigo_Departamento) {
        this.codigo_Departamento = codigo_Departamento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Depto{");
        sb.append("nombre_Departamento=").append(nombre_Departamento);
        sb.append(", codigo_Departamento=").append(codigo_Departamento);
        sb.append('}');
        return sb.toString();
    }
    
}
