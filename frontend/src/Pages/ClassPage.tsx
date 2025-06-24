import { WowClasses } from "../WowClasses";

import { Header } from "../Components/Header";
import { GetItem } from "../Components/GetItem";

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
      {<GetItem />}
      </div>
    </>
  );
}

export default ClassPage;
