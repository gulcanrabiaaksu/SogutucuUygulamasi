package pkt;

public class Eyleyici implements IEyleyici{
    IEkran ekran =new Ekran();
    @Override
    public void sogutucuAc() {
        ekran.mesajGoruntule("Soğutucu çalıştırılıyor,lütfen bekleyiniz.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ekran.mesajGoruntule("Sogutucu açık.");
    }
    @Override
    public void sogutucuKapat() {
        ekran.mesajGoruntule("Soğutucu kapatılıyor,lütfen bekleyiniz.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ekran.mesajGoruntule("Sogutu kapalı.");
    }
}
