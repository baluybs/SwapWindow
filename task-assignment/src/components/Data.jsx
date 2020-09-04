import React, { useState } from "react";
import { Button } from "react-bootstrap";
import { Modal } from "react-bootstrap";
import NavBar from "./navbar";
import Task from "./Task";

function Data() {
  const [show, setShow] = useState(false);
  const [status, setStatus] = useState();
  const [priority, setPriority] = useState();
  const [title, setTitle] = useState();

  const onClickListener = () => {
    setShow(false);
  };

  const onChangeTitle = (e) => {
    setTitle(e.target.value);
    console.log(title);
  };

  const onChangeStatus = (e) => {
    setStatus(e.target.value);
    //console.log(status);
  };
  const onChangePriority = (e) => {
    setPriority(e.target.value);
    //console.log(priority);
  };
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  return (
    <>
      <NavBar onClick={handleShow} />
      <hr></hr>
      <Modal show={show} onHide={handleClose} animation="border">
        <Modal.Header closeButton className="bg-warning">
          <Modal.Title>Task details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <form>
            <div className="form-group">
              <label>Title:</label>
              <input
                type="text"
                name="title"
                onChange={onChangeTitle}
                placeholder="Enter Title"
                className="form-control"
              />
            </div>
            <div className="form-group">
              <label>Description:</label>
              <input
                type="text"
                name="des"
                placeholder="Enter Descritpion"
                className="form-control"
              />
            </div>
            <div className="from-group">
              <label>Status:</label>
              <div className="radio">
                <input
                  type="radio"
                  value="initial"
                  name="status"
                  checked={status === "initial"}
                  onChange={onChangeStatus}
                  className="btn-danger"
                  style={{ marginRight: "15px" }}
                />
                Initial
                <input
                  type="radio"
                  value="progress"
                  name="priority"
                  checked={status === "progress"}
                  onChange={onChangeStatus}
                  className="btn-danger"
                  style={{ marginLeft: "15px", marginRight: "15px" }}
                />
                Progress
                <input
                  type="radio"
                  value="complete"
                  name="status"
                  checked={status === "complete"}
                  onChange={onChangeStatus}
                  className="btn-danger"
                  style={{ marginLeft: "15px", marginRight: "15px" }}
                />
                Completed
              </div>
            </div>
            <div className="from-group">
              <label>Creation Date:</label>
              <input type="date" name="date" className="form-control" />
            </div>
            <div className="from-group">
              <label>Completion Date:</label>
              <input type="date" name="date" className="form-control" />
            </div>
            <div className="from-group">
              <label>Priority:</label>
              <div>
                <input
                  type="radio"
                  value="High"
                  name="priority"
                  checked={priority === "High"}
                  onChange={onChangePriority}
                  className="btn-danger"
                  style={{ marginRight: "15px" }}
                />
                High
                <input
                  type="radio"
                  value="Medium"
                  name="priority"
                  checked={priority === "Medium"}
                  onChange={onChangePriority}
                  className="btn-danger"
                  style={{ marginLeft: "15px", marginRight: "15px" }}
                />
                Medium
                <input
                  type="radio"
                  value="Low"
                  name="priority"
                  //checked={selectedPriority === "Low"}
                  checked={priority === "Low"}
                  onChange={onChangePriority}
                  className="btn-danger"
                  style={{ marginLeft: "15px", marginRight: "15px" }}
                />
                Low
              </div>
            </div>
          </form>
        </Modal.Body>
        <Modal.Footer className="bg-warning">
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={onClickListener}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
      <Task status={status} priority={priority} title={title} />
    </>
  );
}

export default Data;
