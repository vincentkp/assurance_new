package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Groupe;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface GroupeServiceBeanLocal extends BaseServiceBeanLocal<Groupe, Integer> {
    List<Groupe> groupeall();
}