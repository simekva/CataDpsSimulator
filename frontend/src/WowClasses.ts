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

export type WowClasses = (typeof WowClasses)[keyof typeof WowClasses];
