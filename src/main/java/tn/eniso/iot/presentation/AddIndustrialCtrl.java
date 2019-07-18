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
import tn.eniso.iot.entity.Industrial;
import tn.eniso.iot.entity.Student;
import tn.eniso.iot.entity.Workshop;
import tn.eniso.iot.service.Main;

/**
 *
 * @author Houssem
 */
@Controller
public class AddIndustrialCtrl {

    private Model model = new Model();
    @Autowired
    private Main main;

    public Model getModel() {
        return model;
    }

    public void add() throws IOException {
        main.addIndustrial(getModel().getIndustrial());
        getModel().setIndustrial(new Industrial());
        redirect();
    }

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("subscription.xhtml");
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
