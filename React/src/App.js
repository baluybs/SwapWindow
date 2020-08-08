import React, { Component } from "react";
import NavBar from "./components/navbar";
import "./App.css";
import Counters from "./components/counters";
class App extends Component {
  state = {
    counter: [
      { id: 1, value: 4 },
      { id: 2, value: 0 },
      { id: 3, value: 0 },
      { id: 4, value: 0 },
    ],
  };
  handleIncrement = (counters) => {
    const counter = [...this.state.counter];
    const index = counter.indexOf(counters);
    counter[index] = { ...counters };
    counter[index].value++;
    this.setState({ counter });
  };
  handleDelete = (counterId) => {
    const counter = this.state.counter.filter((c) => c.id !== counterId);
    this.setState({ counter });
  };
  handleReset = () => {
    const counters = this.state.counter.map((c) => {
      c.value = 0;
      return c;
    });
    this.setState({ counters });
  };
  render() {
    return (
      <React.Fragment>
        <NavBar
          totalCounters={this.state.counter.filter((c) => c.value > 0).length}
        />
        <main className="container">
          <Counters
            counter={this.state.counter}
            onReset={this.handleReset}
            onIncrement={this.handleIncrement}
            onDelete={this.handleDelete}
          />
        </main>
      </React.Fragment>
    );
  }
}

export default App;
