package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Souscripteur;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface SouscripteurServiceBeanLocal extends BaseServiceBeanLocal<Souscripteur, Integer> {
    List<Souscripteur> souscripteurall();
}