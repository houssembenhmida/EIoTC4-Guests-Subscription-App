/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.eniso.iot.entity.Workshop;
import tn.eniso.iot.service.Main;

/**
 *
 * @author Houssem
 */
@Controller
public class WorkshopsListCtrl {
    private Model model = new Model();
    @Autowired
    private Main main;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public List<Workshop> findAllWorkshops(){
        return main.getAllWorkshpos();
    }
    
    public void deleteWorkshop(int id){
        main.deleteWorkshop(id);
    }
    
    public class Model {

        private Workshop workshop = new Workshop();

        public Workshop getWorkshop() {
            return workshop;
        }

        public void setWorkshop(Workshop workshop) {
            this.workshop = workshop;
        }

    }
}
