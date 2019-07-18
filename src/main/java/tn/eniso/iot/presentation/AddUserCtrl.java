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
import tn.eniso.iot.entity.AppUser;
import tn.eniso.iot.service.Main;

/**
 *
 * @author Houssem
 */
@Controller
public class AddUserCtrl {

    private Model model = new Model();
    @Autowired
    private Main main;

    public Model getModel() {
        return model;
    }

    public void add() throws IOException {
        main.addAppUser(getModel().getAppUser());
        getModel().setAppUser(new AppUser());
        redirect();
    }

//    public List<Workshop> findAllWorkshops() {
//        return main.getAllWorkshpos();
//    }

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("administration.xhtml");
    }

//    @PostConstruct
//    private void init(){
//        getModel().setIndustrial(new Industrial());
//    }
    public class Model {

        private AppUser appUser;

        public AppUser getAppUser() {
            return appUser;
        }

        public void setAppUser(AppUser appUser) {
            this.appUser = appUser;
        }

    }
}
