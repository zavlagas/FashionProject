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
          sources={["local"]} // set the sources available for uploading -> by default
          // all sources are available. More information on their use can be found at
          // https://cloudinary.com/documentation/upload_widget#the_sources_parameter
          // sourceKeys={{
          //   dropboxAppKey: "1dsf42dl1i2",
          //   instagramClientId: "d7aadf962m",
          // }} // add source keys
          // and ID's as an object. More information on their use can be found at
          // https://cloudinary.com/documentation/upload_widget#the_sources_parameter
          resourceType={"image"} // optionally set with 'auto', 'image', 'video' or 'raw' -> default = 'auto'
          cloudName={"zavlagas"} // your cloudinary account cloud name.
          // Located on https://cloudinary.com/console/
          uploadPreset={"uploadImage"} // check that an upload preset exists and check mode is signed or unisgned
          // buttonText={"Open"} // default 'Upload Files'
          style={{
            color: "white",
            border: "none",
            width: "120px",
            backgroundColor: "green",
            borderRadius: "4px",
            height: "25px",
          }} // inline styling only or style id='cloudinary_upload_button'
          folder={"fashion"} // set cloudinary folder name to send file
          cropping={false} // set ability to crop images -> default = true
          onSuccess={this.successCallBack} // add success callback -> returns result
          onFailure={this.failureCallBack} // add failure callback -> returns 'response.error' + 'response.result'
          logging={false} // logs will be provided for success and failure messages,
          // set to false for production -> default = true
          customPublicId={"fashion"} // set a specific custom public_id.
          // To use the file name as the public_id use 'use_filename={true}' parameter
          eager={"w_400,h_300,c_pad|w_260,h_200,c_crop"} // add eager transformations -> deafult = null
          use_filename={false} // tell Cloudinary to use the original name of the uploaded
          // file as its public ID -> default = true,

          // 👇 FOR SIGNED UPLOADS ONLY 👇

          // generateSignatureUrl={
          //   "http://my_domain.com/api/v1/media/generate_signature"
          // } // pass the api
          // // endpoint for generating a signature -> check cloudinary docs and SDK's for signing uploads
          // apiKey={00000000000000} // cloudinary API key -> number format
          // accepts={"application/json"} // for signed uploads only -> default = 'application/json'
          // contentType={"application/json"} // for signed uploads only -> default = 'application/json'
          // withCredentials={true} // default = true -> check axios documentation for more information
          // unique_filename={true} // setting it to false, you can tell Cloudinary not to attempt to make
          // // the Public ID unique, and just use the normalized file name -> default = true
        />
      </>
    );
  }
}

export default CloudinaryWidget;
