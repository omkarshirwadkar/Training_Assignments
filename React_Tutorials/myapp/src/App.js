import Counter from "./Counter";
import Effect from "./Effect";
import Greet from "./Greet";
import JSXDemo from "./JSXDemo";
import Welcome from "./Welcome";

function App() {
  let a = 10;
  let b = 20;
  let c = a + b;
  return (
    <>
      <h1>This is the first React app</h1>
      <hr/>
      <JSXDemo/>
      <h2>The sum of {a} and {b} is {c}</h2>
      <h2>{(a >= 10?"Good Morning":"Good Evening")}</h2>
      <Greet day="Morning" name="Sahil"/>
      <Greet day="Afternoon" name="Raj"/>
      <Greet day="Evening" name="Parvati"/>
      <Counter/>
      <Welcome/>
      <Effect />
    </>
  );
}

export default App;
