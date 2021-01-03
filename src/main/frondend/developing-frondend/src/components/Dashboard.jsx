import React, { Component } from "react";

class Dashboard extends Component {
  handleLogout() {
    localStorage.clear();
    window.location.href = "/";
  }

  render() {
    return (
      <div>
        <h1>WELCOME TO DASHBOARD</h1>

        <button
          type="button"
          onClick={this.handleLogout}
          className="d-b td-n pY-5 bgcH-grey-100 c-grey-700"
        >
          Signout
        </button>
      </div>
    );
  }
}
export default Dashboard;
