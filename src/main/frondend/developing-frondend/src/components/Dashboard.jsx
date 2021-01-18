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
      user: {
        firstName: "",
        lastName: "",
        roleList: [],
        username: "",
      },
    };
    this.toggleChatButton = this.toggleChatButton.bind(this);
  }

  componentDidMount() {
    const user = JSON.parse(localStorage.getItem("user"));
    if (user === null) {
      this.handleLogout();
    } else {
      this.setState({
        user: {
          firstName: user.firstName,
          lastName: user.lastName,
          roleList: user.roleList,
          username: user.username,
        },
      });
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
          <h1
            onClick={() => this.props.history.push("/dashboard/home")}
            id="logo"
          >
            FashionBook
          </h1>
          <Search />
          <NavBar url={match.url} />
          <div className="app-header-user">
            <Link className="profile-link" to={`${match.url}/profile`}>
              <div className="user-profile">
                <img src="https://picsum.photos/100/100" />
                <span>Profile</span>
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
        <Route
          path={`${match.path}/home`}
          render={() => (
            <Home
              {...this.props}
              authUser={JSON.parse(localStorage.getItem("user"))}
            />
          )}
        />
        <Route
          path={`${match.path}/profile`}
          {...this.props}
          render={() => (
            <Profile
              {...this.props}
              authUser={JSON.parse(localStorage.getItem("user"))}
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
