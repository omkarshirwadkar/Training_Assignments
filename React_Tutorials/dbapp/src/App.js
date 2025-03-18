import logo from './logo.svg';
import './App.css';
import GetEmployees from './GetEmployees';
import AddEmployees from './AddEmployees';

function App() {
  return (
    <div className="App">
      <h1>Employee Management Application</h1>
      <hr/>
      <AddEmployees/>
      <hr/>
      <GetEmployees/>
      <hr />
      
    </div>
  );
}

export default App;
