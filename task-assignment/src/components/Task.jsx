import React, { Component } from "react";
import Drop from "./Drop";
import Cards from "./Cards";

class Task extends Component {
  state = {
    tasks: [{ name: "", category: "", bgcolor: "tan" }],
  };
  dragStart = (e) => {
    const target = e.target;
    e.dataTransfer.setData("card_id", target.id);
    console.log(this.props.status);
  };

  dropElement = (e, cat) => {
    e.preventDefault();
    const card_id = e.dataTransfer.getData("card_id");
    const card = document.getElementById(card_id);
    e.target.appendChild(card);
    console.log(cat);
    let tasks = this.state.tasks.filter((t) => {
      if (cat === "initial") {
        t.name = card.className;
        t.category = cat;
        t.bgcolor = "tan";
      } else if (cat === "progress") {
        t.name = card.className;
        t.category = cat;
        t.bgcolor = "seagreen";
      } else if (cat === "complete") {
        t.name = card.className;
        t.category = cat;
        t.bgcolor = "red";
      }
      card.style.backgroundColor = t.bgcolor;
      return t;
    });
    this.setState({ ...this.state, tasks });
  };

  render() {
    console.log(this.props.status);
    console.log(this.props.priority);
    return (
      <main className="flex">
        <Drop
          id="initial"
          className="drop"
          dropElement={(e) => this.dropElement(e, "initial")}
        >
          <h3>initial task</h3>
          <Cards
            id="card-1"
            className={this.props.status}
            draggable="true"
            dragStart={this.dragStart}
            onChange={this.handleChange}
            status={this.props.status}
            priority={this.props.priority}
          >
            <p>{this.props.title}</p>
          </Cards>
        </Drop>

        <Drop
          id="progress"
          className="drop"
          dropElement={(e) => this.dropElement(e, "progress")}
        >
          <h3>progress task</h3>
        </Drop>

        <Drop
          id="complete"
          className="drop"
          dropElement={(e) => this.dropElement(e, "complete")}
        >
          <h3>completed task</h3>
        </Drop>
      </main>
    );
  }
}

export default Task;
