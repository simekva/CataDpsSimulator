import { WowClasses } from "../Enums";

import { Header } from "../Components/Header";

interface ClassPageProps {
  wowClass: WowClasses;
}

function ClassPage({ wowClass }: ClassPageProps) {
  return (
    <>
      <Header />
      <div>
        <h1>Class Page</h1>
        <p>This is the {wowClass} page.</p>
      </div>
    </>
  );
}

export default ClassPage;
