/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.eniso.iot.entity.Industrial;
import tn.eniso.iot.entity.Student;
import tn.eniso.iot.service.Main;

/**
 *
 * @author Houssem
 */
@Controller
public class IndustrialsListCtrl {

    private Model model = new Model();
    @Autowired
    private Main main;

    public List<Industrial> findAllIndustrials() {
        return main.getAllIndustrials();
    }
    
    public void deleteIndustrial(int id){
        main.deleteIndustrial(id);
    }

    public class Model {

        private Industrial industrial = new Industrial();

        public Industrial getIndustrial() {
            return industrial;
        }

        public void setIndustrial(Industrial industrial) {
            this.industrial = industrial;
        }
    }
}
