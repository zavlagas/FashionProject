import React, { useState } from "react";




const Navbar = () => {
  const [isOpen, setOpen] = useState(false);
  return (
    <nav className="navbar" role="navigation">
      <ul>
        <li>
          <i class="fas fa-home"></i>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
