package Services;

import Modelo.Beneficiario;
import Modelo.Conexion;
import Modelo.Resolucion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interfaces.IResolucion;

public class ResolucionImpl implements IResolucion{

    private static final String SQL_SELECT = "SELECT * FROM resoluciones";
    private static final String SQL_INSERT = "INSERT INTO resoluciones (num_resolucion,cedula_principal,nom_principal,ape_principal,fecha_resolucion,fam_beneficiarias, monto_resolucion, emitida_por,fecha_registro,depto_origen,municipio_origen) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE resoluciones SET num_resolucion=?, cedula_principal=?, nom_principal=?,ape_principal=?,fecha_resolucion=?, fam_beneficiarias=?, monto_resolucion=?, emitida_por=?, fecha_registro=?, depto_origen=?, municipio_origen=? WHERE id_resolucion=?";
    private static final String SQL_DELETE = "DELETE FROM resoluciones WHERE id_resolucion=?";
    private static final String SQL_BUSCAR1 = "SELECT * FROM resoluciones WHERE cedula_principal LIKE  CONCAT('%',?,'%')";
    private static final String SQL_BUSCAR2 = "SELECT * FROM resoluciones WHERE num_resolucion LIKE  CONCAT('%',?,'%')";
    private static final String SQL_SUMFB = "SELECT SUM(fam_beneficiarias) FROM resoluciones";

