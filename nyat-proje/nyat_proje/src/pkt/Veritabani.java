package pkt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Veritabani {
    IEkran ekran;
    ArrayList<String> kullaniciAdlari = new ArrayList<String>();
    ArrayList<Integer> kullaniciSifreleri = new ArrayList<Integer>();

    static final String DB_URL = "jdbc:postgresql://localhost/nyat_proje";
    static final String USER = "postgres";
    static final String PASS = "gulcann";
    static final String QUERY = "SELECT kullaniciadi, sifre FROM kullanici";

    public Veritabani() { //constructor
        ekran = new Ekran();
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            if (conn != null)
                ekran.mesajGoruntule("Veritabanına başarıyla bağlanıldı.");
            else
                ekran.mesajGoruntule("Veritabanı bağlantısı gerçekleştirilemedi.");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            conn.close();

            String kullaniciAdi;
            int sifre;

            while(rs.next())
            {
                kullaniciAdi  = rs.getString("kullaniciadi");
                sifre = rs.getInt("sifre");

                kullaniciAdlari.add(kullaniciAdi);
                kullaniciSifreleri.add(sifre);
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public boolean kullaniciAdiDogrula(String kullaniciAdi) throws InterruptedException {
        ekran.mesajGoruntule("Doğrulama Yapılıyor, lütfen bekleyiniz.");
        Thread.sleep(1000);
        for (int i = kullaniciAdlari.size() - 1; i >= 0; i--) {
            if (kullaniciAdlari.get(i).equals(kullaniciAdi)) {
                ekran.mesajGoruntule("Kullanıcı adı doğrulandı. ");
                Thread.sleep(100);
                return true;
            }
        }
        return false;
    }
    public boolean kullaniciSifreDogrula(String kullaniciAdi, int sifre)  {
        for (int i =0; i <kullaniciAdlari.size(); i++){
            if (kullaniciAdlari.get(i).equals(kullaniciAdi)){
                if (kullaniciSifreleri.get(i).equals(sifre)) {
                    ekran.mesajGoruntule("Şifre doğrulandı.");
                    return true;
                }
            }
        }
        return false;
    }
}