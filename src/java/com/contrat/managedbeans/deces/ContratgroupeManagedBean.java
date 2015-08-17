/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contrat.managedbeans.deces;

import com.contrat.entities.Assures;
import com.contrat.entities.Contrat;
import com.contrat.entities.Groupe;
import com.contrat.entities.Typecontrat;
import com.contrat.service.deces.AssuresServiceBeanLocal;
import com.contrat.service.deces.ContratServiceBeanLocal;
import com.contrat.service.deces.GroupeServiceBeanLocal;
import com.contrat.service.deces.TypecontratServiceBeanLocal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author desire.mensah
 */
@ManagedBean
@ViewScoped
public class ContratgroupeManagedBean {
   

    @EJB
    private ContratServiceBeanLocal contratService;
    private Contrat formContrat = new Contrat();
    private Contrat selectedContrat;
    private List<Contrat> dataListContrat;
    private List<Contrat> datalistefiltre;
    private Date datesais = new Date();
    private Boolean desactiver = false;
    private Boolean nouveauactif=true;
    private List<Contrat> rnouvelmentcontrat;
    private Contrat selectrnouvelmentcontrat;
    private Contrat formrenvlmntcontrat;
    private String selectoneradio;
    private int index;
    
    @EJB
    private GroupeServiceBeanLocal groupeService;
    private Groupe selectgroup;
    private Groupe formgroupe;
    
    @EJB
    private AssuresServiceBeanLocal assuresService;
    private Assures formassurepret;
    private List<Assures> listassurepret;
    private Assures selectassurepret;
    
    @EJB
    private TypecontratServiceBeanLocal typecontratService;
    private Typecontrat typecontrat;
    private List<Typecontrat> typecontrats;
    
    /**
     * Creates a new instance of Contratgroupe
     */
    public ContratgroupeManagedBean() {
         selectedContrat = new Contrat();
        dataListContrat = new ArrayList<Contrat>();
        formContrat.setDatesaisie(new Date());
        formContrat.setDurecontrat(0);
         formContrat = new Contrat();
         formassurepret=new Assures();
         listassurepret=new ArrayList<>();
         selectassurepret=new Assures();
         selectgroup=new Groupe();
         formrenvlmntcontrat=new Contrat();
         rnouvelmentcontrat=new ArrayList<>();
         formgroupe=new Groupe();
         formgroupe.setPrimegroup(0.0);
         formgroupe.setSituationgroup(0.0);
         formgroupe.setTauxremisegroupe(Float.valueOf(0));
         typecontrat=new Typecontrat();
         selectrnouvelmentcontrat=new Contrat();
        
    }
     
    
    public void enregistrercontratgroupe(){
//        MessageBean m=new MessageBean();
        int id;
        int i=0;
    
        double primenettegrpe;
        double situationgrpe;
           if(formContrat.getTauxsupprime()==null){
            
            formContrat.setTauxsupprime(Float.valueOf(0));
        }
             if(formContrat.getCapitgarantitotale().intValue()==0 || formContrat.getTauxprime().intValue()==0 || formContrat.getDateexp().toString().trim().isEmpty() || formContrat.getDateeffet().toString().trim().isEmpty()
                || formContrat.getCodeapp()==null || formContrat.getIdgarantie()==null || formContrat.getIdmodeayement()==null  || selectoneradio.isEmpty()){
//            m.addMessageWarn("veuillez verifier les champs");
        }
             else{
                 if(formContrat.getDateeffet().getTime()>formContrat.getDateexp().getTime() || formContrat.getDateeffet().getTime()==formContrat.getDateexp().getTime() ){
//                m.addMessageWarn("incompatibilité des dates du contrat");
            }
                 else{
                    
                        selectgroup=groupeService.selectionner(formContrat.getIdgroupe().getIdgroupe());
          
           if(formassurepret!=null){
        formContrat.setCoutpiece(0.0);
        formContrat.setEtatcontrat("actif");
        formContrat.setDurecontrat(dureecontrat());
        formContrat.setPrimemontant(prime());
        formContrat.setPrimres(0.0);
        id=selectassurepret.getCodassure();
        formContrat.setCodassure(assuresService.selectionner(id));
               for (Contrat dataListContrat1 : dataListContrat) {
                   if(Objects.equals(dataListContrat1.getCodassure().getCodassure(), formContrat.getCodassure().getCodassure()) && dataListContrat1.getIdgroupe()==selectgroup){
                if (formContrat.getIdgarantie()==dataListContrat1.getIdgarantie()) {
                    i=i+1;
                }
                   }
               }
               if(i==0){
                    contratService.ajouter(formContrat);
        situationgrpe=selectgroup.getSituationgroup()+formContrat.getPrimemontant();
       
            selectgroup.setSituationgroup(situationgrpe);
       
        primenettegrpe=selectgroup.getPrimegroup()+formContrat.getPrimemontant();
        selectgroup.setPrimegroup(primenettegrpe);
        groupeService.modifier(selectgroup);
//        m.addMessageInfo("enregistré");
               }
               else{
//                  m.addMessageWarn("deja enregistré");
               }
       
           }
                     
                 }
             }
       
              
        
    }
     public  void nouveaucontrat(){
        formContrat=new Contrat();
        formassurepret=new Assures();
        selectassurepret=null;
    }
    
