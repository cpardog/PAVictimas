/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.Resolucion;
import java.util.ArrayList;

/**
 *
 * @author Carlos Pardo
 */
public interface IResolucion {

    int insert(Resolucion resol);

    int update(Resolucion resol, String beneanterior);

    int update(Resolucion resol);

    int delete(Resolucion resol);

    int selectcantresol(int numres);

    Resolucion selectresol(int num_res);

    ArrayList<Resolucion> select();

    ArrayList<Resolucion> buscarPorCedulaPrincipal(String cadenabuscar);

    ArrayList<Resolucion> buscarPorNumeroResolucion(String cadenabuscar);

}
