package Services;

import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MunicipioImpl {

    private static final String SQL_SELECT = "SELECT * FROM municipios";
    private static final String SQL_PORDEPTO = "SELECT nombre_municipio FROM municipios WHERE codigo_departamento = ?";

    public ArrayList<String> selectPorDepto(Integer depto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String municipio = null;
        ArrayList<String> listado = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_PORDEPTO);
            stmt.setInt(1, depto);
            rs = stmt.executeQuery();
            while (rs.next()) {
                municipio = rs.getString("nombre_municipio");
                listado.add(municipio);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return listado;
    }

    /**
     * Procedimiento para obtener los registros agrupados por Mes
     *
     * @return un ArrayList
     */
    /**
     * Procedimiento miembro para insertar una resolución en la base de datos
     *
     * @param resolucion
     * @return Devuelve un número de los registros afectados segun el motor de
     * la base de datos
     */
    /**
     * Procedimiento miembro para Actualizar una resolución en la base de datos
     *
     * @param resol
     * @return Devuelve un número de los registros afectados segun el motor de
     * la base de datos
     */
    /**
     * Procedimiento miembro para eliminar una resolución en la base de datos
     *
     * @param resolucion
     * @return Devuelve un número de los registros afectados segun el motor de
     * la base de datos
     */
    /**
     * Proceimiento para devolver una busqueda basada en cedula
     *
     * @param cadenabuscar __ La CC a Buscar
     * @return Un ArrayList
     */
    /**
     * Obtengo total de la tabla Beneficiarios
     *
     * @return un Entero con el escalar buscado
     */
}
