import React, { Component } from "react";

class NavBar extends Component {
  state = {};
  render() {
    return (
      <nav>
        <h2 style={{ textAlign: "left" }}>
          {" "}
          My Task Tracker
          <button
            className="btn btn-warning"
            style={{ textAlign: "right", marginLeft: "750px" }}
          >
            New Task
          </button>
        </h2>
      </nav>
    );
  }
}

export default NavBar;
