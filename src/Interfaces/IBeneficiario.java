/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.Beneficiario;
import java.util.ArrayList;

/**
 *
 * @author Carlos Pardo
 */
public interface IBeneficiario {
    int insert(Beneficiario bene);
    int update(Beneficiario bene, String beneanterior);
    int delete(Beneficiario bene);
    int selectcantbene(int numres);
    ArrayList<Beneficiario> selectbene(int num_res);
    ArrayList<Beneficiario> select();
    
}
