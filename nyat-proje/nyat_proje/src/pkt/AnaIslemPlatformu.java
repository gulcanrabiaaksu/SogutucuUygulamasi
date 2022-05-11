package pkt;

public class AnaIslemPlatformu {

    IEyleyici eyleyici;
    ISicaklikAlgilayici sicaklikAlgilayici;

    public AnaIslemPlatformu() { //constructor

        //Dependency Inversion:bağımlılıgın azaltılması ve interfaceler uzerınden işlem yapma
        eyleyici= new Eyleyici();
        sicaklikAlgilayici=new SicaklikAlgilayici(new Publisher());

        //kullanıcı ekleme
        IObserver kullanici1 =new Kullanici1();
        sicaklikAlgilayici.kullaniciEkle(kullanici1);
        IObserver kullanici2 =new Kullanici2();
        sicaklikAlgilayici.kullaniciEkle(kullanici2);
    }
    public void sicaklikOku()  {
        sicaklikAlgilayici.sicaklikGonder();
    }
    public void eyleyiciyiCalistir(String islem) {
        if(islem.equals("acma-Istegi")){
            eyleyici.sogutucuAc();
        }
        else if(islem.equals("kapatma-Istegi")){
            eyleyici.sogutucuKapat();
        }
    }
}
