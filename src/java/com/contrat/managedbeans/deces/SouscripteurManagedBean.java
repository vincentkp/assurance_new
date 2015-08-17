package com.contrat.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.contrat.entities.Souscripteur;
import com.contrat.entities.Typecontrat;
import com.contrat.service.deces.SouscripteurServiceBeanLocal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "souscripteurManagedBean")
@ViewScoped
public class SouscripteurManagedBean  implements Serializable{

    @EJB
    private SouscripteurServiceBeanLocal souscripteurService;
    private Souscripteur formSouscripteur = new Souscripteur();
    private Souscripteur selectedSouscripteur;
    private List<Souscripteur> dataListSouscripteur;
    private List<Souscripteur> datalistfiltre;
private Boolean desactiverSuppr = true, desactiverCode;
private Boolean desactivesup = true;
    private int index;
    /**
     * Creates a new instance of SouscripteurManagedBean
     */
    public SouscripteurManagedBean() {
     formSouscripteur = new Souscripteur();
     selectedSouscripteur = new Souscripteur();
    dataListSouscripteur = new ArrayList<>();
    }
    
    public void active() {
        this.desactivesup = false;
    }
    
    private void gridloadDB(){
        selectedSouscripteur=null;
        try{
            dataListSouscripteur=souscripteurService.souscripteurall();
        }
        catch(Exception e){
            
            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListSouscripteur.size() + " enregistrements chargés. (timestamp = "+(new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date())+")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }
    
     public void refreshGrid() {
        gridloadDB();
    }
     
     
    
    public void enregistrer(){
//            MessageBean m = new MessageBean();
            formSouscripteur.setStatutsous("actif");
            souscripteurService.ajouter(formSouscripteur);
            formSouscripteur=new Souscripteur();
//            m.addMessageInfo("enregistré");
        
    }
    
    public void mdifier(){
//        MessageBean m = new MessageBean();
        if(selectedSouscripteur != null){
            souscripteurService.modifier(formSouscripteur);
//            m.addMessageInfo("modifié");
            formSouscripteur = new Souscripteur();
            selectedSouscripteur = null;
            this.desactivesup = true;
        }
    }
    
    
    public void effacer(){
        formSouscripteur = new Souscripteur();
        selectedSouscripteur = null;
    }
    
    public void supprimer(){
        if(selectedSouscripteur != null){
            souscripteurService.supprimer(selectedSouscripteur);
        }
    }

 public void rowSelected() {
        this.formSouscripteur = this.selectedSouscripteur;
        this.desactiverCode = true;
        this.index = this.dataListSouscripteur.indexOf(this.selectedSouscripteur);
        this.desactivesup = false;
    }    
 
 public Souscripteur getFormSouscripteur() {
        return formSouscripteur;
    }

    public void setFormSouscripteur(Souscripteur formSouscripteur) {
        this.formSouscripteur = formSouscripteur;
    }

    public Souscripteur getSelectedSouscripteur() {
        return selectedSouscripteur;
    }

    public void setSelectedSouscripteur(Souscripteur selectedSouscripteur) {
        this.selectedSouscripteur = selectedSouscripteur;
    }

    public List<Souscripteur> getDataListSouscripteur() {
        dataListSouscripteur=souscripteurService.souscripteurall();
        return dataListSouscripteur;
    }

    public void setDataListSouscripteur(List<Souscripteur> dataListSouscripteur) {
        this.dataListSouscripteur = dataListSouscripteur;
    }
    
 public Boolean isDesactiverBoutonSuppr() {
        return desactiverSuppr;
    }

    public void setDesactiverSuppr(Boolean desactiverSuppr) {
        this.desactiverSuppr = desactiverSuppr;
    }

    public Boolean getDesactiverSuppr() {
        return desactiverSuppr;
    }

    public Boolean getDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverBoutonSuppr(Boolean desactiverBoutonSuppr) {
        this.desactiverSuppr = desactiverBoutonSuppr;
    }

    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }

    public SouscripteurServiceBeanLocal getSouscripteurService() {
        return souscripteurService;
    }

    public void setSouscripteurService(SouscripteurServiceBeanLocal souscripteurService) {
        this.souscripteurService = souscripteurService;
    }

    public List<Souscripteur> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<Souscripteur> datalistfiltre) {
        this.datalistfiltre = datalistfiltre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getDesactivesup() {
        return desactivesup;
    }

    public void setDesactivesup(Boolean desactivesup) {
        this.desactivesup = desactivesup;
    }
    
}
