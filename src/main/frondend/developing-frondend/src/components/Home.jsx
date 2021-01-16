import React, { Component } from "react";
import axios from "axios";
class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      productList: [],
    };
  }

  componentDidMount() {
    const endPoint = "http://localhost:8080/FashionProject/api/products";
    axios.get(endPoint).then((response) => {
      this.setState({
        productList: response.data,
      });
    });
  }

  render() {
    return (
      <>
        <main className="home-container">
          <div className="posts-list-container">
            {this.state.productList.map((product) => {
              return (
                <>
                  <article className="post-container">
                    <section className="post-header-user-container">
                      <img
                        className="brand-image"
                        src={product.brand.imagePath}
                      />
                      <p className="brand-dtls">{product.name}</p>
                    </section>
                    <section className="post-image-container">
                      <img
                        className="post-image"
                        src={product.productImageList[0].imagePath}
                      />
                    </section>
                    <section className="post-interact-container">
                      <div className="rating-section">
                        <i class="far fa-heart"></i>
                      </div>
                      <div className="product-description">{product.descr}</div>
                    </section>
                  </article>
                </>
              );
            })}
          </div>
          <aside>Aside</aside>
        </main>
      </>
    );
  }
}

export default Home;
