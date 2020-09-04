import React, { Component } from "react";

class Card extends Component {
  // dragStart = (e) => {
  //   const target = e.target;
  //   e.dataTransfer.setData("card_id", target.id);
  // };

  dragOver = (e) => {
    e.stopPropagation();
  };

  render() {
    return (
      <div
        id={this.props.id}
        className={this.props.className}
        draggable={this.props.draggable}
        onDragStart={this.props.dragStart}
        onDragOver={this.dragOver}
      >
        {this.props.children}
      </div>
    );
  }
}

export default Card;
