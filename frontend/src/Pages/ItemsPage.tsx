import { useState } from "react";
import { ItemSlots } from "../Enums";
import type { Item } from "../Interfaces";
import { graphQlCLClient } from "../App";
import { ITEMS_BY_ITEMSLOT_QUERY } from "../Queries/Queries";

interface ItemsBySlotResponse {
  itemBySlot: Item[];
}

export function ItemsPage() {
  const [itemSlot, setItemSlot] = useState<ItemSlots>("HEAD");

  const [items, setItems] = useState<Item[]>([]);

  async function handleSearch() {
    try {
      const itemsInput = await graphQlCLClient.request<ItemsBySlotResponse>(
        ITEMS_BY_ITEMSLOT_QUERY,
        { itemSlot }
      );

      setItems(itemsInput.itemBySlot);
    } catch (e) {
      console.log(e);
    }
  }
  return (
    <>
      {/* Select item slot */}
      <div>
        <h3>Select item slot</h3>
        <select onChange={(e) => setItemSlot(e.target.value as ItemSlots)}>
          {Object.keys(ItemSlots).map((itemSlot) => (
            <option key={itemSlot} value={itemSlot}>
              {itemSlot}
            </option>
          ))}
        </select>
        {itemSlot}
      </div>

      {/* Search button */}
      <div>
        <button
          className="bg-green-400 px-8 py-1 text-white rounded"
          onClick={handleSearch}
          type="button"
        >
          Search
        </button>
      </div>

      {/* List of items found*/}
      <div>
        <h3>Items</h3>
        <ul>
          {Array.isArray(items) && items.length > 0 ? (
            items.map((item) => <li key={item.id}>{item.name}</li>)
          ) : (
            <li>No items found</li>
          )}
        </ul>
      </div>
    </>
  );
}
