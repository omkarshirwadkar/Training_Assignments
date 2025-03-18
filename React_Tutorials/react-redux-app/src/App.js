import { Provider } from 'react-redux';
import './App.css';
import BookContainer from './components/BookContainer';
import store from './reduxContainer/Store';

function App() {
  return (
    <Provider store ={store}>
      <div>
        <h1>React Redux Demo</h1>
        <BookContainer/>
      </div>
    </Provider>
    
  );
}

export default App;
