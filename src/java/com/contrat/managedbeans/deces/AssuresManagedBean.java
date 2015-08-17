package com.contrat.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.contrat.entities.Assures;
import com.contrat.entities.Typecontrat;
import com.contrat.service.deces.AssuresServiceBeanLocal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "assuresManagedBean")
@ViewScoped
public class AssuresManagedBean implements Serializable {

    @EJB
    private AssuresServiceBeanLocal assuresService;
    private Assures formAssures = new Assures();
    private Assures selectedAssures;
    private List<Assures> dataListAssures;
    private List<Assures> datalistfiltre;
    private List<Assures> dataassuresentreise;
    private Boolean desactiversuppr = true, desactiverCode;
    private int index;

    /**
     * Creates a new instance of AssuresManagedBean
     */
    public AssuresManagedBean() {
        formAssures = new Assures();
        selectedAssures = new Assures();
        dataListAssures = new ArrayList<Assures>();
    }

    public void active() {
        this.desactiversuppr = false;
    }

    private void gridloadDB() {
        selectedAssures = null;
        try {
            dataListAssures = assuresService.assureall();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListAssures.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }

    public void enregistrer() {
//        MessageBean m = new MessageBean();
        formAssures.setStatutassur("actif");
        formAssures.setAgeassur(ageassure());
        assuresService.ajouter(formAssures);
        formAssures = new Assures();
//        m.addMessageInfo("enregistré");

    }

    public void modifier() {
//        MessageBean m = new MessageBean();
        if (selectedAssures != null) {
            assuresService.modifier(formAssures);
//            m.addMessageInfo("modifié");
            formAssures = new Assures();
            selectedAssures = null;
            this.desactiversuppr = true;
        }
    }

    public int ageassure() {
        Calendar calendar = new GregorianCalendar();
        LocalDate aujourdui = new LocalDate();
        calendar.setTime(formAssures.getDatnaisassure());
        int annee = calendar.get(Calendar.YEAR);
        int mois = calendar.get(Calendar.MONTH);
        int jours = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate naissance = new LocalDate(annee, mois, jours);
        Period p = new Period(naissance, aujourdui, PeriodType.yearMonthDay());
        return p.getYears();
    }

    public void effacer() {
        formAssures = new Assures();
        selectedAssures = null;
    }

    public void supprimer() {
        if (selectedAssures != null) {
            assuresService.supprimer(selectedAssures);
        }
    }

    public void rowSelected() {
        this.formAssures = this.selectedAssures;
        this.desactiverCode = true;
        this.index = this.dataListAssures.indexOf(this.selectedAssures);
        this.desactiversuppr = false;
    }

    public Assures getFormAssures() {
        return formAssures;
    }

    public void setFormAssures(Assures formAssures) {
        this.formAssures = formAssures;
    }

    public Assures getSelectedAssures() {
        return selectedAssures;
    }

    public void setSelectedAssures(Assures selectedAssures) {
        this.selectedAssures = selectedAssures;
    }

    public List<Assures> getDataListAssures() {
        dataListAssures = assuresService.assureall();
        return dataListAssures;
    }

    public void setDataListAssures(List<Assures> dataListAssures) {
        this.dataListAssures = dataListAssures;
    }

    public Boolean getDesactiversuppr() {
        return desactiversuppr;
    }

    public void setDesactiversuppr(Boolean desactiversuppr) {
        this.desactiversuppr = desactiversuppr;
    }

    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }

    public AssuresServiceBeanLocal getAssuresService() {
        return assuresService;
    }

    public void setAssuresService(AssuresServiceBeanLocal assuresService) {
        this.assuresService = assuresService;
    }

    public List<Assures> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<Assures> datalistfiltre) {
        this.datalistfiltre = datalistfiltre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Assures> getDataassuresentreise() {
        dataassuresentreise = assuresService.assureentreprise();
        return dataassuresentreise;
    }

    public void setDataassuresentreise(List<Assures> dataassuresentreise) {
        this.dataassuresentreise = dataassuresentreise;
    }

}
