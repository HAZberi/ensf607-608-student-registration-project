import React from "react";
// import { Button } from "reactstrap";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
} from "react-router-dom";

import Layout from "./Layout";
import CourseCatalogue from "./CourseCatalogue";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route element={<Layout />}>
      <Route
        path="/"
        element={
          <div className="d-flex justify-content-center mt-5">
            <h1 className="text-center">
              Welcome to Course Registeration System
            </h1>
          </div>
        }
      />
      <Route
        path="/courses"
        element={
          <CourseCatalogue />
          // <div className="d-flex justify-content-center">
          //   <Button color="danger">Courses Catalogue</Button>
          // </div>
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
