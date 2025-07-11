import { useState } from "react";
import { ItemSlots } from "../Enums";
import type { Item } from "../Interfaces";
import { graphQlCLClient } from "../App";
import { ITEMS_BY_ITEMSLOT_QUERY } from "../Queries/Queries";
import { Header } from "../Components/Header";

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
      <Header />
      <div className="flex mx-auto max-w-3xl p-6 shadow-md rounded-md space-y-8 flex-col">
        {/* Select item slot */}
        <div>
          <h2 className="text-xl font-semibold mb-4">Select item slot</h2>
          <select
            className="border rounded"
            onChange={(e) => setItemSlot(e.target.value as ItemSlots)}
          >
            {Object.keys(ItemSlots).map((itemSlot) => (
              <option key={itemSlot} value={itemSlot}>
                {itemSlot}
              </option>
            ))}
          </select>
        </div>

        {/* Search button */}
        <div className="">
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
          <h3 className="text-xl font-semibold mb-4">Items</h3>
          <ul>
            {Array.isArray(items) && items.length > 0 ? (
              items.map((item) => (
                <li key={item.id} className="my-4">
                  <b>Name:</b> {item.name}. Ilvl: {item.itemLevel}. Slot:{" "}
                  {item.itemSlot}. Two Handed: {String(item.isTwoHand)}
                  <p key={item.id}>
                    {item.stats.map((stat) => (
                      <>
                        {stat.key}: {stat.value} {","}
                      </>
                    ))}
                  </p>
                  Gem slots:{" "}
                  {item.gemSlots.map((gemSlot) => (
                    <>
                      {gemSlot.color} {", "}
                    </>
                  ))}
                </li>
              ))
            ) : (
              <li key={null}>No items found</li>
            )}
          </ul>
        </div>
      </div>
    </>
  );
}
