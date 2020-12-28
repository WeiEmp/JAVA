package cn.hbzd.springboot.controller;

import cn.hbzd.springboot.dao.DepartmentDao;
import cn.hbzd.springboot.dao.EmployeeDao;
import cn.hbzd.springboot.entities.Department;
import cn.hbzd.springboot.entities.Employee;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyAgreement;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/24 15:18
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工返回列表
    @GetMapping("/emps")
    public String list(Map<String, Object> map) {
        Collection<Employee> all = employeeDao.getAll();
        map.put("list", all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Map<String, Object> map) {
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        return "emp/add";

    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") int id, Map<String, Object> map) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        map.put("emp", employee);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
