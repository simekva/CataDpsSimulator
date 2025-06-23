package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import items.Item;
import items.ItemRepository;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @QueryMapping
    public List<Item> allItems() {
        return itemRepository.findAll();
    }
    
    @QueryMapping
    public Item itemById(@Argument("id") Long id) {
        return itemRepository.findById(id).orElse(null);
    }
    
}
