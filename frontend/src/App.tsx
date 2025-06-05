import ReactDOM from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { WowClasses } from "./WowClasses";
import ClassPage from "./Pages/ClassPage";
import { IndexPage } from "./Pages/IndexPage";

const App = () => (
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<IndexPage />} />
      {Object.values(WowClasses).map((className) => (
        <Route
          key={className}
          path={`/${className.toLowerCase()}`}
          element={<ClassPage wowClass={className} />}
        />
      ))}
    </Routes>
  </BrowserRouter>
);

const root = document.getElementById("root");

ReactDOM.createRoot(root!).render(<App />);

export default App;
