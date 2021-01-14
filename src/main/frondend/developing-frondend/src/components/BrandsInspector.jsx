import React, { Component } from "react";
import axios from "axios";

class BrandsInspector extends Component {
  constructor(props) {
    super(props);
    this.state = {
      brandsList: [],
      brandIsDeleted: false,
    };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick(event) {
    const buttonAction = event.target.textContent;
    if (buttonAction === "delete") {
      const brandIdForDelete = event.target.value;
      const endPoint = `http://localhost:8080/FashionProject/api/brands/${brandIdForDelete}`;
      axios.delete(endPoint).then((response) => {
        console.log(response);
        this.setState({
          handleDelete: response.data,
        });
      });
      const tempBrandList = this.state.brandsList.filter(
        (brand) => brand.id !== brandIdForDelete
      );
      this.setState({
        brandsList: tempBrandList,
      });
    }
  }

  componentDidMount() {
    const endpoint = "http://localhost:8080/FashionProject/api/brands";

    axios.get(endpoint).then((response) => {
      this.setState({
        brandsList: response.data,
      });
    });
  }

  render() {
    return (
      <>
        <div id="brands-container">
          <h2 className="brands-title-list">Brands List</h2>
          <table className="brands-table" onClick={this.handleClick}>
            <thead>
              <tr>
                <th>Id</th>
                <th>Logo</th>
                <th>Name</th>
                <th>Edit</th>
                <th>Delete</th>
              </tr>
            </thead>
            <tbody>
              {this.state.brandsList.map((brand) => {
                return (
                  <tr>
                    <td>{brand.id}</td>
                    <td>
                      <img src={brand.imagePath} />
                    </td>
                    <td>{brand.name}</td>
                    <td>
                      <button value={brand.id}>Edit</button>
                    </td>
                    <td>
                      <button value={brand.id}>delete</button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
          <p>{this.state.brandIsDeleted ? "Succesfully Deleted" : ""}</p>
        </div>
      </>
    );
  }
}

export default BrandsInspector;
