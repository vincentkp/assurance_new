package com.contrat.service.deces;

import javax.ejb.Local;
import com.contrat.entities.Contrat;
import com.contrat.entities.Groupe;
import com.contrat.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ContratServiceBeanLocal extends BaseServiceBeanLocal<Contrat, Integer> {
      List<Contrat> contratall();
    List<Contrat> contratentreprise();
    List<Contrat> contratresilie();
     List<Contrat> assurecontratgroupe(Groupe gr);
     List<Contrat> autregroupe();
    Double sommecapitale();
    Double sommeprime();
}