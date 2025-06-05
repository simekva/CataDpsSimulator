import { WowClasses } from "../WowClasses";

interface ClassPageProps {
  wowClass: WowClasses;
}

function ClassPage({ wowClass }: ClassPageProps) {
  return (
    <div>
      <h1>Class Page</h1>
      <p>This is the {wowClass} page.</p>
    </div>
  );
}

export default ClassPage;
