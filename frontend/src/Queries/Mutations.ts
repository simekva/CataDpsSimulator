import { gql } from "graphql-request";

export const CREATE_ITEM_MUTATION = gql`

    mutation CreateItem
    (
        $name: String!,
        $itemLevel: Int!,
        $itemSlot: ItemSlotEnum!,
        $gemSlots: [GemSlotInput!]!,
        $stats: [statInput!]!
    )
    {
        createItem(
            name: $name,
            itemLevel: $itemLevel,
            itemSlot: $itemSlot,
            gemSlots: $gemSlots,
            stats: $stats
        ) 
        {
        id
        name
        itemLevel
        itemSlot
        gemSlots {color}
        stats {key, value}
        }
    }

`