/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import Interfaces.IBeneficiario;

/**
 * Se modelo Beneficiarios de una AHI de la manera más básica A que resolución
 * pertenece un id (CC), Nombre y Apellido
 *
 * @author Admin
 */
public class Beneficiario  implements IBeneficiario{

    private int resolucion_id;
    private String tipo_documento;
    private String id_beneficiario;
    private String nombre_beneficiario;
    private String apellido_beneficiario;

    public Beneficiario() {
    }

    public Beneficiario(int resolucion_id, String tipo_documento, String id_beneficiario, String nombre_beneficiario, String apellido_beneficiario) {
        this.resolucion_id = resolucion_id;
        this.tipo_documento = tipo_documento;
        this.id_beneficiario = id_beneficiario;
        this.nombre_beneficiario = nombre_beneficiario;
        this.apellido_beneficiario = apellido_beneficiario;
    }


    public int getResolucion_id() {
        return resolucion_id;
    }

    public void setResolucion_id(int resolucion_id) {
        this.resolucion_id = resolucion_id;
    }

    public String getId_beneficiario() {
        return id_beneficiario;
    }

    public void setId_beneficiario(String id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }

    public String getNombre_beneficiario() {
        return nombre_beneficiario;
    }

    public void setNombre_beneficiario(String nombre_beneficiario) {
        this.nombre_beneficiario = nombre_beneficiario;
    }

    public String getApellido_beneficiario() {
        return apellido_beneficiario;
    }

    public void setApellido_beneficiario(String apellido_beneficiario) {
        this.apellido_beneficiario = apellido_beneficiario;
    }


    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    @Override
    public String toString() {
        return "Beneficiario{" + "resolucion_id=" + resolucion_id + ", tipo_documento=" + tipo_documento + ", id_beneficiario=" + id_beneficiario + ", nombre_beneficiario=" + nombre_beneficiario + ", apellido_beneficiario=" + apellido_beneficiario + '}';
    }

    @Override
    public int insert(Beneficiario bene) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Beneficiario bene, String beneanterior) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Beneficiario bene) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int selectcantbene(int numres) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Beneficiario> selectbene(int num_res) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Beneficiario> select() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
