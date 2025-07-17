import { forwardRef, useImperativeHandle, useRef, type Dispatch } from "react";
import type { ItemSlotsInput } from "../Enums";
import type { Item } from "../Interfaces";

export interface GearSlotDialogHandle {
  openDialog: () => void;
}

interface GearSlotDialogProps {
  itemSlot: ItemSlotsInput;
  setSelectedItem: Dispatch<React.SetStateAction<Item>>;
}

export const GearSlotDialog = forwardRef<
  GearSlotDialogHandle,
  GearSlotDialogProps
>(({ itemSlot, setSelectedItem }, ref) => {
  const dialogRef = useRef<HTMLDialogElement>(null);

  useImperativeHandle(ref, () => ({
    openDialog() {
      if (dialogRef.current) {
        dialogRef.current.showModal();
      }
    },
  }));

  return (
    <>
      <dialog ref={dialogRef}>
        {itemSlot}
        <button onClick={() => dialogRef.current?.close()}>Close</button>
      </dialog>
    </>
  );
});
