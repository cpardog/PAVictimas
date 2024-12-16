/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Municipio {

    private String nombre_Municipio;
    private Integer codigo_Departamento;

    public Municipio() {
    }

    public Municipio(String nombre_Municipio, Integer codigo_Departamento) {
        this.nombre_Municipio = nombre_Municipio;
        this.codigo_Departamento = codigo_Departamento;
    }

    public String getNombre_Municipio() {
        return nombre_Municipio;
    }

    public void setNombre_Municipio(String nombre_Municipio) {
        this.nombre_Municipio = nombre_Municipio;
    }


    public Integer getCodigo_Departamento() {
        return codigo_Departamento;
    }

    public void setCodigo_Departamento(Integer codigo_Departamento) {
        this.codigo_Departamento = codigo_Departamento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Municipio{");
        sb.append("nombre_Municipio=").append(nombre_Municipio);
        sb.append(", codigo_Departamento=").append(codigo_Departamento);
        sb.append('}');
        return sb.toString();
    }

   

}
