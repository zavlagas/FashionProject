import React, { Component } from "react";
import Search from "./Search";
import NavBar from "./NavBar";
import Chat from "./Chat";
import Home from "./Home";
import Profile from "./Profile";
import { Link, Route } from "react-router-dom";

class Dashboard extends Component {
  constructor(props) {
    document
      .querySelector(".app-container")
      .classList.remove("background-image");
    super(props);
    this.state = {
      chatActive: false,
      props: this.props,
      user: JSON.parse(localStorage.getItem("user")),
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
      return <Chat username={this.state.user.username} />;
    } else {
      return null;
    }
  }

  render() {
    const { match } = this.state.props;
    return (
      <>
        <header className="app-header">
          <h1 id="logo">FashionBook</h1>
          <Search />
          <NavBar url={match.url} />
          <div className="app-header-user">
            <Link to={`${match.url}/profile`}>
              <div className="user-profile">
                <img src="https://picsum.photos/100/100" />
                <span>{this.state.user.username}</span>
              </div>
            </Link>
            <button
              className="sign-out-btn"
              type="button"
              onClick={this.handleLogout}
            >
              Signout
            </button>
          </div>
        </header>
        <Route path={`${match.path}/home`} component={Home} />
        <Route
          path={`${match.path}/profile`}
          {...this.props}
          render={() => (
            <Profile
              key={this.state.user}
              {...this.props}
              authUser={this.state.user}
            />
          )}
        />
        <div onClick={this.toggleChatButton} className="chat-container">
          <button id="chat-button">Chat</button>
          {this.toggleChatMovement()}
        </div>
      </>
    );
  }
}
export default Dashboard;
