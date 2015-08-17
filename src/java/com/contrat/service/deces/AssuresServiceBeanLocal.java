package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Assures;
import com.contrat.entities.Souscripteur;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface AssuresServiceBeanLocal extends BaseServiceBeanLocal<Assures, Integer> {
    List<Assures> assureall();
     List<Assures> assureentreprise();
    Integer moyenneage();
}