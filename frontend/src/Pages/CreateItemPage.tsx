import { useState } from "react";
import { Header } from "../Components/Header";
import { GemColorsEnum, ItemSlots, StatsEnum } from "../Enums";
import type { GemSlot, Stat } from "../Interfaces";
import { graphQlCLClient } from "../App";
import { CREATE_ITEM_MUTATION } from "../Queries/Mutations";

export function CreateItemPage() {
  // Variables for GraphQL query
  const [name, setName] = useState("");
  const [itemLevel, setItemLevel] = useState(0);
  const [itemSlot, setItemSlot] = useState("HEAD");
  const [stats, setStats] = useState<Stat[]>([]);
  const [gemSlots, setGemSlots] = useState<GemSlot[]>([]);

  // Helper states for stats and gem color
  const [selectedStat, setSelectedStat] = useState("ARMOR");
  const [statValue, setStatValue] = useState(0);
  const [selectedGemColor, setSelectedGemColor] = useState("RED");

  const [isTwoHand, setIsTwoHand] = useState(false);

  const handleAddStat = () => {
    if (!selectedStat || isNaN(statValue)) return;
    setStats((prev) => [...prev, { key: selectedStat, value: statValue }]);
    setStatValue(0);
  };

  const handleDeleteStat = (index: number) => {
    setStats((prev) => prev.filter((_, i) => i !== index));
  };

  const handleAddGemColor = () => {
    setGemSlots((prev) => [...prev, { color: selectedGemColor }]);
  };

  const handleDeleteGem = (index: number) => {
    setGemSlots((prev) => prev.filter((_, i) => i !== index));
  };

  async function handleSubmit() {
    const variables = {
      name: name,
      itemLevel: itemLevel,
      itemSlot: itemSlot,
      gemSlots: gemSlots,
      stats: stats,
    };

    if (name.length < 1) {
      throw new Error("Name must be longer than 1.");
    }
    if (itemLevel < 1) {
      throw new Error("Item level must be greater than 0.");
    }
    if (stats.length == 0) {
      throw new Error("Item needs at least one stat.");
    }
    const data = await graphQlCLClient.request(CREATE_ITEM_MUTATION, variables);
    setName("");
    setItemLevel(0);
    setStats([]);
    setGemSlots([]);
    console.log(data);
  }

  return (
    <>
      <Header />
      <div className="max-w-3xl mx-auto p-6 bg-white shadow-md rounded-md space-y-8">
        {/* Item Info */}
        <div>
          <h2 className="text-xl font-semibold mb-4">Item Details</h2>
          <div className="space-y-4">
            <label className="block">
              <span className="text-sm font-medium text-gray-700">
                Item Name
              </span>
              <input
                type="text"
                className="mt-1 w-full border rounded px-3 py-2"
                placeholder="Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </label>
            <label className="block">
              <span className="text-sm font-medium text-gray-700">
                Item Level
              </span>
              <input
                type="number"
                className="mt-1 w-full border rounded px-3 py-2"
                placeholder="Item Level"
                value={itemLevel}
                onChange={(e) => setItemLevel(Number(e.target.value))}
              />
            </label>
          </div>
        </div>

        {/* Item Slot */}
        <div>
          <h2 className="text-xl font-semibold mb-4">Item Slot</h2>
          <div className="flex flex-wrap gap-4">
            <select
              className="border px-3 py-2 rounded"
              value={itemSlot}
              onChange={(e) => setItemSlot(e.target.value)}
            >
              {Object.keys(ItemSlots).map((slot) => (
                <option key={slot} value={slot}>
                  {slot}
                </option>
              ))}
            </select>
            <label>
              <input
                type="checkbox"
                defaultChecked={false}
                onChange={() => setIsTwoHand(!isTwoHand)}
              ></input>
              <span className="ml-2">Two-Handed</span>
            </label>
          </div>
        </div>

        {/* Stat Selection */}
        <div>
          <h2 className="text-xl font-semibold mb-4">Add Stats</h2>
          <div className="flex gap-4 items-center">
            <select
              className="border px-3 py-2 rounded"
              value={selectedStat}
              onChange={(e) => setSelectedStat(e.target.value)}
            >
              {Object.keys(StatsEnum).map((stat) => (
                <option key={stat} value={stat}>
                  {stat}
                </option>
              ))}
            </select>
            <input
              type="number"
              className="border px-3 py-2 rounded"
              placeholder="0"
              value={statValue}
              onChange={(e) => setStatValue(Number(e.target.value))}
            />
            <button
              type="button"
              className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
              onClick={handleAddStat}
            >
              Add Stat
            </button>
          </div>

          <ul className="mt-4 space-y-2">
            {stats.map((stat, index) => (
              <li
                key={index}
                className="flex justify-between items-center border p-2 rounded"
              >
                <span>
                  {stat.key}: {stat.value}
                </span>
                <button
                  onClick={() => handleDeleteStat(index)}
                  className="text-red-500 hover:underline"
                >
                  Remove
                </button>
              </li>
            ))}
          </ul>
        </div>

        {/* Gem Slot Selection */}
        <div>
          <h2 className="text-xl font-semibold mb-4">Gem Slots</h2>
          <div className="flex gap-4 items-center">
            <select
              className="border px-3 py-2 rounded"
              value={selectedGemColor}
              onChange={(e) => setSelectedGemColor(e.target.value)}
            >
              {Object.keys(GemColorsEnum).map((color) => (
                <option key={color} value={color}>
                  {color}
                </option>
              ))}
            </select>
            <button
              type="button"
              className="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600"
              onClick={handleAddGemColor}
            >
              Add Gem Slot
            </button>
          </div>

          <ul className="mt-4 space-y-2">
            {gemSlots.map((gem, index) => (
              <li
                key={index}
                className="flex justify-between items-center border p-2 rounded"
              >
                <span>{gem.color}</span>
                <button
                  type="button"
                  onClick={() => handleDeleteGem(index)}
                  className="text-red-500 hover:underline"
                >
                  Remove
                </button>
              </li>
            ))}
          </ul>
        </div>

        {/* Button for submitting and sending query*/}
        <div>
          <button
            onClick={handleSubmit}
            className="w-full h-12 font-semibold text-xl bg-green-400 rounded"
          >
            Submit
          </button>
        </div>
      </div>
    </>
  );
}
