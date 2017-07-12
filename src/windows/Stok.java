package windows;

import java.text.SimpleDateFormat;
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
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date now = new Date();
	String strDate = sdfDate.format(now);
	this.olusturmaTarihi = strDate;
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


public boolean isEmpty()
{
	if (!stokKodu.equals("") && !stokAdi.equals("") && !barKodu.equals("") && !aciklama.equals("") && !olusturmaTarihi.equals("") && stokTipi != 0 && birim != 0 && kdvTipi != 0)
		return false;
	else
		return true;
}
}
