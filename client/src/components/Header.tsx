import React from "react";

const Header = () => {
  const style: React.CSSProperties = {
    width: "100%",
    background: "black",
    color: "white",
    paddingTop: "1em",
    paddingBottom: "1em",
  };
  return (
    <div className="header" style={style}>
      Book Manager
    </div>
  );
};

export default Header;
