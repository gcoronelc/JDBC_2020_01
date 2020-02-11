package sistemas.uni.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.uni.db.AccesoDB;
import sistemas.uni.model.Profesor;
import sistemas.uni.services.ProfesorService;

public class ProfesorServiceImpl implements ProfesorService{
    static ResultSet resultado;
    @Override
    public String insertar(Profesor bean) {
        
        String mensaje = null;
        Connection cn = null;
        String sql = "insert into PROFESOR(PROF_ID,PROF_DNI,PROF_FEC,PROF_NOM,PROF_APE,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdprof());
            pstm.setString(2, bean.getDni());
            pstm.setString(3, bean.getFnac());
            pstm.setString(4, bean.getNombre());
            pstm.setString(5, bean.getApellido());
            pstm.setString(6, bean.getDireccion());
            pstm.setString(7, bean.getTelefono());
            pstm.setString(8, bean.getCorreo());
            pstm.setInt(9, bean.getIdcurso());
            pstm.executeQuery();
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
        
    }

    @Override
    public String update(Profesor bean) {
        Profesor prof = new Profesor();
        String mensaje = null;
  
         String sql = "update PROFESOR set PROF_ID=?,\n"
                    + "PROF_DNI=?,\n"
                    + "PROF_FEC=?,\n"
                    + "PROF_NOM=?,\n"
                    + "PROF_APE=?,\n"
                    + "PROF_DIR=?,\n"
                    + "PROF_TEL=?,\n"
                    + "PROF_COR=?,\n"
                    + "CURS_ID=? where PROF_ID=?";   
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
       
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdprof());
            pstm.setString(2, bean.getDni());
            pstm.setString(3, bean.getFnac());
            pstm.setString(4, bean.getNombre());
            pstm.setString(5, bean.getApellido());
            pstm.setString(6, bean.getDireccion());
            pstm.setString(7, bean.getTelefono());
            pstm.setString(8, bean.getCorreo());
            pstm.setInt(9, bean.getIdcurso());
            pstm.setInt(10, bean.getIdprof());
            pstm.executeUpdate();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(String codigo) {
        String mensaje = null;
        String sql = "delete from PROFESOR where PROF_ID=? ";
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
    public Profesor buscarCodigo(String codigo) {
        Profesor prof = null;
        String sql ="SELECT PROF_ID,PROF_DNI,to_char(PROF_FEC,'dd-mm-yyyy'),PROF_NOM,PROF_APE,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID"
                 + " from PROFESOR where PROF_ID=?";
                

        try {
            Connection cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prof = new Profesor();
                prof.setIdprof(rs.getInt(1));
                prof.setDni(rs.getString(2));
                prof.setFnac(rs.getString(3));
                prof.setNombre(rs.getString(4));
                prof.setApellido(rs.getString(5));
                prof.setDireccion(rs.getString(6));
                prof.setTelefono(rs.getString(7));
                prof.setCorreo(rs.getString(8));
                prof.setIdcurso(rs.getInt(9));
            }
            cn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            return null;
        }
        return prof;
        
    }

    @Override
    public ArrayList<Profesor> listabuscar(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor leer(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> leerVarios(Profesor bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor rowToBean(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Profesor> listarcombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor buscarDNI(String codigo) {
        Profesor prof = null;
        String sql ="SELECT PROF_ID,PROF_DNI,to_char(PROF_FEC,'dd-mm-yyyy'),PROF_NOM,PROF_APE,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID"
                 + " from PROFESOR where PROF_DNI=?";
                

        try {
            Connection cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prof = new Profesor();
                prof.setIdprof(rs.getInt(1));
                prof.setDni(rs.getString(2));
                prof.setFnac(rs.getString(3));
                prof.setNombre(rs.getString(4));
                prof.setApellido(rs.getString(5));
                prof.setDireccion(rs.getString(6));
                prof.setTelefono(rs.getString(7));
                prof.setCorreo(rs.getString(8));
                prof.setIdcurso(rs.getInt(9));
            }
            cn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            return null;
        }
        return prof;
    }

    @Override
    public Profesor buscar(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
