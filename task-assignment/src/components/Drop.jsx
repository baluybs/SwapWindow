import React from "react";

function Drop(props) {
  const dragOver = (e) => {
    e.preventDefault();
  };

  return (
    <div
      id={props.id}
      className={props.className}
      onDrop={props.dropElement}
      onDragOver={dragOver}
    >
      {props.children}
    </div>
  );
}

export default Drop;
