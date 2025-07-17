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
    dialogRef.current?.close();
    return;
  };

  return (
    <>
      <dialog
        ref={dialogRef}
        className="w-[30rem] max-w-full mx-auto my-16 rounded-md border border-gray-300 bg-white shadow-lg p-6"
      >
        <h2 className="text-xl font-bold mb-4 capitalize">
          Select {itemSlot.toLowerCase()} Item
        </h2>

        <ul className="space-y-2 mb-4 max-h-64 overflow-y-auto">
          {items.map((item) => (
            <li
              key={item.id}
              onClick={() => handleClick(item)}
              className="cursor-pointer px-4 py-2 border border-gray-200 rounded-md hover:bg-gray-100 transition"
            >
              <span className="font-medium">{item.name}</span>,
              <span className="text-gray-600 ml-1">iLvl {item.itemLevel}</span>
            </li>
          ))}
        </ul>

        <div className="text-right">
          <button
            className="px-4 py-2 bg-gray-300 hover:bg-gray-400 text-gray-800 font-semibold rounded"
            onClick={() => dialogRef.current?.close()}
          >
            Close
          </button>
        </div>
      </dialog>
    </>
  );
});
