import type { ItemSlotsInput } from "../Enums";

interface GearSlotProps {
  itemSlot: ItemSlotsInput;
}

/* Component rendering item boxes*/
export function GearSlot({ itemSlot }: GearSlotProps) {
  return (
    <>
      <div className="flex">
        {/* Box*/}
        <div className="border w-16 h-16 mb-4">{itemSlot}</div>

        <div>
          <b>{itemSlot}</b>
          <br />
          <p>TEXT</p>
        </div>
      </div>
    </>
  );
}
