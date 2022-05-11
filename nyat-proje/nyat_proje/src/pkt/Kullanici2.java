package pkt;

public class Kullanici2 implements IObserver{
    @Override
    public void update(String message) {
        System.out.println("Kullanıcı 2'ye gelen mesaj : "+message);
    }
}