   public int ageassure(){
     Calendar calendar = new GregorianCalendar();
     LocalDate aujourdui=new LocalDate();
     calendar.setTime(selectassurepret.getDatnaisassure());
     int annee=calendar.get(Calendar.YEAR);
     int mois=calendar.get(Calendar.MONTH);
     int jours=calendar.get(Calendar.DAY_OF_MONTH);
     LocalDate naissance=new LocalDate(annee, mois, jours);
     Period p=new  Period(naissance,aujourdui,PeriodType.yearMonthDay());
     return p.getYears();  
    }
    public int ageassureren(){
     Calendar calendar = new GregorianCalendar();
     LocalDate aujourdui=new LocalDate();
     calendar.setTime(selectrnouvelmentcontrat.getCodassure().getDatnaisassure());
     int annee=calendar.get(Calendar.YEAR);
     int mois=calendar.get(Calendar.MONTH);
     int jours=calendar.get(Calendar.DAY_OF_MONTH);
     LocalDate naissance=new LocalDate(annee, mois, jours);
     Period p=new  Period(naissance,aujourdui,PeriodType.yearMonthDay());
     return p.getYears();  
    }
   
      public void enregistrerassure(){
        
             formassurepret.setGentreprise("oui");
             formassurepret.setStatutassur("actif");
             assuresService.ajouter(formassurepret);
             formassurepret=new Assures();
     }
   
    public int dureecontrat(){
        LocalDate dateeffet=new LocalDate(formContrat.getDateeffet().getTime());
        LocalDate datefin=new LocalDate(formContrat.getDateexp().getTime());
    return (Months.monthsBetween(dateeffet, datefin).getMonths());  
    }
    
        public int dureecontratren(){
    LocalDate dateeffet=new LocalDate(formrenvlmntcontrat.getDateeffet().getTime());
    LocalDate datefin=new LocalDate(formrenvlmntcontrat.getDateexp().getTime());
    return (Months.monthsBetween(dateeffet, datefin).getMonths());  
    }
      
    private double prime(){
        double capitini =formContrat.getCapitgarantitotale()/100;
        float toprime=formContrat.getTauxprime();
        float tosupprime=1+formContrat.getTauxsupprime();
        double primetot=capitini*toprime*tosupprime;
        return primetot;
    }
    private double primeren(){
        double capitini =formrenvlmntcontrat.getCapitgarantitotale()/100;
        float toprime=formrenvlmntcontrat.getTauxprime();
        float tosupprime=1+formrenvlmntcontrat.getTauxsupprime();
        double primetot=capitini*toprime*tosupprime;
        return primetot;
    }
    
