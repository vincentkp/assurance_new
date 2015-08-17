package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Contrat;
import com.contrat.entities.Groupe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ContratDaoBeanLocal extends BaseDaoBeanLocal<Contrat, Integer>{
    List<Contrat> contratall();
    List<Contrat> contratentreprise();
    List<Contrat> assurecontratgroupe(Groupe gr);
    List<Contrat> contratresilie();
    List<Contrat> autregroupe();
    Double sommecapitale();
    Double sommeprime();
    
    
}