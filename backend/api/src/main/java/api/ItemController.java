package api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import items.GemSlot;
import items.Item;
import items.ItemRepository;
import items.Stat;
import items.Enums.ItemSlotEnum;
import items.Inputs.GemSlotInput;
import items.Inputs.StatInput;

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

    @MutationMapping
    public Item createItem(@Argument("name") String name, @Argument("itemLevel") int itemlevel,
    @Argument("itemSlot") ItemSlotEnum itemSlot, @Argument("gemSlots") Collection<GemSlotInput> gemSlotInputs,
    @Argument("stats") Collection<StatInput> statsInput) {

        List<GemSlot> gemSlotsList = gemSlotInputs.stream()
        .map(input -> new GemSlot(input.getColor()))
        .toList();

        List<Stat> statsList = statsInput.stream()
        .map(input -> new Stat(input.getKey(), input.getValue()))
        .toList();

        System.out.println(gemSlotsList);

        Item item = new Item(name, itemlevel, itemSlot, gemSlotsList, statsList);
        itemRepository.save(item);
        return item;

    }

    @MutationMapping
    public Item deleteItem(@Argument("id") Long id) {
        Item itemToDelete = itemById(id);
        itemRepository.delete(itemById(id));

        return itemToDelete;
    }
    
}
