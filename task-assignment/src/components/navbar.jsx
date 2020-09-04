import React, { Component } from "react";

class NavBar extends Component {
  render() {
    return (
      <nav>
        <h2 style={{ textAlign: "left" }}>
          {" "}
          My Task Tracker
          <button
            className="btn btn-warning"
            style={{ textAlign: "right", marginLeft: "750px" }}
            onClick={this.props.onClick}
          >
            New Task
          </button>
        </h2>
      </nav>
    );
  }
}

export default NavBar;
