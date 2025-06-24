import { WowClasses } from "../Enums";

export function Header() {
  return (
    <header className="bg-gray-800 text-white p-4">
      <h1 className="text-2xl font-bold hover:underline">
        <a href="/">World of Warcraft Classes</a>
      </h1>
      <nav className="mt-2">
        <ul className="flex space-x-4">
          {Object.values(WowClasses).map((className) => (
            <li key={className}>
              <a
                href={`/${className.toLowerCase()}`}
                className="hover:underline capitalize"
              >
                {className.toLowerCase().replace(/^\w/, (c) => c.toUpperCase())}
              </a>
            </li>
          ))}
        </ul>
      </nav>
    </header>
  );
}
