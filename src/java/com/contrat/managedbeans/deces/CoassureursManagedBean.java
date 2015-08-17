package com.contrat.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.contrat.entities.Coassureurs;
import com.contrat.entities.Typecontrat;
import com.contrat.service.deces.CoassureursServiceBeanLocal;
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
@ManagedBean(name = "coassureursManagedBean")
@ViewScoped
public class CoassureursManagedBean  implements Serializable{

    @EJB
    private CoassureursServiceBeanLocal coassureursService;
    private Coassureurs formCoassureurs = new Coassureurs();
    private Coassureurs selectedCoassureurs;
    private String keyWord;
    private List<Coassureurs> dataListCoassureurs;
    private List<Coassureurs> datalistfiltre;
    private Boolean desactiversuppr = true;
    private int index;
    /**
     * Creates a new instance of CoassureursManagedBean
     */
    public CoassureursManagedBean() {
     formCoassureurs = new Coassureurs();
     selectedCoassureurs = new Coassureurs();
    dataListCoassureurs = new ArrayList<>();
    }
    
     public void desactiver() {
        if (selectedCoassureurs != null) {
            selectedCoassureurs.setStatutcoass("inactif");
          coassureursService.modifier(selectedCoassureurs);
        }
        this.formCoassureurs= new Coassureurs();
    }


    private void gridloadDB() {
        selectedCoassureurs = null;
        try {
            dataListCoassureurs = coassureursService.coassureurall();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListCoassureurs.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }

    public void enregistrer(){
//        MessageBean m=new MessageBean();
        if(selectedCoassureurs != null){
            coassureursService.modifier(formCoassureurs);
             formCoassureurs=new  Coassureurs();
        desactiversuppr=true;
//        m.addMessageInfo("modifié");
        }else{
            formCoassureurs.setStatutcoass("actif");
            coassureursService.ajouter(formCoassureurs);
//            m.addMessageInfo("enregitré");
        }
        formCoassureurs=new  Coassureurs();
        this.desactiversuppr=true;
    }
    
    public void effacer(){
        formCoassureurs = new Coassureurs();
        selectedCoassureurs = null;
        this.desactiversuppr=true;
    }
    
    public void supprimer(){
        if(selectedCoassureurs != null){
            coassureursService.supprimer(selectedCoassureurs);
        }
    }

 public void rowSelected() {
        formCoassureurs = selectedCoassureurs;
        this.index = this.dataListCoassureurs.indexOf(this.selectedCoassureurs);
        this.desactiversuppr = false;
    }
 public Coassureurs getFormCoassureurs() {
        return formCoassureurs;
    }

    public void setFormCoassureurs(Coassureurs formCoassureurs) {
        this.formCoassureurs = formCoassureurs;
    }

    public Coassureurs getSelectedCoassureurs() {
        return selectedCoassureurs;
    }

    public void setSelectedCoassureurs(Coassureurs selectedCoassureurs) {
        this.selectedCoassureurs = selectedCoassureurs;
    }

    public List<Coassureurs> getDataListCoassureurs() {
        dataListCoassureurs=coassureursService.coassureurall();
        return dataListCoassureurs;
    }

    public void setDataListCoassureurs(List<Coassureurs> dataListCoassureurs) {
        this.dataListCoassureurs = dataListCoassureurs;
    }

    public CoassureursServiceBeanLocal getCoassureursService() {
        return coassureursService;
    }

    public void setCoassureursService(CoassureursServiceBeanLocal coassureursService) {
        this.coassureursService = coassureursService;
    }

    public List<Coassureurs> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<Coassureurs> datalistfiltre) {
        this.datalistfiltre = datalistfiltre;
    }

    public Boolean getDesactiversuppr() {
        return desactiversuppr;
    }

    public void setDesactiversuppr(Boolean desactiversuppr) {
        this.desactiversuppr = desactiversuppr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    
    
 
}
