package client.business;

import java.util.List;

public interface AbstractFactory<T> {
    T create(String type, List<ItemInformation> groceryItem);
}
