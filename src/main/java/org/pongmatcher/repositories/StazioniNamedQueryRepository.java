package org.pongmatcher.repositories;

import java.util.List;

import org.pongmatcher.domain.Stazione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StazioniNamedQueryRepository extends Repository<Stazione, Long> {
	// Query will be used from Named query defined at Entity class
	@Query 
	List<Stazione> findNearest(@Param(value = "latitudine") long latitudine, 
			@Param(value = "longitudine") long longitudine, @Param(value = "distanza") long distanza );
	//List<Stazione> findNearest(long latitudine, long longitudine, long distanza);
	
	//List<OwnerModel> findByFirstNameAndAgeNotZero(@Param(value = "latitudine") long latitudine, value = "longitudine") long latitudine,);
}
