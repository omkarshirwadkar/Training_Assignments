import DbOperations from "./DbOperations";
import GetProducts from "./GetProducts";
import AddProducts from "./AddProducts";

import './styles.css';
function App() {
  return (
    <div className="App">
      <h1>E-Commerce Application</h1>
      {/* <GetProducts /> */}
      <DbOperations />
      <hr/>
      <AddProducts />
    </div>
  );
}

export default App;
