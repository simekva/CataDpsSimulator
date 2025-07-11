import { gql } from "graphql-request";

export const CREATE_ITEM_MUTATION = gql`

    mutation CreateItem($itemInput: ItemInput!) {
        createItem(itemInput: $itemInput) {
            id
            name
            itemLevel
            itemSlot
            gemSlots {color}
            stats {key, value}
        }
    }

`

export const DELETE_ITEM_MUTATION = gql`

    mutation deleteItem($id: ID!) {
        deleteItem(id: $id) {
            id
            name
            itemLevel
            itemSlot
            gemSlots {color}
            stats {key, value}
        }
    }
`