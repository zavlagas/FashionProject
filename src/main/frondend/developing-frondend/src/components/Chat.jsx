import React, { Component } from "react";
import SockJsClient from "react-stomp";
import axios from "axios";
import { TalkBox } from "react-talk";
import UsernameGenerator from "username-generator";

const randomstring = require("randomstring");
class Chat extends Component {
  _isMounted = false;
  constructor(props) {
    super(props);
    this.randomUserName = UsernameGenerator.generateUsername("-");
    this.randomUserId = randomstring.generate();
    this.state = {
      clientConnected: false,
      messages: [],
    };
  }
  onMessageReceive = (msg, topic) => {
    this.setState((prevState) => ({
      messages: [...prevState.messages, msg],
    }));
  };

  sendMessage = (msg, selfMsg) => {
    try {
      this.clientRef.sendMessage("/app/all", JSON.stringify(selfMsg));
      return true;
    } catch (e) {
      return false;
    }
  };

  componentDidMount() {
    this._isMounted = true;
    axios
      .get("http://localhost:8080/FashionProject/history")
      .then((response) => {
        console.log(response.data);
        if (this._isMounted) {
          this.setState({ messages: response.data });
        }
      });
  }

  render() {
    const wsSourceUrl = "http://localhost:8080/FashionProject/handler";
    return (
      <div>
        <TalkBox
          topic="Chat"
          currentUserId={this.randomUserId}
          currentUser={this.randomUserName}
          messages={this.state.messages}
          onSendMessage={this.sendMessage}
          connected={this.state.clientConnected}
        />

        <SockJsClient
          url={wsSourceUrl}
          topics={["/topic/all"]}
          onMessage={this.onMessageReceive}
          ref={(client) => {
            this.clientRef = client;
          }}
          onConnect={() => {
            this.setState({ clientConnected: true });
          }}
          onDisconnect={() => {
            this.setState({ clientConnected: false });
          }}
          debug={true}
        />
      </div>
    );
  }
}

export default Chat;
