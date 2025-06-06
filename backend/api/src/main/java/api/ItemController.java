package api;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import items.Item;
import items.ItemRepository;
import items.ItemSlotEnum;
import items.StatsEnum;
import items.StatsInput;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @QueryMapping
    public List<Item> allItems() {
        System.out.println("Fetching all items from the repository" + itemRepository.findAll());
        return itemRepository.findAll();
    }

    @QueryMapping
    public Optional<Item> itemById(@Argument("id") Long id) {
        System.out.println("Fetching item with ID: " + id);
        return itemRepository.findById(id);
    }

    @MutationMapping
    public Item createItem(@Argument("name") String name, @Argument("itemLevel") int itemLevel,
            @Argument("itemSlot") ItemSlotEnum itemSlot,
            @Argument("colorsOnGemSlots") List<String> colorsOnGemSlots,
            @Argument("stats") List<StatsInput> stats) {

        System.out.println("Creating item with name: " + name + ", itemLevel: " + itemLevel + ", itemSlot: "
                + itemSlot + ", colorsOnGemSlots: " + colorsOnGemSlots + ", stats: " + stats);

        Map<StatsEnum, Integer> statsMap = stats.stream()
                .collect(Collectors.toMap(StatsInput::getKey, StatsInput::getValue));

        Item item = new Item(name, itemLevel, itemSlot, colorsOnGemSlots, statsMap);

        return itemRepository.save(item);
    }

    @MutationMapping
    public Boolean deleteItem(@Argument("id") Long id) {
        System.out.println("Deleting item with ID: " + id);
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
