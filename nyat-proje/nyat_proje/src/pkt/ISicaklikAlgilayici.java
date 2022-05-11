package pkt;

public interface ISicaklikAlgilayici {
    void kullaniciEkle(IObserver kullanici);
    void sicaklikGonder();
}
