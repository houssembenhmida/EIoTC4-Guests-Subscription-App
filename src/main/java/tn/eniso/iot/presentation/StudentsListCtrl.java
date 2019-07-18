/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.eniso.iot.entity.Student;
import tn.eniso.iot.entity.Workshop;
import tn.eniso.iot.service.Main;

/**
 *
 * @author Houssem
 */
@Controller
public class StudentsListCtrl {

    private Model model = new Model();
    @Autowired
    private Main main;

    public Model getModel() {
        return model;
    }

    public List<Student> findAllStudents() {
        return main.getAllStudents();
    }

    public void deleteStudent(int id) {
        main.deleteStudent(id);
    }

    public Workshop findWorkshopById(int id) {
        return main.getWorkshopById(id);
    }

    public List<Student> findStudentsByWorkshopName(String name) {
        if ((name == null) || (name.equals(""))) {
            return main.getAllStudents();
        }
        return main.getStudentsByWorkshopName(name);
    }

    public List<Workshop> findAllWorkshops() {
        return main.getAllWorkshpos();
    }

    public class Model {

        private Student student = new Student();
        private Workshop workshop = null;

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Workshop getWorkshop() {
            return workshop;
        }

        public void setWorkshop(Workshop workshop) {
            this.workshop = workshop;
        }

        
    }
}
