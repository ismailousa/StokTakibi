package windows;

import java.util.*;

public class Stok {
	
int Id;	
String stokKodu;
String stokAdi;
int stokTipi;
int birim;
String barKodu;
int kdvTipi;
String aciklama;
String olusturmaTarihi; 

public Stok(String stokKodu,String stokAdi,int stokTipi,int birim,String barKodu,int kdvTipi,String aciklama)
{
	this.stokKodu = stokKodu;
	this.stokAdi = stokAdi;
	this.stokTipi = stokTipi;
	this.birim = birim;
	this.barKodu = barKodu;
	this.kdvTipi = kdvTipi;
	this.aciklama = aciklama;
	this.olusturmaTarihi = "2017/06/12 10:24:22";//Calendar.getInstance().getTime();
}

public String getStokKodu()
{
	return this.stokKodu;
}

public void setStokKodu(String value)
{
	stokKodu = value;
}

public String getStokAdi()
{
	return this.stokAdi;
}

public void setStokAdi(String value)
{
	stokAdi = value;
}

public String getBarKodu()
{
	return this.barKodu;
}

public void setBarKodu(String value)
{
	barKodu = value;
}

public String getAciklama()
{
	return this.aciklama;
}

public void setAciklama(String value)
{
	aciklama = value;
}

public int getId()
{
	return this.Id;
}

public void setId(int value)
{
	Id = value;
}

public int getStokTipi()
{
	return this.stokTipi;
}

public void setStokTipi(int value)
{
	stokTipi = value;
}

public int getBirim()
{
	return this.birim;
}

public void setBirim(int value)
{
	birim = value;
}

public double getKdvTipi()
{
	return this.kdvTipi;
}

public void setKdvTipi(int value)
{
	kdvTipi = value;
}

public String getOlusturmaTarihi()
{
	return this.olusturmaTarihi;
}

public void setOlusturmaTarihi(String value)
{
	olusturmaTarihi = value;
}
}
