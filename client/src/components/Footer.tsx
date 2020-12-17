import React from "react";

const Footer = () => {
  const style: React.CSSProperties = {
    width: "100%",
    background: "black",
    color: "white",
    paddingTop: "0.5em",
    paddingBottom: "0.5em",
    textAlign: "right",
    position: "absolute",
    bottom: 0,
  };
  return (
    <div className="footer" style={style}>
      2020/12/17
    </div>
  );
};

export default Footer;
