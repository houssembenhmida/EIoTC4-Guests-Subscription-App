/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.presentation;

import java.io.IOException;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.eniso.iot.entity.Workshop;
import tn.eniso.iot.service.Main;

/**
 *
 * @author Houssem
 */
@Controller
public class AddWorkshopCtrl {

    private Model model = new Model();
    @Autowired
    private Main main;

    public Model getModel() {
        return model;
    }

    public void add() throws IOException {
        main.addWorkshop(getModel().getWorkshop());
        getModel().setWorkshop(new Workshop());
//        return "workshopsList";
        redirect();
    }

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("workshopsList.xhtml");
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
