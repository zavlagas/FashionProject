import React, { Component } from "react";
import SockJsClient from "react-stomp";
import axios from "axios";
import { TalkBox } from "react-talk";
import UsernameGenerator from "username-generator";

const randomstring = require("randomstring");
class Chat extends Component {
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

  componentWillMount() {
    axios
      .get("http://localhost:8080/FashionProject/history")
      .then((response) => {
        this.setState({ messages: response.body });
      });
  }

  render() {
    const wsSourceUrl =
      window.location.protocol + "//" + window.location.host + "/handler";
    return (
      <div>
        <TalkBox
          topic="react-websocket-template"
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
          debug={false}
        />
      </div>
    );
  }
}

export default Chat;
