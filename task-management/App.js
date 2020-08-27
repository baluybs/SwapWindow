import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./App.css";
import Drop from "./components/Drop";
import Cards from "./components/Cards";
import NavBar from "./components/navbar";

class App extends Component {
  state = {
    tasks: [
      { category: "initialTask", bgcolor: "tan" },
      { category: "progressTask", bgcolor: "seagreen" },
      { category: "completedTask", bgcolor: "red" },
    ],
  };

  render() {
    var tasks = {
      initialTask: [],
      progressTask: [],
      completedTask: [],
    };

    this.state.tasks.forEach((t) => {});

    return (
      <div className="App">
        <NavBar />
        <hr></hr>
        <main className="flex">
          <Drop id="drop-1" className="drop">
            <h3>initial task</h3>
            <Cards id="card-1" className="card" draggable="true">
              <p>This is your card</p>
            </Cards>
          </Drop>

          <Drop id="drop-2" className="drop">
            <h3>progress task</h3>
            <Cards id="card-2" className="card" draggable="true">
              <p>This is your second card</p>
            </Cards>
          </Drop>

          <Drop id="drop-3" className="complete">
            <h3>completed task</h3>
            <Cards id="card-3" className="card" draggable="true">
              <p>this is the third card</p>
            </Cards>
          </Drop>
        </main>
      </div>
    );
  }
}

export default App;
