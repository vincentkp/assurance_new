package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Reassureurs;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ReassureursServiceBeanLocal extends BaseServiceBeanLocal<Reassureurs, Integer> {
    List<Reassureurs> reassureurall();
    List<Reassureurs> recherchereassureurnom(String nom);
}