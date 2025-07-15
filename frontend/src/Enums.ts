export const WowClasses = {
  WARRIOR: "WARRIOR",
  PALADIN: "PALADIN",
  HUNTER: "HUNTER",
  ROGUE: "ROGUE",
  PRIEST: "PRIEST",
  DEATH_KNIGHT: "DEATH_KNIGHT",
  SHAMAN: "SHAMAN",
  MAGE: "MAGE",
  WARLOCK: "WARLOCK",
  DRUID: "DRUID",
} as const;

export const ItemSlots = {
  HEAD: "HEAD",
  NECK: "NECK",
  SHOULDERS: "SHOULDERS",
  BACK: "BACK",
  CHEST: "CHEST",
  WRISTS: "WRISTS",
  HANDS: "HANDS",
  WAIST: "WAIST",
  LEGS: "LEGS",
  FEET: "FEET",
  FINGER: "FINGER",
  TRINKET: "TRINKET",
  MAIN_HAND: "MAIN_HAND",
  OFF_HAND: "OFF_HAND",
}

export const ItemSlotsInput = {
  HEAD: "HEAD",
  NECK: "NECK",
  SHOULDERS: "SHOULDERS",
  BACK: "BACK",
  CHEST: "CHEST",
  WRISTS: "WRISTS",
  HANDS: "HANDS",
  WAIST: "WAIST",
  LEGS: "LEGS",
  FEET: "FEET",
  FINGER1: "FINGER1",
  FINGER2: "FINGER2",
  TRINKET1: "TRINKET1",
  TRINKET2: "TRINKET2",
  MAIN_HAND: "MAIN_HAND",
  OFF_HAND: "OFF_HAND",
}

export const StatsEnum = {
  ARMOR: "ARMOR",
  STRENGTH: "STRENGTH",
  AGILITY: "AGILITY",
  INTELLECT: "INTELLECT",
  STAMINA: "STAMINA",
  SPIRIT: "SPIRIT",
  EXPERTISERATING: "EXPERTISERATING",
  HITRATING: "HITRATING",
  CRITRATING: "CRITRATING",
  MASTERYRATING: "MASTERYRATING",
  HASTERATING: "HASTERATING",
  ATTACKPOWER: "ATTACKPOWER",
  SPELLPOWER: "SPELLPOWER",
};

export const GemColorsEnum = {
  META: "META",
  RED: "RED",
  BLUE: "BLUE",
  YELLOW: "YELLOW"
}
export type WowClasses = (typeof WowClasses)[keyof typeof WowClasses];

export type ItemSlots = (typeof ItemSlots)[keyof typeof ItemSlots];

export type ItemSlotsInput = (typeof ItemSlotsInput)[keyof typeof ItemSlotsInput];

export type StatsEnum = (typeof StatsEnum)[keyof typeof StatsEnum];

export type GemColorsEnum = (typeof GemColorsEnum)[keyof typeof GemColorsEnum]