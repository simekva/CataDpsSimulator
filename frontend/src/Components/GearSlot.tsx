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
      <div
        onClick={handleClick}
        className="flex items-center cursor-pointer bg-white border border-gray-300 rounded-lg shadow-sm hover:shadow-md transition mr-4 mb-4 p-2 w-64"
      >
        {/* Icon / Box */}
        <div className="border w-16 h-16 flex items-center justify-center bg-gray-100 text-xs font-semibold rounded">
          {itemSlot}
        </div>

        {/* Info */}
        <div className="ml-4">
          <div className="font-bold text-sm capitalize">
            {itemSlot.toLowerCase()}
          </div>
          <div className="text-gray-700 text-sm">
            {selectedItem.name}, ilvl {selectedItem.itemLevel}
          </div>
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
