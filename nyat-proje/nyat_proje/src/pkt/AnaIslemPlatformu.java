package pkt;

public class AnaIslemPlatformu {

    IEyleyici eyleyici;
    ISicaklikAlgilayici sicaklikAlgilayici;

    public AnaIslemPlatformu() { //constructor

        eyleyici=Factory.eyleyici();  //FACTORY METHOD
        sicaklikAlgilayici=new SicaklikAlgilayici(new Publisher());

        //kullanıcı ekleme
        IObserver kullanici1 =Factory.observer();  //factory method
        sicaklikAlgilayici.kullaniciEkle(kullanici1);
        IObserver kullanici2 =Factory.observer2();  //factory method
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
