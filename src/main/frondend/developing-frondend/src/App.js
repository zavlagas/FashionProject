import React from "react";
import "./App.css";
import { BrowserRouter, Route } from "react-router-dom";
import Interceptors from "./components/Interceptors.jsx";
import Login from "./components/Login.jsx";
import Dashboard from "./components/Dashboard";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <BrowserRouter>
          <Route exact path="/" component={Login} />
          <Route exact path="/dashboard" component={Dashboard} />
        </BrowserRouter>
      </header>
    </div>
  );
}
export default App;
