/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contrat.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desire.mensah
 */
@Entity
@Table(catalog = "contrat", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c"),
    @NamedQuery(name = "Contrat.findByNumpolice", query = "SELECT c FROM Contrat c WHERE c.numpolice = :numpolice"),
    @NamedQuery(name = "Contrat.findByCapitgarantitotale", query = "SELECT c FROM Contrat c WHERE c.capitgarantitotale = :capitgarantitotale"),
    @NamedQuery(name = "Contrat.findByCaracterecontrat", query = "SELECT c FROM Contrat c WHERE c.caracterecontrat = :caracterecontrat"),
    @NamedQuery(name = "Contrat.findByCoutpiece", query = "SELECT c FROM Contrat c WHERE c.coutpiece = :coutpiece"),
    @NamedQuery(name = "Contrat.findByDateeffet", query = "SELECT c FROM Contrat c WHERE c.dateeffet = :dateeffet"),
    @NamedQuery(name = "Contrat.findByDateexp", query = "SELECT c FROM Contrat c WHERE c.dateexp = :dateexp"),
    @NamedQuery(name = "Contrat.findByDatesaisie", query = "SELECT c FROM Contrat c WHERE c.datesaisie = :datesaisie"),
    @NamedQuery(name = "Contrat.findByDurecontrat", query = "SELECT c FROM Contrat c WHERE c.durecontrat = :durecontrat"),
    @NamedQuery(name = "Contrat.findByEtatcontrat", query = "SELECT c FROM Contrat c WHERE c.etatcontrat = :etatcontrat"),
    @NamedQuery(name = "Contrat.findByPrimemontant", query = "SELECT c FROM Contrat c WHERE c.primemontant = :primemontant"),
    @NamedQuery(name = "Contrat.findByPrimres", query = "SELECT c FROM Contrat c WHERE c.primres = :primres"),
    @NamedQuery(name = "Contrat.findByRapportmedical", query = "SELECT c FROM Contrat c WHERE c.rapportmedical = :rapportmedical"),
    @NamedQuery(name = "Contrat.findByTauxprime", query = "SELECT c FROM Contrat c WHERE c.tauxprime = :tauxprime"),
    @NamedQuery(name = "Contrat.findByTauxremise", query = "SELECT c FROM Contrat c WHERE c.tauxremise = :tauxremise"),
    @NamedQuery(name = "Contrat.findByTauxsupprime", query = "SELECT c FROM Contrat c WHERE c.tauxsupprime = :tauxsupprime")})
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer numpolice;
    private Double capitgarantitotale;
    @Size(max = 255)
    @Column(length = 255)
    private String caracterecontrat;
     @Size(max = 255)
    @Column(length = 255)
    private String referencepret;
    private Double coutpiece;
    @Temporal(TemporalType.DATE)
    private Date dateeffet;
    @Temporal(TemporalType.DATE)
    private Date dateexp;
    @Temporal(TemporalType.DATE)
    private Date datesaisie;
    private Integer durecontrat;
    @Size(max = 255)
    @Column(length = 255)
    private String etatcontrat;
    private Double primemontant;
    private Double primeTTC;
    private Double primres;
    @Size(max = 255)
    @Column(length = 255)
    private String rapportmedical;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53)
    private Float tauxprime;
    @Column(precision = 53)
    private Float tauxremise;
     @Column(precision = 53)
    private Float tauxpenalite;
    @Column(precision = 53)
    private Float tauxsupprime;
    @OneToMany(mappedBy = "numpolice", fetch = FetchType.LAZY)
    private List<Dossiersinistre> dossiersinistreList;
    @JoinColumn(name = "codeapp", referencedColumnName = "codeapp")
    @ManyToOne(fetch = FetchType.LAZY)
    private Apporteur codeapp;
    @JoinColumn(name = "codassure", referencedColumnName = "codassure")
    @ManyToOne(fetch = FetchType.LAZY)
    private Assures codassure;
    @JoinColumn(name = "idgarantie", referencedColumnName = "idgarantie")
    @ManyToOne(fetch = FetchType.LAZY)
    private Garantie idgarantie;
    @JoinColumn(name = "idgroupe", referencedColumnName = "idgroupe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Groupe idgroupe;
    @JoinColumn(name = "idmodeayement", referencedColumnName = "idmodeayement")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modepayement idmodeayement;
    @JoinColumn(name = "idproducteur", referencedColumnName = "idproducteur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producteur idproducteur;
    @JoinColumn(name = "idtypecontrat", referencedColumnName = "idtypecontrat")
    @ManyToOne(fetch = FetchType.LAZY)
    private Typecontrat idtypecontrat;
    @OneToMany(mappedBy = "numpolice", fetch = FetchType.LAZY)
    private List<Coassurance> coassuranceList;
    @OneToMany(mappedBy = "numpolice", fetch = FetchType.LAZY)
    private List<Reassurance> reassuranceList;

    public Contrat() {
    }

    public Contrat(Integer numpolice) {
        this.numpolice = numpolice;
    }

    public Integer getNumpolice() {
        return numpolice;
    }

    public void setNumpolice(Integer numpolice) {
        this.numpolice = numpolice;
    }

    public Double getCapitgarantitotale() {
        return capitgarantitotale;
    }

    public void setCapitgarantitotale(Double capitgarantitotale) {
        this.capitgarantitotale = capitgarantitotale;
    }

    public String getReferencepret() {
        return referencepret;
    }

    public void setReferencepret(String referencepret) {
        this.referencepret = referencepret;
    }
    

    public Double getCoutpiece() {
        return coutpiece;
    }

    public void setCoutpiece(Double coutpiece) {
        this.coutpiece = coutpiece;
    }

    public Double getPrimemontant() {
        return primemontant;
    }

    public void setPrimemontant(Double primemontant) {
        this.primemontant = primemontant;
    }

    public Double getPrimres() {
        return primres;
    }

    public void setPrimres(Double primres) {
        this.primres = primres;
    }

    public Float getTauxprime() {
        return tauxprime;
    }

    public void setTauxprime(Float tauxprime) {
        this.tauxprime = tauxprime;
    }

    public Float getTauxremise() {
        return tauxremise;
    }

    public void setTauxremise(Float tauxremise) {
        this.tauxremise = tauxremise;
    }

    public Float getTauxsupprime() {
        return tauxsupprime;
    }

    public void setTauxsupprime(Float tauxsupprime) {
        this.tauxsupprime = tauxsupprime;
    }

  

    public String getCaracterecontrat() {
        return caracterecontrat;
    }

    public void setCaracterecontrat(String caracterecontrat) {
        this.caracterecontrat = caracterecontrat;
    }



    public Date getDateeffet() {
        return dateeffet;
    }

    public void setDateeffet(Date dateeffet) {
        this.dateeffet = dateeffet;
    }

    public Date getDateexp() {
        return dateexp;
    }

    public void setDateexp(Date dateexp) {
        this.dateexp = dateexp;
    }

    public Date getDatesaisie() {
        return datesaisie;
    }

    public void setDatesaisie(Date datesaisie) {
        this.datesaisie = datesaisie;
    }

    public Integer getDurecontrat() {
        return durecontrat;
    }

    public void setDurecontrat(Integer durecontrat) {
        this.durecontrat = durecontrat;
    }

    public String getEtatcontrat() {
        return etatcontrat;
    }

    public void setEtatcontrat(String etatcontrat) {
        this.etatcontrat = etatcontrat;
    }

 

    public String getRapportmedical() {
        return rapportmedical;
    }

    public void setRapportmedical(String rapportmedical) {
        this.rapportmedical = rapportmedical;
    }

 

    @XmlTransient
    public List<Dossiersinistre> getDossiersinistreList() {
        return dossiersinistreList;
    }

    public void setDossiersinistreList(List<Dossiersinistre> dossiersinistreList) {
        this.dossiersinistreList = dossiersinistreList;
    }

    public Apporteur getCodeapp() {
        return codeapp;
    }

    public void setCodeapp(Apporteur codeapp) {
        this.codeapp = codeapp;
    }

    public Assures getCodassure() {
        return codassure;
    }

    public void setCodassure(Assures codassure) {
        this.codassure = codassure;
    }

    public Garantie getIdgarantie() {
        return idgarantie;
    }

    public void setIdgarantie(Garantie idgarantie) {
        this.idgarantie = idgarantie;
    }

    public Groupe getIdgroupe() {
        return idgroupe;
    }

    public void setIdgroupe(Groupe idgroupe) {
        this.idgroupe = idgroupe;
    }

    public Modepayement getIdmodeayement() {
        return idmodeayement;
    }

    public void setIdmodeayement(Modepayement idmodeayement) {
        this.idmodeayement = idmodeayement;
    }

    public Producteur getIdproducteur() {
        return idproducteur;
    }

    public void setIdproducteur(Producteur idproducteur) {
        this.idproducteur = idproducteur;
    }

    public Typecontrat getIdtypecontrat() {
        return idtypecontrat;
    }

    public void setIdtypecontrat(Typecontrat idtypecontrat) {
        this.idtypecontrat = idtypecontrat;
    }

    @XmlTransient
    public List<Coassurance> getCoassuranceList() {
        return coassuranceList;
    }

    public void setCoassuranceList(List<Coassurance> coassuranceList) {
        this.coassuranceList = coassuranceList;
    }

    @XmlTransient
    public List<Reassurance> getReassuranceList() {
        return reassuranceList;
    }

    public void setReassuranceList(List<Reassurance> reassuranceList) {
        this.reassuranceList = reassuranceList;
    }

    public Double getPrimeTTC() {
        return primeTTC;
    }

    public void setPrimeTTC(Double primeTTC) {
        this.primeTTC = primeTTC;
    }

    public Float getTauxpenalite() {
        return tauxpenalite;
    }

    public void setTauxpenalite(Float tauxpenalite) {
        this.tauxpenalite = tauxpenalite;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numpolice != null ? numpolice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.numpolice == null && other.numpolice != null) || (this.numpolice != null && !this.numpolice.equals(other.numpolice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.contrat.entities.Contrat[ numpolice=" + numpolice + " ]";
    }
    
}
