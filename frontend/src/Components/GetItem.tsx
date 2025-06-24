import request, { gql } from "graphql-request"
import { useEffect, useState } from "react"

interface Stat {
    key: string,
    value: string
}

interface GemSlot {
    color: string
}

interface Item {
    id: number,
    name: string,
    itemSlot: string,
    itemLevel: number,
    stats: Stat[],
    gemSlots: GemSlot[]
}

interface AllItemsResponse {
  allItems?: Item[] | null;
}

const query = gql`
    {
        allItems {
            id
            name
            itemSlot
            itemLevel
            stats {
                key
                value
            }
            gemSlots {
                color
            }
        }
    }

`

export function GetItem() {

    const [item, setItem] = useState<Item | null>(null);

    useEffect(() => {

        const fetchItem = async () => {
            const data = await getItem(query);
            if (data.allItems) {
                setItem(data.allItems[0])
            }
        }

        fetchItem();

    }, []);

    return (
        <>
        {item?.name}
        </>
    )
}

async function getItem(query: string): Promise<AllItemsResponse> {

    return await request("http://localhost:8080/graphql", query);
    
}