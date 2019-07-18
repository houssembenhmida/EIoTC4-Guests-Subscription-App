/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.presentation;

import java.io.IOException;
import java.util.List;
import javax.faces.context.FacesContext;
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
public class AddStudentCtrl {
     private Model model=new Model();
    @Autowired
    private Main main;

    public Model getModel() {
        return model;
    }
    
    public void add() throws IOException{
        main.addStudent(getModel().getStudent());
        getModel().setStudent(new Student());
        redirect();
    }
    
    public List<Workshop> findAllWorkshops(){
        return main.getAllWorkshpos();
    }
    
    public Workshop findWorkshopById(int id){
        return main.getWorkshopById(id);
    }

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("subscription.xhtml");
    }
    
//    @PostConstruct
//    private void init(){
//        getModel().setIndustrial(new Industrial());
//    }

    public class Model {

        private Student student=new Student();
//        private String workshop;

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

//        public String getWorkshop() {
//            return workshop;
//        }
//
//        public void setWorkshop(String workshop) {
//            this.workshop = workshop;
//        }
        


    }
}
