/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.iot.presentation;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import tn.eniso.iot.entity.Workshop;

/**
 *
 * @author Houssem
 */
@FacesConverter(value = "workshopConverter")
public class WorkshopConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if((value==null) || (value.equals("")) || (value.equals("Workshop"))){
            return null;
        }
               ValueExpression vex =
                context.getApplication().getExpressionFactory()
                        .createValueExpression(context.getELContext(),
                                "#{addStudentCtrl}", AddStudentCtrl.class);

        AddStudentCtrl  studentCtrl = (AddStudentCtrl)vex.getValue(context.getELContext());
        return studentCtrl.findWorkshopById(Integer.valueOf(value));
 
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof String){
            return null;
        }
        return Integer.toString(((Workshop)value).getId());
    }
    
}
