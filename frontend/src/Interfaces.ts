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
    itemSlot: string,
    itemLevel: number,
    isTwoHand: boolean,
    stats: Stat[],
    gemSlots: GemSlot[]
}