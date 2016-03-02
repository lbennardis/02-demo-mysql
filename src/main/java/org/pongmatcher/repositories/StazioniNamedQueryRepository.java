package org.pongmatcher.repositories;

import java.util.List;

import org.pongmatcher.domain.Indirizzi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StazioniNamedQueryRepository extends Repository<Indirizzi, Long> {
	// Query will be used from Named query defined at Entity class
	@Query 
	public List<Indirizzi> findNearest(@Param(value = "latitudine") long latitudine, 
		@Param(value = "longitudine") long longitudine, @Param(value = "distanza") Double distanza );
	//List<Indirizzi> findNearest();
	//List<Stazione> findNearest(long latitudine, long longitudine, long distanza);
	
	//List<OwnerModel> findByFirstNameAndAgeNotZero(@Param(value = "latitudine") long latitudine, value = "longitudine") long latitudine,);
}
