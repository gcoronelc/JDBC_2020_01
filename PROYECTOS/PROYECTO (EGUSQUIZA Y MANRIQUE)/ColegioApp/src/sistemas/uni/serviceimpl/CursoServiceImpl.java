package sistemas.uni.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import sistemas.uni.db.AccesoDB;
import sistemas.uni.model.Curso;
import sistemas.uni.services.CursoService;

public class CursoServiceImpl implements CursoService {

    @Override
    public String insertar(Curso bean) {
        String mensaje = null;
        Connection cn = null;
        String sql = "insert into CURSO(CURS_ID,CURS_NOM,FECH_INI,FECH_FIN,CURS_DIA,CURS_HOR) VALUES(?,?,?,?,?,?)";
        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdcurso());
            pstm.setString(2, bean.getNombre());
            pstm.setString(3, bean.getInicio());
            pstm.setString(4, bean.getTermino());
            pstm.setString(5, bean.getDia());
            pstm.setString(6, bean.getHora());
            pstm.executeQuery();
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Curso bean) {
        String mensaje = null;
  
         String sql = "update CURSO set CURS_ID=?,\n"
                    + "CURS_NOM=?,\n"
                    + "FECH_INI=?,\n"
                    + "FECH_FIN=?,\n"
                    + "CURS_DIA=?,\n"
                    + "CURS_HOR=? where CURS_ID=?";   
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
       
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdcurso());
            pstm.setString(2, bean.getNombre());
            pstm.setString(3, bean.getInicio());
            pstm.setString(4, bean.getTermino());
            pstm.setString(5, bean.getDia());
            pstm.setString(6, bean.getHora());
            pstm.setInt(7, bean.getIdcurso());
            pstm.executeUpdate();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(String codigo) {
        String mensaje = null;
        String sql = "delete from CURSO where CURS_ID=? ";
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
    public Curso buscar(String codigo) {
        Curso curs = null;
        String sql ="SELECT CURS_ID,CURS_NOM,to_char(FECH_INI,'dd-mm-yyyy'),to_char(FECH_FIN,'dd-mm-yyyy'),CURS_DIA,CURS_HOR"
                 + " from CURSO where CURS_ID=?";
                
        
              //  "select * from CURSO where CURS_ID = ?";
        try {
            Connection cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                curs = new Curso();
                curs.setIdcurso(rs.getInt(1));
                curs.setNombre(rs.getString(2));
                curs.setInicio(rs.getString(3));
                curs.setTermino(rs.getString(4));
                curs.setDia(rs.getString(5));
                curs.setHora(rs.getString(6));
            }
            cn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            return null;
        }
        return curs;
    }

    @Override
    public ArrayList<Curso> listabuscar(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso leer(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> leerVarios(Curso bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso rowToBean(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso buscarCodigo(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso buscarDNI(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Curso> listarcombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}