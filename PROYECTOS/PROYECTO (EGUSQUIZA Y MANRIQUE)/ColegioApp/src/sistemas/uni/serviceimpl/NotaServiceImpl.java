
package sistemas.uni.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.uni.db.AccesoDB;
import sistemas.uni.model.Nota;
import sistemas.uni.services.NotaService;


public class NotaServiceImpl implements NotaService  {

    @Override
    public String insertar(Nota bean) {
        String mensaje = null;
        Connection cn = null;
        String sql = "insert into NOTA(NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) VALUES(?,?,?,?,?)";
        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdnota());
            pstm.setInt(2, bean.getIdalumno());
            pstm.setInt(3, bean.getIdcurso());
            pstm.setDouble(4, bean.getNota());
            pstm.setString(5, bean.getEstado());
        
            pstm.executeQuery();
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Nota bean) {
         String mensaje = null;

        String sql = "update NOTA set NOTA_ID=?,\n"
                + "ALUM_ID=?,\n"
                + "CURS_ID=?,\n"
                + "NOTA_PROM=?,\n"           
                + "NOTA_EST=? where NOTA_ID=?";
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdnota());
            pstm.setInt(2, bean.getIdalumno());
            pstm.setInt(3, bean.getIdcurso());
            pstm.setDouble(4, bean.getNota());
            pstm.setString(5, bean.getEstado());
            pstm.setInt(6, bean.getIdnota());
            pstm.executeUpdate();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(String codigo) {
             String mensaje = null;
        String sql = "delete from NOTA where NOTA_ID=?";
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
    public Nota buscar(String codigo) {
            Nota not = null;
        String sql = "SELECT NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST"
                + " from NOTA where NOTA_ID=?";
        //  "select * from CURSO where CURS_ID = ?";
        try {
            Connection cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                not = new Nota();
                not.setIdnota(rs.getInt(1));
                not.setIdalumno(rs.getInt(2));
                not.setIdcurso(rs.getInt(3));
                not.setNota(rs.getDouble(4));
                not.setEstado(rs.getString(5));
            }
            cn.close();
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            return null;
        }
        return not;
    }

    @Override
    public ArrayList<Nota> listabuscar(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nota leer(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nota> leerVarios(Nota bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public Nota rowToBean(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nota buscarCodigo(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nota buscarDNI(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Nota> listarcombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
}
