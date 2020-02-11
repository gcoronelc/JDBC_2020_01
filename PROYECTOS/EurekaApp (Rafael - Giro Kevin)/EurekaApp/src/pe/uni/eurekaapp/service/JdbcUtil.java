package pe.uni.eurekaapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class JdbcUtil {
	
	 private JdbcUtil() {
  }

  public static List<Map<String, ?>> rsToList(ResultSet rs) 
					throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, ?>> results = new ArrayList<>();

        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columns; i++) {
                row.put(md.getColumnLabel(i).toUpperCase(), rs.getObject(i));
            }
            results.add(row);
        }

        return results;
  }

}
