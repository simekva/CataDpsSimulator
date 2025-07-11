import { gql } from "graphql-request";

export const ALL_ITEMS_QUERY = gql`
    query allItems {
        allItems {
            id
            name
            itemSlot
            itemlevel
            isTwoHand
            gemSlots {color}
            stats {key, value}
        }
    }
`

export const ITEM_BY_ID_QUERY = gql`
    query  itemById($id: ID!) {
        itemById(id: $id) {
            id
            name
            itemSlot
            itemLevel
            isTwoHand
            gemSlots {color}
            stats {key, value}
        }
    }
`

export const ITEMS_BY_ITEMSLOT_QUERY = gql`
    query itemBySlot($itemSlot: ItemSlotEnum!) {
        itemBySlot(itemSlot: $itemSlot) {
            id
            name
            itemSlot
            itemLevel
            isTwoHand
            gemSlots {color}
            stats {key, value}
        }
    }
`