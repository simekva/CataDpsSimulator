import { useState } from "react";
import type { ItemSlotsInput } from "../Enums";
import type { Item } from "../Interfaces";

interface GearSlotProps {
  itemSlot: ItemSlotsInput;
  isClicked: boolean;
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
  const [isClicked, setIsClicked] = useState(false);

  /** Pass setSelectedItem state to child popup component
   * https://www.geeksforgeeks.org/reactjs/how-to-set-parent-state-from-children-component-in-reactjs/
   */
  const [selectedItem, setSelectedItem] = useState<Item>(defaultItem);

  const handleClick = () => {
    setIsClicked((prev) => !prev);
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
    </>
  );
}
