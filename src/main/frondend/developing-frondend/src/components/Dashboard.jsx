import React, { Component } from "react";
import NavBar from "./NavBar";
class Dashboard extends Component {
  constructor(props) {
    super(props);
    this.state = {};
    // this.handleLogout = this.handleLogout.bind(this);
  }

  componentDidMount() {
    const user = localStorage.getItem("user");
    if (user === null) {
      this.handleLogout();
    }
  }

  handleLogout = () => {
    localStorage.clear();
    this.props.history.push("/");
  };

  render() {
    return (
      <>
        <header className="app-header">
          <NavBar></NavBar>
        </header>
        <main>
          <h1>WELCOME TO DASHBOARD</h1>
          <button type="button" onClick={this.handleLogout}>
            Signout
          </button>
        </main>
      </>
    );
  }
}
export default Dashboard;
