import { ItemSlots, ItemSlotsInput, WowClasses } from "../Enums";

import { Header } from "../Components/Header";

interface ClassPageProps {
  wowClass: WowClasses;
}

function ClassPage({ wowClass }: ClassPageProps) {
  return (
    <>
      <Header />
      <div>
        {/* Boxes where user can input gear */}
        <div className="grid grid-rows-8 grid-flow-col h-240 w-1/2 shadow-xl ml-6 my-6 bg-zinc-200">
          {Object.keys(ItemSlotsInput).map((itemSlot: ItemSlotsInput) => (
            <div key={itemSlot} className="flex space-x-2 ml-12">
              <div className="border h-16 w-16">TEMP</div>
              <div>
                <b>{itemSlot}</b>
                <br />
                text
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default ClassPage;
