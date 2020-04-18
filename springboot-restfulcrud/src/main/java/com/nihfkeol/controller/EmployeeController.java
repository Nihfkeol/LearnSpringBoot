package com.nihfkeol.controller;

import com.nihfkeol.dao.DepartmentDao;
import com.nihfkeol.dao.EmployeeDao;
import com.nihfkeol.entities.Department;
import com.nihfkeol.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    //查询侧边员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        logger.info("查询侧边员工");

        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中进行共享
        model.addAttribute("emps",employees);

        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        logger.info("到添加页面");
        //来到添加页面，查出所有的部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性一一绑定；
    //要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        logger.info("添加员工");
        //保存员工
        employeeDao.save(employee);

        //员工添加完后，来到员工列表页面
        //redirect：表示重定向到一个地址   /代表当前项目文件
        //forward：转发到一个地址
        return "redirect:/emps";
    }

    //来到修改页面，查出员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        logger.info("查出员工，页面回显");
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面
        return "/emp/edit";
    }

    //修改员工信息；需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        logger.info("修改员工");
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        logger.info("删除员工");
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
