import Navbar from "../src/Navbar_Components/Navbar.jsx";
import {BrowserRouter as Router} from "react-router-dom";
import AppRoutes from "../src/Navbar_Components/AppRoutes.jsx";
import {CheckpointContext} from './Context/CheckpointContext.jsx'


const App = () => {

  return (
      <CheckpointContext>
          <Router>
              <Navbar/>
              <AppRoutes/>
          </Router>
      </CheckpointContext>


  )
}

export default App;