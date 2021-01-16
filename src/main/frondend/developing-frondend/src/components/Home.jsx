import React, { Component } from "react";

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <>
        <main className="home-container">
          <div className="posts-list-container">
            <article className="post-container">
              <section className="post-header-user-container">
                <img
                  className="brand-image"
                  src="https://res.cloudinary.com/zavlagas/image/upload/v1610798782/fashion/Versace-Logo_yrewuq.png"
                />
                <p className="brand-dtls">
                  Lorem ipsum dolor sit amet consectetur adipisicing elit.
                  Magnam necessitatibus aspernatur
                </p>
              </section>
              <section className="post-image-container">
                <img
                  className="post-image"
                  src="https://picsum.photos/800/800"
                />
              </section>
              <section className="post-interact-container">
                <div className="rating-section">
                  <i class="far fa-heart"></i>
                </div>
                <div className="product-description">
                  ducimus est consectetur nulla architecto quasi fugit quibusdam
                  eum eos deleniti velit ipsa facere voluptatibus? Facilis
                  blanditiis, consequatur impedit commodi odit ut ad tempore.
                </div>
              </section>
            </article>
          </div>
          <aside>Aside</aside>
        </main>
      </>
    );
  }
}

export default Home;
