import React, { Component } from "react";

import { WidgetLoader, Widget } from "react-cloudinary-upload-widget";

class CloudinaryWidget extends Component {
  constructor(props) {
    super(props);
    this.successCallBack = this.successCallBack.bind(this);
    this.failureCallBack = this.failureCallBack.bind(this);
  }

  successCallBack(response) {
    this.props.passResponse(response);
  }

  failureCallBack(response) {
    this.props.passResponse(response);
  }

  render() {
    return (
      <>
        <WidgetLoader />
        <Widget
          buttonText="Upload Images"
          sources={["local"]}
          resourceType={"image"}
          cloudName={"zavlagas"}
          uploadPreset={"uploadImage"}
          style={{
            color: "white",
            border: "none",
            width: "130px",
            backgroundColor: "rgba(92, 39, 81, 1)",
            borderRadius: "10px",
            height: "35px",
          }}
          folder={"fashion"}
          cropping={false}
          onSuccess={this.successCallBack}
          onFailure={this.failureCallBack}
          logging={false}
          customPublicId={"fashion"}
          eager={"w_400,h_300,c_pad|w_260,h_200,c_crop"}
          use_filename={false}
        />
      </>
    );
  }
}

export default CloudinaryWidget;
