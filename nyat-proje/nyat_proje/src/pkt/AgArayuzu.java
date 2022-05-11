package pkt;
import java.util.Scanner;

public class AgArayuzu {

    AnaIslemPlatformu anaIslemPlatformu;
    IEkran ekran;
    Veritabani veritabani;

    //kullanıcı dogrulama
    String kullaniciAdi;
    int sifre;
    boolean giris_ad = false;
    boolean giris_sifre= false;

    //ISLEMLER
    private static final int SICAKLIK_OLCUMU = 1;
    private static final int SOGUTUCU_AC = 2;
    private static final int SOGUTUCU_KAPAT = 3;
    private static final int CIKIS = 4;

    public AgArayuzu() { //constructor
        anaIslemPlatformu = new AnaIslemPlatformu();
        veritabani=new Veritabani();
        ekran=new Ekran();
    }
    public void basla() throws InterruptedException {
        //kullanıcı dogrulama
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Kullanici Adinizi Giriniz: ");
            kullaniciAdi = scanner.next();

            if(veritabani.kullaniciAdiDogrula(kullaniciAdi)){
                giris_ad=true;
                System.out.print("Sifrenizi Giriniz: ");
                sifre = scanner.nextInt();
            }
            else{
                System.out.println("kullanıcı adınız yanlış.");
                giris_ad=false;
            }
            if(giris_ad){
                if(veritabani.kullaniciSifreDogrula(kullaniciAdi,sifre)){
                    giris_sifre=true;
                    this.islemSecimi();
                }
                else{
                    System.out.println("kullanıcı sifresi yanlış.");
                    giris_sifre=false;
                }
            }
        }while(!(giris_ad && giris_sifre));
    }
    public void islemSecimi() {
        int secim;
        do {
            secim=this.MenuyuListele();
            ekran.ekranTemizle();
            switch(secim) {
                case SICAKLIK_OLCUMU:
                    anaIslemPlatformu.sicaklikOku();
                    break;
                case SOGUTUCU_AC:
                    this.sogutucuAcmaIstegi();
                    break;
                case SOGUTUCU_KAPAT:
                    this.sogutucuKapatmaIstegi();
                    break;
                case CIKIS:
                    ekran.mesajGoruntule("Çıkış Yapıldı.");
                    break;
                default:
                    ekran.mesajGoruntule("Lütfen geçerli bir sayı giriniz!");
                    break;
            }
        }while(secim!=4);
    }
    private int MenuyuListele() {
        Scanner oku = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("1-SICAKLIK GÖRÜNTÜLE");
        System.out.println("2-SOĞUTUCUYU AÇ");
        System.out.println("3-SOĞUTUCUYU KAPAT");
        System.out.println("4-ÇIKIŞ YAP");
        System.out.println("---------------------------");

        return oku.nextInt() ;
    }
    public void sogutucuAcmaIstegi()  {
        anaIslemPlatformu.eyleyiciyiCalistir("acma-Istegi");
    }

    public void sogutucuKapatmaIstegi() {
        anaIslemPlatformu.eyleyiciyiCalistir("kapatma-Istegi");
    }
}