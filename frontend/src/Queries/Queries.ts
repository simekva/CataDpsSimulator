import { gql } from "graphql-request";

export const ALL_ITEMS_QUERY = gql`
    query allItems {
        allItems {
            id
            name
            itemSlot
            itemlevel
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
            gemSlots {color}
            stats {key, value}
        }
    }
`