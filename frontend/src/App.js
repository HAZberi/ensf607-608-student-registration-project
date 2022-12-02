import React from "react";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
  defer,
} from "react-router-dom";

import Layout from "./Layout";
import CourseCatalogue from "./CourseCatalogue";
import RegisteredCourses from "./RegisteredCourses";
import NotSignedIn from "./NotSignedIn";
import Home from "./Home";

const getUserData = () =>
  new Promise((resolve) =>
    setTimeout(() => {
      const user = window.localStorage.getItem("user");
      resolve(user);
    }, 1000)
  );
const router = createBrowserRouter(
  createRoutesFromElements(
    <Route
      element={<Layout />}
      loader={() => defer({ userPromise: getUserData() })}
    >
      <Route
        path="/"
        element={<Home />}
      />
      <Route path="/courses" element={<CourseCatalogue />} />
      <Route path="/reg-courses" element={<RegisteredCourses />} />
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
