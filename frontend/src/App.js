import React from "react";
import { Button } from "reactstrap";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
} from "react-router-dom";

import Layout from "./Layout";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route element={<Layout />}>
      <Route
        path="/"
        element={
          <h1 className="text-center">
            Welcome to Student Course Registeration System
          </h1>
        }
      />
      <Route
        path="/courses"
        element={
          <div className="d-flex justify-content-center">
            <Button color="danger">Courses Catalogue</Button>
          </div>
        }
      />
      <Route
        path="/reg-courses"
        element={<h1 className="text-center">Registered Courses List</h1>}
      />
    </Route>
  )
);

function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
