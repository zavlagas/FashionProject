import React, { Component } from "react";
import { Role } from "../variables/Roles";

class Profile extends Component {
  constructor(props) {
    super(props);
    this.state = {
      currentUser: this.props.authUser,
      isAdmin: false,
    };
  }

  componentDidMount() {
    const { roleList } = this.state.currentUser;
    console.log(roleList);
    if (roleList.some((e) => e.type === Role.Admin)) {
      this.setState({
        isAdmin: true,
      });
    }
  }

  render() {
    return (
      <>
        <h1>Hello From Profile</h1>
      </>
    );
  }
}

export default Profile;
