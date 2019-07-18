/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.eniso.iot.entity.AppUser;
import tn.eniso.iot.service.Main;

/**
 *
 * @author Houssem
 */
@Controller
public class UserListCtrl {
    private Model model = new Model();
    @Autowired
    private Main main;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public List<AppUser> findAllUsers(){
        return main.getAllAppUsers();
    }
    
    public void deleteAppUser(int id){
        main.deleteAppUser(id);
    }
    
    public class Model {

        private AppUser appUser= new AppUser();

        public AppUser getAppUser() {
            return appUser;
        }

        public void setAppUser(AppUser appUser) {
            this.appUser = appUser;
        }
        

    }
}
