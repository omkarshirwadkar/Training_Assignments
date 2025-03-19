import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./styles.css"

const Register = () => {
  const [uname, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [blce, setBalance] = useState(0);
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleRegister = async (e) => {
    e.preventDefault();
    
    try {
      await axios.post("http://localhost:8585/customer/insert", {
        username: uname,
        cpass: password,
        balance: blce,
      });
      console.log("DADSDSADA");
      
      navigate("/login");
    } catch (err) {
      setError("Registration failed!");
    }
  };

  return (
    <div className="box">
      <h2>Register</h2>
      {error && <p className="error">{error}</p>}
      <form onSubmit={handleRegister}>
        <input
          type="text"
          placeholder="Username"
          value={uname}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <input
          type="number"
          placeholder="Initial Balance"
          value={blce}
          onChange={(e) => setBalance(e.target.value)}
          required
        />
        <button type="submit">Register</button>
      </form>
      <p>
        Already have an account? <a href="/">Login</a>
      </p>
    </div>
  );
};

export default Register;
