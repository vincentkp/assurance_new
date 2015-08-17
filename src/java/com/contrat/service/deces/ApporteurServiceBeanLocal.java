package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Apporteur;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ApporteurServiceBeanLocal extends BaseServiceBeanLocal<Apporteur, Integer> {
    List<Apporteur> apporteurall();
    List<Apporteur> recherchenom(String nom);
}