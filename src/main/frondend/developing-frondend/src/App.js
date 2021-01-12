import React, { Component } from "react";
import "./App.css";
import { BrowserRouter as Router, Route} from "react-router-dom";
import Login from "./components/Login";
import Dashboard from "./components/Dashboard";
import SignUp from "./components/SignUp";
import interceptors from "./Interceptors";

class App extends Component {
  constructor() {
    super();
    this.state = {
      
    };
  }

 

  render() {
    return (
      <>
        <div className="app-context">
          <Router>
              <Route exact path="/" component={Login} />
              <Route  path="/dashboard" component={Dashboard} />
              <Route  path="/signup" component={SignUp} />
          </Router>
        </div>
      </>
    );
  }
}
export default App;
