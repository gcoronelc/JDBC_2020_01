package sistemas.uni.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.uni.db.AccesoDB;
import sistemas.uni.model.Alumno;
import sistemas.uni.services.AlumnoService;

public class AlumnoServiceImpl implements AlumnoService {

    @Override
    public String insertar(Alumno bean) {
        String mensaje = null;
        Connection cn = null;
        String sql = "insert into ALUMNO(ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,ALUM_FEC,ALUM_DIR,ALUM_TEL,ALUM_COR) VALUES(?,?,?,?,?,?,?,?)";
        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdalumno());
            pstm.setString(2, bean.getDni());
            pstm.setString(3, bean.getNombre());
            pstm.setString(4, bean.getApellido());
            pstm.setString(5, bean.getFecha());
            pstm.setString(6, bean.getDireccion());
            pstm.setString(7, bean.getTelefono());
            pstm.setString(8, bean.getCorreo());
            pstm.executeQuery();
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Alumno bean) {
        String mensaje = null;

        String sql = "update ALUMNO set ALUM_ID=?,\n"
                + "ALUM_DNI=?,\n"
                + "ALUM_NOM=?,\n"
                + "ALUM_APE=?,\n"
                + "ALUM_FEC=?,\n"
                + "ALUM_DIR=?,\n"
                + "ALUM_TEL=?,\n"
                + "ALUM_COR=? where ALUM_ID=?";
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdalumno());
            pstm.setString(2, bean.getDni());
            pstm.setString(3, bean.getNombre());
            pstm.setString(4, bean.getApellido());
            pstm.setString(5, bean.getFecha());
            pstm.setString(6, bean.getDireccion());
            pstm.setString(7, bean.getTelefono());
            pstm.setString(8, bean.getCorreo());
            pstm.setInt(9, bean.getIdalumno());
            pstm.executeUpdate();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(String codigo) {
        String mensaje = null;
        String sql = "delete from ALUMNO where ALUM_ID=?";
        try {
            Connection cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }

    @Override
    public Alumno buscar(String codigo) {
        Alumno alum = null;
        String sql = "SELECT ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,to_char(ALUM_FEC,'dd-mm-yyyy'),ALUM_DIR,ALUM_TEL,ALUM_COR"
                + " from ALUMNO where ALUM_ID=?";
        //  "select * from CURSO where CURS_ID = ?";
        try {
            Connection cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                alum = new Alumno();
                alum.setIdalumno(rs.getInt(1));
                alum.setDni(rs.getString(2));
                alum.setNombre(rs.getString(3));
                alum.setApellido(rs.getString(4));
                alum.setFecha(rs.getString(5));
                alum.setDireccion(rs.getString(6));
                alum.setTelefono(rs.getString(7));
                alum.setCorreo(rs.getString(8));
            }
            cn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            return null;
        }
        return alum;
    }

    @Override
    public ArrayList<Alumno> listabuscar(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno leer(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> leerVarios(Alumno bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Alumno rowToBean(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno buscarCodigo(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno buscarDNI(String codigo) {
        Alumno alum = null;
        String sql ="SELECT ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,to_char(ALUM_FEC,'dd-mm-yyyy'),ALUM_DIR,ALUM_TEL,ALUM_COR"
                 + " from ALUMNO where ALUM_DNI=?";
                

        try {
            Connection cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
              alum = new Alumno();
                alum.setIdalumno(rs.getInt(1));
                alum.setDni(rs.getString(2));
                alum.setNombre(rs.getString(3));
                alum.setApellido(rs.getString(4));
                alum.setFecha(rs.getString(5));
                alum.setDireccion(rs.getString(6));
                alum.setTelefono(rs.getString(7));
                alum.setCorreo(rs.getString(8));
            }
            cn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            return null;
        }
        return alum;
    }

    @Override
    public ArrayList<Alumno> listarcombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