     public void rowSelectedassure() {
         
         formassurepret = selectassurepret;
         this.index = this.listassurepret.indexOf(this.selectassurepret);
         this.desactiver=true;
         formassurepret.setAgeassur(ageassure());
    }
     public void rowselectedcontrate(){
         formgroupe=selectrnouvelmentcontrat.getIdgroupe();
         selectrnouvelmentcontrat.getCodassure().setAgeassur(ageassureren());
         formrenvlmntcontrat=selectrnouvelmentcontrat;
         this.index=this.rnouvelmentcontrat.indexOf(this.selectrnouvelmentcontrat);
         
         
     }
     public void rowselectcontratresilie(){
           selectrnouvelmentcontrat.getCodassure().setAgeassur(ageassureren());
         formrenvlmntcontrat=selectrnouvelmentcontrat;
         this.index=this.rnouvelmentcontrat.indexOf(this.selectrnouvelmentcontrat); 
     }
     public void selectedgroupe(){
        rnouvelmentcontrat=contratService.assurecontratgroupe(formContrat.getIdgroupe());
     }
     public void renouveler(){
//         MessageBean m=new MessageBean();
formgroupe=groupeService.selectionner(formContrat.getIdgroupe().getIdgroupe());
        if(selectrnouvelmentcontrat!=null){
               formrenvlmntcontrat.setDurecontrat(dureecontratren());
                formrenvlmntcontrat.setPrimemontant(primeren());
                formrenvlmntcontrat.setPrimres(0.0);
                contratService.modifier(formrenvlmntcontrat);
             double primenettegrpe = formgroupe.getPrimegroup()+selectrnouvelmentcontrat.getPrimemontant();
        formgroupe.setPrimegroup(primenettegrpe);
        groupeService.modifier(formgroupe);
//          m.addMessageInfo("contrat renouvelé");
          }
        else{
//            m.addMessageWarn("erreur lors du renouvellement");
           }
      
     }
     public void calculgrouperen(){
//         MessageBean m=new MessageBean();
         double ttc;
         double tot;
         double taxetot;
         double remise;
         int idtypecontrat;
         double accessoir = 0;
         float taxe = 0;
         typecontrats=new ArrayList<>();
         typecontrats=typecontratService.typecontratall();
         for (Typecontrat list : typecontrats) {
             if("groupe entreprise".equals(list.getLibtypecontrat())){
                 idtypecontrat=list.getIdtypecontrat();
                 accessoir=list.getAccessoires();
                 taxe=list.getTaxe();
             }
         }
         if(formgroupe!=null){
                     remise=formgroupe.getTauxremisegroupe()*formgroupe.getPrimegroup();
                     tot=(formgroupe.getPrimegroup()+accessoir)-remise;
                     taxetot=taxe/100*tot;
                     ttc=tot+taxetot+formgroupe.getSituationgroup();
                     formgroupe.setPrimettcgroupe(ttc);
                     formgroupe.setSituationgroup(0.0);
                     groupeService.modifier(formgroupe);
//           m.addMessageInfo("contrats Groupe"+formgroupe.getLibgroupe()+"renouvelés avec succès");
         }
         else{
//            m.addMessageWarn("erreur");
         }

     }
     public void calculgroupe(){
//          MessageBean m=new MessageBean();
         double ttc;
         double tot;
         double taxetot;
         double remise;
         int idtypecontrat;
         double accessoir = 0;
         float taxe = 0;
         typecontrats=new ArrayList<>();
         typecontrats=typecontratService.typecontratall();
         for (Typecontrat list : typecontrats) {
             if("groupe entreprise".equals(list.getLibtypecontrat())){
                 idtypecontrat=list.getIdtypecontrat();
                 accessoir=list.getAccessoires();
                 taxe=list.getTaxe();
             }
         }
         if(selectgroup!=null){
                     remise=selectgroup.getTauxremisegroupe()*selectgroup.getPrimegroup();
                     tot=(selectgroup.getPrimegroup()+accessoir)-remise;
                     taxetot=taxe/100*tot;
                     
                     
                     if("new".equals(selectoneradio)){
                     selectgroup.setSituationgroup(0.0);
                     }
                     else{
                         selectgroup.setSituationgroup(selectgroup.getSituationgroup()+formContrat.getPrimemontant());
                     }
                     ttc=tot+taxetot+selectgroup.getSituationgroup();
                     selectgroup.setPrimettcgroupe(ttc);
                     groupeService.modifier(selectgroup);
//           m.addMessageInfo("contrats Groupe   "+selectgroup.getLibgroupe()+"  renouvelés avec succès");
         }
         else{
//            m.addMessageWarn("erreur");
         }

     }
    public ContratServiceBeanLocal getContratService() {
        return contratService;
    }

    public void setContratService(ContratServiceBeanLocal contratService) {
        this.contratService = contratService;
    }

    public Contrat getFormContrat() {
        return formContrat;
    }

    public void setFormContrat(Contrat formContrat) {
        this.formContrat = formContrat;
    }

