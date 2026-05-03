import Navbar from "../src/Navbar_Components/Navbar.jsx";
import {BrowserRouter as Router} from "react-router-dom";
import AppRoutes from "../src/Navbar_Components/AppRoutes.jsx";


const App = () => {

  return (

      <Router>
          <Navbar/>
          <AppRoutes/>
      </Router>


  )
}

export default App;