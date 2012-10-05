package com.mycompany.masraflarwebapp;

import java.text.ParseException;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.mycompany.masraflarwebapp.dao.HibernateUtil;
import com.mycompany.masraflarwebapp.pojo.PersonelMasraf;
import com.mycompany.masraflarwebapp.pojo.PersonelMasrafDetay;
import com.mycompany.masraflarwebapp.util.masraflarUtil;

public class Masraflar {

	private Double taxi;
	private Double yemek;
	private Double benzin;
	private Double diger;
	private String aciklama;
	private Date tarih;

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public Double getTaxi() {
		return taxi;
	}

	public void setTaxi(Double taxi) {
		this.taxi = taxi;
	}

	public Double getYemek() {
		return yemek;
	}

	public void setYemek(Double yemek) {
		this.yemek = yemek;
	}

	public Double getBenzin() {
		return benzin;
	}

	public void setBenzin(Double benzin) {
		this.benzin = benzin;
	}

	public Double getDiger() {
		return diger;
	}

	public void setDiger(Double diger) {
		this.diger = diger;
	}

	public String Topla() {
		Double toplam = taxi + yemek + benzin + diger;
		String strToplam;
		strToplam = Double.toString(toplam);
		return strToplam;
	}

	public void kaydet(ActionEvent event) throws ParseException {

		String kullanici = "Haluk";

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			PersonelMasraf masraf = new PersonelMasraf();

			masraf.setAraOnayliMi("0");
			masraf.setMasrafTarihi(masraflarUtil.dateToMysolFormat(tarih));
			masraf.setId(2);
			masraf.setAraOnayliMi("0");
			masraf.setMasrafAciklama(aciklama.toString());
			masraf.setPersonelId("1");
			masraf.setAraOnayliMi("0");
			masraf.setTamOnayliMi("0");

			HibernateUtil util = new HibernateUtil();

			util.save(masraf);
			SaveMasrafDetails(masraf, util);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			context.addMessage(	null,new FacesMessage("Form Gönderilirken bir hata oluştu.Lütfen yöneticinize başvurunuz."));
		}
		context.addMessage(null, new FacesMessage("Formunuz Başarıyla Gönderilmiştir..." + kullanici));
	}

	private void SaveMasrafDetails(PersonelMasraf masraf, HibernateUtil util) {
		PersonelMasrafDetay detayTaksi = new PersonelMasrafDetay();
		detayTaksi.setFkPersonelMasrafId(masraf.getId());
		detayTaksi.setFkRefMasrafKodu("TAXI");
		detayTaksi.setTutar(taxi.toString());

		PersonelMasrafDetay detayYemek = new PersonelMasrafDetay();
		detayYemek.setFkPersonelMasrafId(masraf.getId());
		detayYemek.setFkRefMasrafKodu("YEMEK");
		detayYemek.setTutar(yemek.toString());

		PersonelMasrafDetay detayBenzin = new PersonelMasrafDetay();
		detayBenzin.setFkPersonelMasrafId(masraf.getId());
		detayBenzin.setFkRefMasrafKodu("BENZIN");
		detayBenzin.setTutar(benzin.toString());

		PersonelMasrafDetay detayDiger = new PersonelMasrafDetay();
		detayDiger.setFkPersonelMasrafId(masraf.getId());
		detayDiger.setFkRefMasrafKodu("DIGER");
		detayDiger.setTutar(diger.toString());

		util.save(detayTaksi);
		util.save(detayYemek);
		util.save(detayBenzin);
		util.save(detayDiger);
	}

}
