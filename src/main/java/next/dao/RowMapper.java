package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by young-seok on 2017. 4. 24..
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
