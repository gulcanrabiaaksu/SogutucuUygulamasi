package pkt;
//observer (kullanici1 ve kullanici2) istemcideki olayların yansıtıldığı nesnedir.
public interface IObserver {
     void update(String message);
}
