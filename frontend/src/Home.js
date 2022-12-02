import React from "react";
import { useAuth } from "./hooks/useAuth";
import NotSignedIn from "./NotSignedIn";

function Home(args) {
  const { user } = useAuth();

  return (
    <>
      {!!user ? (
        <div className="d-flex flex-column mt-5 mb-5">
            <h1 className="text-center mb-4">{`Hi ${user.StudentName}!`}</h1>
            <h2 className="text-center">
              Welcome to Course Registeration System
            </h2>
          </div>
      ) : (
        <>
          <div className="d-flex justify-content-center mt-5 mb-5">
            <h1 className="text-center">
              Welcome to Course Registeration System
            </h1>
          </div>
          <NotSignedIn />
        </>
      )}
    </>
  );
}

export default Home;
