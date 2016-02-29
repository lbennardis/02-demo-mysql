package org.pongmatcher.repositories;

import java.util.List;

 


import org.pongmatcher.domain.Stazione;
import org.springframework.data.repository.Repository;




public interface StazioniNamedQueryRepository extends Repository<Stazione, Long> {
	// Query will be used from Named query defined at Entity class
	List<Stazione> findNearest(long lon, long lat, long dist);
}
