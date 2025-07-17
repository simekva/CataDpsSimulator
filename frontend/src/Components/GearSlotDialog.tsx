import {
  forwardRef,
  useEffect,
  useImperativeHandle,
  useRef,
  useState,
  type ChangeEvent,
  type Dispatch,
} from "react";
import type { ItemSlotsInput } from "../Enums";
import type { Item } from "../Interfaces";
import { getItemsByItemSlot } from "../Queries/QueryFunctions";

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

  const [items, setItems] = useState<Item[]>([]);

  useImperativeHandle(ref, () => ({
    openDialog() {
      if (dialogRef.current) {
        dialogRef.current.showModal();
      }
    },
  }));

  useEffect(() => {
    const fetchItems = async () => {
      setItems(await getItemsByItemSlot(itemSlot));
    };

    fetchItems();
  }, [itemSlot]);

  const handleClick = (item: Item) => {
    setSelectedItem(item);
    return;
  };

  return (
    <>
      <dialog ref={dialogRef} className="mx-auto px-16 my-16 border">
        {itemSlot}

        <ul>
          {items.map((item) => (
            <li onClick={() => handleClick(item)} key={item.id}>
              {item.name}, {item.itemLevel}
            </li>
          ))}
        </ul>

        <button className="border" onClick={() => dialogRef.current?.close()}>
          Close
        </button>
      </dialog>
    </>
  );
});