    /**
     * Procedimiento para obtener listado de todos los registros de la base de
     * datos
     *
     * @return un ArrayList de todos los elementos peristentes de la Base de
     * Datos
     */
    @Override
    public ArrayList<Resolucion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Resolucion resolucion = null;
        ArrayList<Resolucion> resoluciones = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //Identificacion de registro a nivel de base de datos
                // int id_res
                //Datos de Resolucion
                int id_res = rs.getInt("id_resolucion");
                String num_resolucion = rs.getString("num_resolucion");
                String cedula_principal = rs.getString("cedula_principal");
                String nom_principal = rs.getString("nom_principal");
                String ape_principal = rs.getString("ape_principal");
                java.sql.Date f_resol = rs.getDate(String.valueOf("fecha_resolucion"));
                int f_beneficiarias = rs.getInt("fam_beneficiarias");
                Double monto = rs.getDouble("monto_resolucion");
                String emitida_por = rs.getString("emitida_por");
                java.sql.Date f_registro = rs.getDate(String.valueOf("fecha_registro"));
                String deptoOrigen= rs.getString("depto_origen");
                String municipioOrigen= rs.getString("municipio_origen");
                // Las asigna al Objeto
                resolucion = new Resolucion();
                resolucion.setId_resolucion(id_res);
                resolucion.setNum_resolucion(num_resolucion);
                resolucion.setCedula_principal(cedula_principal);
                resolucion.setNom_principal(nom_principal);
                resolucion.setApe_principal(ape_principal);
                resolucion.setFecha_resolucion(f_resol);
                resolucion.setFam_beneficiarias(f_beneficiarias);
                resolucion.setMonto_resolucion(monto);
                resolucion.setEmitida_por(emitida_por);
                resolucion.setFecha_registro(f_registro);
                resolucion.setDepto_origen(deptoOrigen);
                resolucion.setMunicipio_origen(municipioOrigen);
                resoluciones.add(resolucion);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return resoluciones;
    }



    /**
     * Procedimiento miembro para insertar una resolución en la base de datos
     *
     * @param resolucion
     * @return Devuelve un número de los registros afectados segun el motor de
     * la base de datos
     */
    @Override
    public int insert(Resolucion resolucion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);

            //Datos de la resolucion
            stmt.setString(1, resolucion.getNum_resolucion());
            stmt.setString(2, resolucion.getCedula_principal());
            stmt.setString(3, resolucion.getNom_principal());
            stmt.setString(4, resolucion.getApe_principal());
            stmt.setDate(5, (java.sql.Date) resolucion.getFecha_resolucion());
            stmt.setInt(6, resolucion.getFam_beneficiarias());
            stmt.setDouble(7, resolucion.getMonto_resolucion());
            stmt.setString(8, resolucion.getEmitida_por());
            stmt.setDate(9, (java.sql.Date)resolucion.getFecha_registro());
            stmt.setString(10, resolucion.getDepto_origen());
            stmt.setString(11, resolucion.getMunicipio_origen());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "El registro se guardó correctamente");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * Procedimiento miembro para Actualizar una resolución en la base de datos
     *
     * @param resol
     * @return Devuelve un número de los registros afectados segun el motor de
     * la base de datos
     */
    @Override
    public int update(Resolucion resol) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConexion();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            //Datos de la resolución
            stmt.setString(1, resol.getNum_resolucion());
            stmt.setString(2, resol.getCedula_principal());
            stmt.setString(3, resol.getNom_principal());
            stmt.setString(4, resol.getApe_principal());
            stmt.setDate(5, (java.sql.Date) resol.getFecha_resolucion());
            stmt.setInt(6, resol.getFam_beneficiarias());
            stmt.setDouble(7, resol.getMonto_resolucion());
            stmt.setString(8, resol.getEmitida_por());
            stmt.setDate(9, resol.getFecha_registro());
            stmt.setString(10, resol.getDepto_origen());
            stmt.setString(11, resol.getMunicipio_origen());
            stmt.setInt(12, resol.getId_resolucion());
            rows = stmt.executeUpdate();
            System.out.println("Registro actualizado:" + rows);
            JOptionPane.showMessageDialog(null, "Regsitro actualizadó correctamente");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * Procedimiento miembro para eliminar una resolución en la base de datos
     *
     * @param resolucion
     * @return Devuelve un número de los registros afectados segun el motor de
     * la base de datos
     */
    @Override
    public int delete(Resolucion resolucion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConexion();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, resolucion.getId_resolucion());
            rows = stmt.executeUpdate();
            System.out.println("Registro eliminado:" + rows);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * Procedimiento para devolver una busqueda basada en cedula
     *
     * @param cadenabuscar __ La CC a Buscar
     * @return Un ArrayList
     */
    @Override
    public ArrayList<Resolucion> buscarPorCedulaPrincipal(String cadenabuscar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Resolucion resolucion = null;
        ArrayList<Resolucion> resoluciones = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_BUSCAR1);
            stmt.setString(1, cadenabuscar.trim());
            rs = stmt.executeQuery();
            while (rs.next()) {
                //Identificacion de registro a nivel de base de datos
                // int id_res
                //Datos de Resolucion
                int id_res = rs.getInt("id_resolucion");
                String num_resolucion = rs.getString("num_resolucion");
                String cedula_principal = rs.getString("cedula_principal");
                String nom_principal = rs.getString("nom_principal");
                String ape_principal = rs.getString("ape_principal");
                java.sql.Date f_resol = rs.getDate(String.valueOf("fecha_resolucion"));
                int f_beneficiarias = rs.getInt("fam_beneficiarias");
                Double monto = rs.getDouble("monto_resolucion");
                String emitida_por = rs.getString("emitida_por");
                java.sql.Date f_registro = rs.getDate(String.valueOf("fecha_registro"));
                String deptoOrigen = rs.getString("depto_origen");
                String municipioOrigen = rs.getString("municipio_origen");
                // Creo el objeto y las asigna al Objeto
                resolucion = new Resolucion();
                resolucion.setId_resolucion(id_res);
                resolucion.setNum_resolucion(num_resolucion);
                resolucion.setCedula_principal(cedula_principal);
                resolucion.setNom_principal(nom_principal);
                resolucion.setApe_principal(ape_principal);
                resolucion.setFecha_resolucion(f_resol);
                resolucion.setFam_beneficiarias(f_beneficiarias);
                resolucion.setMonto_resolucion(monto);
                resolucion.setEmitida_por(emitida_por);
                resolucion.setFecha_registro(f_registro);
                resolucion.setDepto_origen(deptoOrigen);
                resolucion.setMunicipio_origen(municipioOrigen);
                resoluciones.add(resolucion);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return resoluciones;
    }

    /**
     * Proceimiento para devolver una busqueda basada en Número de Resolución
     *
     * @param cadenabuscar __ La Resolución a Buscar
     * @return Un ArrayList
     */
    @Override
    public ArrayList<Resolucion> buscarPorNumeroResolucion(String cadenabuscar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Resolucion resolucion = null;
        ArrayList<Resolucion> resoluciones = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_BUSCAR2);
            stmt.setString(1, cadenabuscar.trim());
            rs = stmt.executeQuery();
            while (rs.next()) {
                //Identificacion de registro a nivel de base de datos
                // int id_res
                //Datos de Resolucion
                int id_res = rs.getInt("id_resolucion");
                String num_resolucion = rs.getString("num_resolucion");
                String cedula_principal = rs.getString("cedula_principal");
                String nom_principal = rs.getString("nom_principal");
                String ape_principal = rs.getString("ape_principal");
                java.sql.Date f_resol = rs.getDate(String.valueOf("fecha_resolucion"));
                int f_beneficiarias = rs.getInt("fam_beneficiarias");
                Double monto = rs.getDouble("monto_resolucion");
                String emitida_por = rs.getString("emitida_por");
                java.sql.Date f_registro = rs.getDate(String.valueOf("fecha_registro"));
                String deptoOrigen = rs.getString("depto_origen");
                String municipioOrigen = rs.getString("municipio_origen");
                // Creo el objeto y las asigna al Objeto
                resolucion = new Resolucion();
                resolucion.setId_resolucion(id_res);
                resolucion.setNum_resolucion(num_resolucion);
                resolucion.setCedula_principal(cedula_principal);
                resolucion.setNom_principal(nom_principal);
                resolucion.setApe_principal(ape_principal);
                resolucion.setFecha_resolucion(f_resol);
                resolucion.setFam_beneficiarias(f_beneficiarias);
                resolucion.setMonto_resolucion(monto);
                resolucion.setEmitida_por(emitida_por);
                resolucion.setFecha_registro(f_registro);
                resolucion.setDepto_origen(deptoOrigen);
                resolucion.setMunicipio_origen(municipioOrigen);
                resoluciones.add(resolucion);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return resoluciones;
    }

    /**
     * Obtengo total de la tabla Beneficiarios
     *
     * @return un Entero con el escalar buscado
     */
    public int selectcantbene() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Beneficiario bene = null;
        int qres = 0;
        try {
            conn = Conexion.getConexion();
            ps = conn.prepareStatement(SQL_SUMFB);
            rs = ps.executeQuery();
            rs.next();
            qres = rs.getInt(1);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return qres;
    }

    @Override
    public int update(Resolucion resol, String beneanterior) {
        return 0;
    }

    @Override
    public int selectcantresol(int numres) {
        return 0;
    }

    @Override
    public Resolucion selectresol(int num_res) {
        return null;
    }
}
