package com.contrat.entities;

import com.contrat.entities.Typeapporteur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-15T13:11:55")
@StaticMetamodel(Apporteur.class)
public class Apporteur_ { 

    public static volatile SingularAttribute<Apporteur, String> nomapp;
    public static volatile SingularAttribute<Apporteur, String> telapp;
    public static volatile SingularAttribute<Apporteur, String> statutapp;
    public static volatile SingularAttribute<Apporteur, Integer> codeapp;
    public static volatile SingularAttribute<Apporteur, String> adresseapp;
    public static volatile SingularAttribute<Apporteur, Typeapporteur> idtypeapporteur;
    public static volatile SingularAttribute<Apporteur, Double> montantapp;
    public static volatile SingularAttribute<Apporteur, Float> commissionapp;

}