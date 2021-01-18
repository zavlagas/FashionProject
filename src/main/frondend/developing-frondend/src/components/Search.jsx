import React from "react";
class Search extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      query: "",
      results: {},
      loading: false,
      message: "",
    };
    this.handleOnInputChange = this.handleOnInputChange.bind(this);
  }

  handleOnInputChange = (event) => {
    const query = event.target.value;
    this.setState({
      query,
      loading: true,
      message: "",
    });
  };

  render() {
    return (
      <div className="search-container">
        <label className="search-label" htmlFor="search-input">
          <input
            type="text"
            id="search-input"
            className="styled-input"
            placeholder="Search Profiles..."
            onChange={this.handleOnInputChange}
          />
          {/* <i className="fa fa-search search-icon" /> */}
        </label>
      </div>
    );
  }
}
export default Search;
