package pkt;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{

    IEkran ekran;
    private int sicaklik_olcumu;
    private ISubject publisher;
    private Random random;
    //Dependency Inversion:bağımlılıgın azaltılması ve interfaceler uzerınden işlem yapma

    public SicaklikAlgilayici(ISubject publisher){
        ekran=new Ekran();
        random =new Random();
        this.publisher=publisher;
    }


    @Override
    public void kullaniciEkle(IObserver kullanici){
        publisher.attach(kullanici);
    }
    @Override
    public void sicaklikGonder() {
        try{
            //MAKSİMUM SAYI - MİNİMUM SAYI +1
            //-50 ile 60 derece arasındaki sıcaklıgı almak için : 60--50+1 =111
            ekran.mesajGoruntule("Sıcaklık ölçülüyor,lütfen bekleyiniz...");
            Thread.sleep(1000);
            sicaklik_olcumu = random.nextInt(111)-50;
            ekran.mesajGoruntule("Ortam Sıcaklığı :"+ sicaklik_olcumu);

            if(sicaklik_olcumu>35){
                publisher.notify("Sıcaklık 35 derecenin üzerine çıktı, soğutucuyu açmanız tavsiye edilir.");
            }
            if(sicaklik_olcumu<-10){
                    publisher.notify("Sıcaklık -10 derecenin altına indi, soğutucuyu kapatmanız tavsiye edilir.");
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
