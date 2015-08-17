/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contrat.managedbeans.deces;

import com.contrat.entities.Modepayement;
import com.contrat.service.impl.deces.ModepayementServiceBean;
import java.io.Serializable;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author VERSACE
 */
@ManagedBean(name = "md")
@ViewScoped
@RequestScoped
public class md implements Serializable {

    @EJB

    private ModepayementServiceBean modepayementService;
    private Modepayement formmd = new Modepayement();
    private Modepayement selectmd;
    private List<Modepayement> liste;
    private boolean desc = true;
    private int index;

    /**
     * Creates a new instance of md
     */
    public md() {
        formmd = new Modepayement();
        selectmd = new Modepayement();
        liste = new ArrayList<Modepayement>();
    }

    public void load() {
        selectmd = null;
        try {
            liste = modepayementService.listmodepayementall();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Modepayement.class.getName()).log(Level.SEVERE, null, e);
        }

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", liste.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    public void refresh(){
        this.load();
    }
    
    public void desc(){
        if(selectmd != null){
            selectmd.setStatutmodpaye("inactif");
            modepayementService.modifier(selectmd);
        }
        this.formmd = new Modepayement();
    }
    
    private void enregistre(){
        List<Modepayement> l = new ArrayList<>();
        l = modepayementService.listmodepayementall();
        int i = 0;
        if(formmd.getLibmodpayement().trim().isEmpty()){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "renseigner le libellé: ", l.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
        }
        else {
            if(selectmd!=null){
                modepayementService.modifier(selectmd);
            }
            else{
         i = l.stream().filter((list1) -> (list1.getLibmodpayement().equals(formmd.getLibmodpayement()))).map((_item) -> 1).reduce(i, Integer::sum);
           if(i==0){
               formmd.setStatutmodpaye("actif");
               modepayementService.ajouter(formmd);
           }
           else{
               FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "existe deja: ", l.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
           }
            }
            
            formmd = new Modepayement();
            this.desc = true;
          
        }
    }
    
    public void effacer() {
        this.desc=true;
        formmd = new Modepayement();
        selectmd =new Modepayement();
        selectmd=null;
    }
    
    public void selection(){
        formmd = selectmd;
        this.index = this.liste.indexOf(this.selectmd);
                
    }

    public ModepayementServiceBean getModepayementService() {
        return modepayementService;
    }

    public Modepayement getFormmd() {
        return formmd;
    }

    public Modepayement getSelectmd() {
        return selectmd;
    }

    public List<Modepayement> getListe() {
        return liste;
    }

    public boolean isDesc() {
        return desc;
    }

    public int getIndex() {
        return index;
    }

    public void setModepayementService(ModepayementServiceBean modepayementService) {
        this.modepayementService = modepayementService;
    }

    public void setFormmd(Modepayement formmd) {
        this.formmd = formmd;
    }

    public void setSelectmd(Modepayement selectmd) {
        this.selectmd = selectmd;
    }

    public void setListe(List<Modepayement> liste) {
        this.liste = liste;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
}
