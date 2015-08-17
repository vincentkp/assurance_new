package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Modepayement;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ModepayementServiceBeanLocal extends BaseServiceBeanLocal<Modepayement, Integer> {
    List<Modepayement> listmodepayementall();
}