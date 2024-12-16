package Modelo;

/**
 *
 * @author Admin
 */
public class Resumen {

    private String campo1; //Fechas
    private String campo2; // Q Resoluciones
    private String campo3; // Mes
    private String campo4; // Total Montos
    private String campo5; // Total Beneficiarios

    public Resumen() {
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }
//    public ArrayList<Resumen> selectPorFecha() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Resolucion resolucion = null;
//        ArrayList<Resumen> resumenes = new ArrayList<>();
//
//        try {
//            conn = Conexion.getConexion();
//            stmt = conn.prepareStatement(SQL_POR_FECHA);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                //Datos Resumen
////                int id_res = rs.getInt("id_resolucion");
////                String num_resolucion = rs.getString("num_resolucion");
//                String f_resol = rs.getString(String.valueOf("fecha_resolucion"));
//                String cantidad = rs.getString("cantidad");
//                String mes = rs.getString("mes");
//                String total_monto = rs.getString("Total");
////                String emitida_por = rs.getString("emitida_por");
////                java.sql.Date f_registro = rs.getDate(String.valueOf("fecha_registro"));
//                // Las asigna al Objeto Resumen
//                Resumen resumen = new Resumen();
////                resolucion.setId_resolucion(id_res);
////                resolucion.setNum_resolucion(num_resolucion);
//                resumen.setCampo1(mes);
//                resumen.setCampo2(cantidad);
//                resumen.setCampo3(mes);
//                resumen.setCampo4(total_monto);
////                resolucion.setEmitida_por(emitida_por);
////                resolucion.setFecha_registro(f_registro);
//                resumenes.add(resumen);
//            }
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return resumenes;
//    }
//
//    public ArrayList<Resumen> selectPorMes() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Resolucion resolucion = null;
//        ArrayList<Resumen> resumenes = new ArrayList<>();
//
//        try {
//            conn = Conexion.getConexion();
//            stmt = conn.prepareStatement(SQL_POR_MES);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                //Datos Resumen
////                int id_res = rs.getInt("id_resolucion");
////                String num_resolucion = rs.getString("num_resolucion");
//                String fecha = rs.getString(String.valueOf("mes"));
//                String vigencia = rs.getString("vigencia");
//                String cantidad = rs.getString("cantidad");
//                String total_monto = rs.getString("Total");
////                String emitida_por = rs.getString("emitida_por");
////                java.sql.Date f_registro = rs.getDate(String.valueOf("fecha_registro"));
//                // Las asigna al Objeto Resumen
//                Resumen resumen = new Resumen();
////                resolucion.setId_resolucion(id_res);
////                resolucion.setNum_resolucion(num_resolucion);
//                resumen.setCampo1(fecha);
//                resumen.setCampo2(vigencia);
//                resumen.setCampo3(cantidad);
//                resumen.setCampo4(total_monto);
////                resolucion.setEmitida_por(emitida_por);
////                resolucion.setFecha_registro(f_registro);
//                resumenes.add(resumen);
//            }
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return resumenes;
//    }

}
