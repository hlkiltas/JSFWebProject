package com.mycompany.masraflarwebapp.pojo;

// Generated Oct 5, 2012 2:18:57 PM by Hibernate Tools 3.4.0.CR1

/**
 * RefMasraf generated by hbm2java
 */
public class RefMasraf implements java.io.Serializable {

	private Integer id;
	private String kodu;
	private String adi;

	public RefMasraf() {
	}

	public RefMasraf(String kodu, String adi) {
		this.kodu = kodu;
		this.adi = adi;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodu() {
		return this.kodu;
	}

	public void setKodu(String kodu) {
		this.kodu = kodu;
	}

	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

}