    public Contrat getSelectedContrat() {
        return selectedContrat;
    }

    public void setSelectedContrat(Contrat selectedContrat) {
        this.selectedContrat = selectedContrat;
    }

    public List<Contrat> getDataListContrat() {
        dataListContrat=contratService.contratall();
        return dataListContrat;
    }

    public void setDataListContrat(List<Contrat> dataListContrat) {
        this.dataListContrat = dataListContrat;
    }

    public Date getDatesais() {
        datesais=new Date();
        return datesais;
    }

    public void setDatesais(Date datesais) {
        this.datesais = datesais;
    }

    public Boolean getDesactiver() {
        return desactiver;
    }

    public void setDesactiver(Boolean desactiver) {
        this.desactiver = desactiver;
    }

    public Boolean getNouveauactif() {
        return nouveauactif;
    }

    public void setNouveauactif(Boolean nouveauactif) {
        this.nouveauactif = nouveauactif;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public GroupeServiceBeanLocal getGroupeService() {
        return groupeService;
    }

    public void setGroupeService(GroupeServiceBeanLocal groupeService) {
        this.groupeService = groupeService;
    }

    public AssuresServiceBeanLocal getAssuresService() {
        return assuresService;
    }

    public void setAssuresService(AssuresServiceBeanLocal assuresService) {
        this.assuresService = assuresService;
    }

    public Assures getFormassurepret() {
        return formassurepret;
    }

    public void setFormassurepret(Assures formassurepret) {
        this.formassurepret = formassurepret;
    }

    public List<Assures> getListassurepret() {
        listassurepret=assuresService.assureentreprise();
        return listassurepret;
    }

    public void setListassurepret(List<Assures> listassurepret) {
        this.listassurepret = listassurepret;
    }

    public Assures getSelectassurepret() {
        return selectassurepret;
    }

    public void setSelectassurepret(Assures selectassurepret) {
        this.selectassurepret = selectassurepret;
    }

    public Groupe getSelectgroup() {
        return selectgroup;
    }

    public void setSelectgroup(Groupe selectgroup) {
        this.selectgroup = selectgroup;
    }

    public List<Contrat> getRnouvelmentcontrat() {
        rnouvelmentcontrat=contratService.assurecontratgroupe(formContrat.getIdgroupe());
        return rnouvelmentcontrat;
    }

    public void setRnouvelmentcontrat(List<Contrat> rnouvelmentcontrat) {
        
        this.rnouvelmentcontrat = rnouvelmentcontrat;
    }

    public Groupe getFormgroupe() {
        return formgroupe;
    }

    public void setFormgroupe(Groupe formgroupe) {
        this.formgroupe = formgroupe;
    }

    public Contrat getSelectrnouvelmentcontrat() {
        return selectrnouvelmentcontrat;
    }

    public void setSelectrnouvelmentcontrat(Contrat selectrnouvelmentcontrat) {
        this.selectrnouvelmentcontrat = selectrnouvelmentcontrat;
    }

    public Contrat getFormrenvlmntcontrat() {
        return formrenvlmntcontrat;
    }

    public void setFormrenvlmntcontrat(Contrat formrenvlmntcontrat) {
        this.formrenvlmntcontrat = formrenvlmntcontrat;
    }

    public TypecontratServiceBeanLocal getTypecontratService() {
        return typecontratService;
    }

    public void setTypecontratService(TypecontratServiceBeanLocal typecontratService) {
        this.typecontratService = typecontratService;
    }

    public Typecontrat getTypecontrat() {
        return typecontrat;
    }

    public void setTypecontrat(Typecontrat typecontrat) {
        this.typecontrat = typecontrat;
    }

    public List<Typecontrat> getTypecontrats() {
        typecontrats=typecontratService.typecontratall();
        return typecontrats;
    }

    public void setTypecontrats(List<Typecontrat> typecontrats) {
        this.typecontrats = typecontrats;
    }

    public String getSelectoneradio() {
        return selectoneradio;
    }

    public void setSelectoneradio(String selectoneradio) {
        this.selectoneradio = selectoneradio;
    }

    public List<Contrat> getDatalistefiltre() {
        return datalistefiltre;
    }

    public void setDatalistefiltre(List<Contrat> datalistefiltre) {
        this.datalistefiltre = datalistefiltre;
    }
    
    
   
   
    
    
}
