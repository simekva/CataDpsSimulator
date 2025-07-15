import { ItemSlotsInput, WowClasses } from "../Enums";

import { Header } from "../Components/Header";
import { GearSlot } from "../Components/GearSlot";

interface ClassPageProps {
  wowClass: WowClasses;
}

function ClassPage({ wowClass }: ClassPageProps) {
  return (
    <>
      <Header />
      <div>
        {/* Boxes where user can input gear */}
        <div className="grid grid-rows-8 grid-flow-col w-1/2 shadow-xl ml-6 bg-zinc-200 pl-8 pt-4 mt-4">
          {Object.keys(ItemSlotsInput).map((itemSlot: ItemSlotsInput) => (
            <GearSlot itemSlot={itemSlot} key={itemSlot} />
          ))}
        </div>
      </div>
    </>
  );
}

export default ClassPage;
