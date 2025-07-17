import { graphQlCLClient } from "../App";
import type { ItemSlots } from "../Enums";
import type { Item } from "../Interfaces";
import { ITEMS_BY_ITEMSLOT_QUERY } from "./Queries";

interface getItemsByItemSlotResponse {
    itemBySlot: Item[]
}

export async function getItemsByItemSlot(itemSlot: ItemSlots): Promise<Item[]> {

    if (itemSlot === "FINGER1" || itemSlot === "FINGER2") {
        const items: getItemsByItemSlotResponse = await graphQlCLClient.request(ITEMS_BY_ITEMSLOT_QUERY, {"itemSlot": "FINGER"});
        return items.itemBySlot;
    }

    if (itemSlot === "TRINKET1" || itemSlot === "TRINKET2") {
        const items: getItemsByItemSlotResponse = await graphQlCLClient.request(ITEMS_BY_ITEMSLOT_QUERY, {"itemSlot": "TRINKET"});
        return items.itemBySlot
    }

    const items: getItemsByItemSlotResponse = await graphQlCLClient.request(ITEMS_BY_ITEMSLOT_QUERY, {itemSlot});

    return items.itemBySlot
}