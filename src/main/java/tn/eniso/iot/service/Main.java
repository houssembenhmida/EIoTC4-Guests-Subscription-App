/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.eniso.iot.entity.AppUser;
import tn.eniso.iot.entity.Industrial;
import tn.eniso.iot.entity.Student;
import tn.eniso.iot.entity.Workshop;

/**
 *
 * @author Houssem
 */
@Service
@Scope(value = "singleton")
public class Main {

    @PersistenceContext(unitName = "iotpu")
    EntityManager em;
//================================================================================
//Industrial CRUD

    @Transactional
    public void addIndustrial(Industrial industrial) {
        em.persist(industrial);

    }

    public Industrial getIndustrialById(int id) {
        return em.find(Industrial.class, id);
    }

    public List<Industrial> getAllIndustrials() {
        return em.createQuery("select i from Industrial i")
                .getResultList();
    }

    @Transactional
    public void updateIndustrial(Industrial industrial) {
        em.merge(industrial);
    }

    @Transactional
    public void deleteIndustrial(int id) {
        Industrial i = getIndustrialById(id);
        em.remove(i);
    }

//================================================================================
//Student CRUD
    @Transactional
    public void addStudent(Student student) {
        em.persist(student);

    }

    public Student getStudentById(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return em.createQuery("select i from Student i")
                .getResultList();
    }

    public List<Student> getStudentsByWorkshopName(String name) {
        return em.createQuery("select i from Student i where i.workshop.name=:name")
                .setParameter("name", name)
                .getResultList();
    }

    @Transactional
    public void updateStudent(Student student) {
        em.merge(student);
    }

    @Transactional
    public void deleteStudent(int id) {
        Student s = getStudentById(id);
        em.remove(s);
    }

//================================================================================
//Workshop CRUD
    @Transactional
    public void addWorkshop(Workshop workshop) {
        em.persist(workshop);

    }

    public Workshop getWorkshopById(int id) {
        return em.find(Workshop.class, id);
    }

    public List<Workshop> getAllWorkshpos() {
        return em.createQuery("select i from Workshop i")
                .getResultList();
    }

//    public List<String> getAllWorkshposNames() {
//        return em.createQuery("select i.name from Workshop i")
//                .getResultList();
//    }

    @Transactional
    public void updateWorkshop(Workshop workshop) {
        em.merge(workshop);
    }

    @Transactional
    public void deleteWorkshop(int id) {
        Workshop w = getWorkshopById(id);
        em.remove(w);
    }

//================================================================================    
//AppUser CRUD
    @Transactional
    public void addAppUser(AppUser appUser) {
        em.persist(appUser);

    }

    public AppUser getAppUserId(int id) {
        return em.find(AppUser.class, id);
    }

    public List<AppUser> getAllAppUsers() {
        return em.createQuery("select i from AppUser i")
                .getResultList();
    }

    @Transactional
    public void updateAppUser(AppUser appUser) {
        em.merge(appUser);
    }

    @Transactional
    public void deleteAppUser(int id) {
        AppUser au = getAppUserId(id);
        em.remove(au);
    }
}
