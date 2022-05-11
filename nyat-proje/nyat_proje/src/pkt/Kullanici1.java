package pkt;

public class Kullanici1 implements IObserver{
    @Override
    public void update(String message) {
        System.out.println("Kullanıcı 1'e gelen mesaj : "+message);
    }
}
