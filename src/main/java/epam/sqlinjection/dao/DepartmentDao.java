package epam.sqlinjection.dao;

import epam.sqlinjection.model.Department;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentDao {

    ConnectionFactory dataSource;

    public DepartmentDao() throws SQLException {
        dataSource = ConnectionFactory.getInstance();
    }

    public List<Department> selectAllDepartmentsFromDb() throws SQLException {
        Connection cn = dataSource.getConnection();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from DEPT");
        List<Department> departments = new ArrayList<>();
        while (rs.next()) {
            Long depId = rs.getLong("DEP_ID");
            String depName = rs.getString("DEP_NAME");
            departments.add(new Department(depId, depName));
        }
        return departments;
    }

    public void insertDepartment(long id, String name) throws SQLException {
        Connection cn = dataSource.getConnection();
        Statement st = cn.createStatement();
        String insertString = "Insert into DEPT(DEP_ID, DEP_NAME) VALUES (" + id + ", '" + name + "')";
        st.executeUpdate(insertString);
    }


}
