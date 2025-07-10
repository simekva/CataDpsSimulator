package api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import api.dtos.GemSlotInput;
import api.dtos.ItemInput;
import api.dtos.StatInput;
import items.GemSlot;
import items.Item;
import items.ItemRepository;
import items.Stat;
import items.Enums.GemSlotColorEnum;
import items.Enums.ItemSlotEnum;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @QueryMapping
    public List<Item> allItems() {
        System.out.println("Asked to return all items");

        List<Item> items = itemRepository.findAll();

        List<String> itemNames = new ArrayList<>();

        for (Item item : items) {
            itemNames.add(item.getName());
        }

        System.out.println("Returning all items: " + itemNames.toString());
        return items;
    }

    @QueryMapping
    public Item itemById(@Argument("id") Long id) {
        System.out.println("Asked to find item with id: " + id);
        Item item = itemRepository.findById(id).orElse(null);

        System.out.println("Returning item: " + item.getName());
        return item;
    }

    @MutationMapping
    public Item createItem(@Argument("itemInput") ItemInput itemInput) {

        List<GemSlotColorEnum> gemSlotsColors = new ArrayList<>();
        for (GemSlotInput slot : itemInput.getGemSlots()) {
            gemSlotsColors.add(slot.getColor());
        }

        List<String> statsAsString = new ArrayList<>();
        for (StatInput stat : itemInput.getStats()) {
            statsAsString.add(stat.toString() + "\n");
        }

        System.out.println("Asked to create item with params: " + "\n"
                + "Name: " + itemInput.getName() + "\n"
                + "ItemLevel: " + itemInput.getItemLevel() + "\n"
                + "ItemSlot: " + itemInput.getItemSlot() + "\n"
                + "GemSlots: " + gemSlotsColors + "\n"
                + "Stats: " + statsAsString

        );

        List<GemSlot> gemSlotsList = itemInput.getGemSlots().stream()
                .map(input -> new GemSlot(input.getColor()))
                .toList();

        List<Stat> statsList = itemInput.getStats().stream()
                .map(input -> new Stat(input.getKey(), input.getValue()))
                .toList();

        Item item = new Item(itemInput.getName(), itemInput.getItemLevel(), itemInput.getItemSlot(), gemSlotsList,
                statsList);

        Item identicalItem = itemRepository.findByNameAndItemLevel(itemInput.getName(), itemInput.getItemLevel());

        if (identicalItem != null) {
            System.out.println("Item with name: " + itemInput.getName() + ", ilvl: " + itemInput.getItemLevel()
                    + " already exists.");
            return item;
        }
        itemRepository.save(item);
        return item;

    }

    @MutationMapping
    public Item deleteItem(@Argument("id") Long id) {
        System.out.println("Asked to delete item with id: " + id);
        Item itemToDelete = itemById(id);
        if (itemToDelete != null) {
            itemRepository.delete(itemToDelete);
            System.out.println("Deleted item: " + itemToDelete.toString());
        } else {
            System.out.println("Could not delete item with id: " + id);
        }
        return itemToDelete;
    }

    @QueryMapping
    public List<Item> itemBySlot(@Argument("itemSlot") ItemSlotEnum itemSlot) {
        System.out.println("Asked to get all items with slot: " + itemSlot);

        List<Item> itemsInSlot = itemRepository.findByItemSlot(itemSlot);

        List<String> itemNames = new ArrayList<>();
        for (Item item : itemsInSlot) {
            itemNames.add(item.getName());
        }
        System.out.println("Found items: " + itemNames.toString());
        return itemsInSlot;
    }

}
