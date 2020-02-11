
package sistemas.uni.services;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface RowMapper<T> {
      T rowToBean(ResultSet rs) throws SQLException;
}
