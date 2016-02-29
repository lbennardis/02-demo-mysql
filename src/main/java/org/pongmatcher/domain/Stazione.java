package org.pongmatcher.domain;
import java.io.Serializable;

 



import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Stazione.findNearest",query="SELECT nome,indirizzo,citta,latitudine,longitudine,3956 * 2 * "
		+ "(ASIN(SQRT(POWER(SIN(?1 - abs(dest.latitudine)) "
		+ "* pi()/180/2),2) + COS(?1 * pi()/180 )*COS(abs(dest.latitudine) *  pi()/180) "
		+ "*POWER (SIN((?2 - dest.longitudine)) *  pi()/180/2,2)))) "
		+ "as distance FROM indirizzi dest having distance < ?3 ORDER BY distance limit 10" )
public class Stazione implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	@Column(name="nome")
	String name;
	@Column(name="indirizzo")
	String indirizzo;
	@Column(name="citta")
	String citta;
	@Column(name="latitudine")
	long latitudine;
	@Column(name="longitudine")
	long longitudine;
	@Column(name="distanza")
	long distanza;
	
	
	
	
	
	
	
	

	public String getName() {
		return name;
	}









	public void setName(String name) {
		this.name = name;
	}









	public String getIndirizzo() {
		return indirizzo;
	}









	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}









	public String getCitta() {
		return citta;
	}









	public void setCitta(String citta) {
		this.citta = citta;
	}









	public long getLatitudine() {
		return latitudine;
	}









	public void setLatitudine(long latitudine) {
		this.latitudine = latitudine;
	}









	public long getLongitudine() {
		return longitudine;
	}









	public void setLongitudine(long longitudine) {
		this.longitudine = longitudine;
	}









	public long getDistanza() {
		return distanza;
	}









	public void setDistanza(long distanza) {
		this.distanza = distanza;
	}









	private String compilaquery() {
		// TODO Auto-generated method stub
StringBuilder comandoSql = new StringBuilder();
		
		//@orig_lat ?1
		//@orig_lon ?2
		//@dist ?3
		
		comandoSql.append("SELECT nome,indirizzo,citta,latitudine,longitudine,");
		
		comandoSql.append("3956 * 2 * (ASIN(");
		
		comandoSql.append("SQRT(POWER(SIN(");
		
		comandoSql.append("(?1 - abs(dest.latitudine)) * pi()/180/2),2)");
		
		comandoSql.append("+ COS(?1 * pi()/180 )* ");
		
		comandoSql.append("COS(abs(dest.latitudine) *  pi()/180)");
		
		comandoSql.append("*POWER (SIN((?2 - dest.longitudine)) *  pi()/180/2,2))))");
		
		comandoSql.append("as distance FROM indirizzi dest having distance < ?3 ORDER BY distance limit 10");
				
				
		
		
		
		return comandoSql.toString();
	}
	
	
	
}
