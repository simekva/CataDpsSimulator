import { ItemSlots, WowClasses } from "../Enums";

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
        <div className="grid grid-rows-9 grid-flow-col h-240 w-1/2 shadow-xl ml-6 mt-6 bg-zinc-200">
          {Object.keys(ItemSlots).map((itemSlot: ItemSlots) => (
            <div className="flex space-x-2 ml-12">
              <div key={itemSlot} className="border h-20 w-20">
                TEMP
              </div>
              <div key={itemSlot}>
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
