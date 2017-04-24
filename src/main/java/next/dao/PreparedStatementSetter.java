package next.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by young-seok on 2017. 4. 24..
 */
public interface PreparedStatementSetter {
    void setValues(PreparedStatement pstmt) throws SQLException;
}
