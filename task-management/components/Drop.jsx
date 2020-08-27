import React from "react";

function Drop(props) {
  //state = {  }
  const dropElement = (e) => {
    //e.preventDefault();
    if (e.target.className === "drop") {
      return;
    }
    const card_id = e.dataTransfer.getData("card_id");
    const card = document.getElementById(card_id);
    e.target.appendChild(card);
  };

  const dragOver = (e) => {
    e.preventDefault();
  };

  return (
    <div
      id={props.id}
      className={props.className}
      onDrop={dropElement}
      onDragOver={dragOver}
    >
      {props.children}
    </div>
  );
}

export default Drop;
