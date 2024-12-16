/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Interfaces.IResumen;
import Modelo.Conexion;
import Modelo.Resolucion;
import Modelo.Resumen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Pardo
 */
public class ResumenImpl implements IResumen {

    private static final String SQL_POR_FECHA = "SELECT fecha_resolucion, count(*) as cantidad, month(fecha_resolucion) as mes, sum(monto_resolucion) as Total, sum(fam_beneficiarias) as TotalBenef from resoluciones group by fecha_resolucion  order by fecha_resolucion";
    private static final String SQL_POR_MES = "SELECT month(fecha_resolucion) as mes, year(fecha_resolucion) as vigencia,  count(*)  as cantidad, sum(monto_resolucion) as Total from resoluciones  group by mes,vigencia order by vigencia,mes";

    /**
     * Procedimiento para obtener los registros agrupados por fecha
     *
     * @return un ArrayList
     */
    @Override
    public ArrayList<Resumen> selectPorFecha() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Resolucion resolucion = null;
        ArrayList<Resumen> resumenes = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_POR_FECHA);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String f_resol = rs.getString(String.valueOf("fecha_resolucion"));
                String cantidad = rs.getString("cantidad");
                String mes = rs.getString("mes");
                String total_monto = rs.getString("Total");
                String total_Benef = rs.getString("TotalBenef");
                Resumen resumen = new Resumen();
                resumen.setCampo1(f_resol);
                resumen.setCampo2(cantidad);
                resumen.setCampo3(mes);
                resumen.setCampo4(total_monto);
                resumen.setCampo5(total_Benef);
                resumenes.add(resumen);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return resumenes;
    }

    /**
     * Procedimiento para obtener los registros agrupados por Mes
     *
     * @return un ArrayList
     */
    @Override
    public ArrayList<Resumen> selectPorMes() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Resolucion resolucion = null;
        ArrayList<Resumen> resumenes = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_POR_MES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String fecha = rs.getString(String.valueOf("mes"));
                String vigencia = rs.getString("vigencia");
                String cantidad = rs.getString("cantidad");
                String total_monto = rs.getString("Total");
                Resumen resumen = new Resumen();
                resumen.setCampo1(fecha);
                resumen.setCampo2(vigencia);
                resumen.setCampo3(cantidad);
                resumen.setCampo4(total_monto);
                resumenes.add(resumen);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return resumenes;
    }
}
