import type { ItemSlots } from "./Enums"

export interface Stat {
    key: string,
    value: number
}

export interface GemSlot {
    color: string
}

export interface Item {
    id: number,
    name: string,
    itemSlot: ItemSlots,
    itemLevel: number,
    isTwoHand: boolean,
    stats: Stat[],
    gemSlots: GemSlot[]
}