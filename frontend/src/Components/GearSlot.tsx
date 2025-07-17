import { useRef, useState } from "react";
import type { ItemSlotsInput } from "../Enums";
import type { Item } from "../Interfaces";
import { GearSlotDialog, type GearSlotDialogHandle } from "./GearSlotDialog";

interface GearSlotProps {
  itemSlot: ItemSlotsInput;
}

/** Temp default item */
const defaultItem: Item = {
  id: 1,
  name: "temp Helmet",
  itemSlot: "HEAD",
  itemLevel: 400,
  isTwoHand: false,
  stats: [{ key: "STRENGTH", value: 400 }],
  gemSlots: [{ color: "RED" }],
};

/* Component rendering item box*/
export function GearSlot({ itemSlot }: GearSlotProps) {
  /** Pass setSelectedItem state to child popup component
   * https://www.geeksforgeeks.org/reactjs/how-to-set-parent-state-from-children-component-in-reactjs/
   */
  const [selectedItem, setSelectedItem] = useState<Item>(defaultItem);

  const dialogRef = useRef<GearSlotDialogHandle>(null);

  const handleClick = () => {
    dialogRef.current?.openDialog();
  };

  return (
    <>
      <div onClick={handleClick} className="flex border mr-4 mb-4">
        {/* Box */}
        <div className="border w-16 h-16">{itemSlot}</div>
        {/* Text */}
        <div>
          <b>{itemSlot}</b>
          <br />
          <p>
            {selectedItem.name}, {selectedItem.itemLevel}
          </p>
        </div>
      </div>
      <GearSlotDialog
        ref={dialogRef}
        itemSlot={itemSlot}
        setSelectedItem={setSelectedItem}
      />
    </>
  );
}
