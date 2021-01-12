import React, { Component } from "react";

class BrandGenerator extends Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }


  handleFormSubmit(){

  }



  render() {
    return (
      <>
        <form className="form-brand-creator" onSubmit={this.handleFormSubmit}>
            
        </form>
      </>
    );
  }
}

export default BrandGenerator;
