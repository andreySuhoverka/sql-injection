package epam.sqlinjection;

import epam.sqlinjection.dao.DepartmentDao;
import epam.sqlinjection.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;


@Controller
public class HelloInjection {


    @Autowired
    DepartmentDao dao;
    @RequestMapping("/loadDepartments")
    public ModelAndView loadDepartments() throws SQLException {

        List<Department> departments = dao.selectAllDepartmentsFromDb();
        return new ModelAndView("departments", "departments", departments);
    }

    @RequestMapping("/injectHarmfulSql")
    public ModelAndView injectHarmfulSql(@RequestParam(value = "id") long id,
                                         @RequestParam(value = "name") String name) throws SQLException {

        dao.insertDepartment(id, name);
        List<Department> departments = dao.selectAllDepartmentsFromDb();
        return new ModelAndView("departments", "departments", departments);
    }
}