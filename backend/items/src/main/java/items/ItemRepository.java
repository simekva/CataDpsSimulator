package items;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import items.Enums.ItemSlotEnum;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemSlot(ItemSlotEnum itemSlot);

}