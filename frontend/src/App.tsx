import ReactDOM from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { WowClasses } from "./Enums";
import ClassPage from "./Pages/ClassPage";
import { IndexPage } from "./Pages/IndexPage";
import { NoPage } from "./Pages/NoPage";
import { CreateItemPage } from "./Pages/CreateItemPage";
import { GraphQLClient } from "graphql-request";
import { ItemsPage } from "./Pages/ItemsPage";

const endpoint = "http://localhost:8080/graphql";

export const graphQlCLClient = new GraphQLClient(endpoint);

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
      <Route path="admin" element={<CreateItemPage />}></Route>
      <Route path="items" element={<ItemsPage />}></Route>
      <Route path="*" element={<NoPage />}></Route>
    </Routes>
  </BrowserRouter>
);
export default App;
