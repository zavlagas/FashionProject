import React, { Component } from "react";
import NavBar from "./NavBar";
import Chat from "./Chat";
class Dashboard extends Component {
  constructor(props) {
    document
      .querySelector(".app-container")
      .classList.remove("background-image");
    super(props);
    this.state = {
      chatActive: false,
    };
    this.toggleChatButton = this.toggleChatButton.bind(this);
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

  toggleChatButton(event) {
    let active = this.state.chatActive;
    if (event.target.id === "chat-button") {
      this.setState({
        chatActive: !active,
      });
    }
  }

  toggleChatMovement() {
    if (this.state.chatActive) {
      return <Chat />;
    } else {
      return null;
    }
  }

  render() {
    return (
      <>
        <header className="app-header">
          <img id="logo" src="https://i.imgur.com/4mrud7p.gif" />
          <NavBar />
        </header>
        <main>
          <h1>WELCOME TO DASHBOARD</h1>

          <button type="button" onClick={this.handleLogout}>
            Signout
          </button>
        </main>
        <footer></footer>
        <div onClick={this.toggleChatButton} className="chat-container">
          <button id="chat-button">Chat</button>
          {this.toggleChatMovement()}
        </div>
      </>
    );
  }
}
export default Dashboard;
