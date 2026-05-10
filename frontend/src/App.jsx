import NavbarHome from "./Navbar_Components/NavbarHome.jsx";
import {BrowserRouter as Router} from "react-router-dom";
import AppRoutes from "../src/Navbar_Components/AppRoutes.jsx";
import {CheckpointContext} from './context/CheckpointContext.jsx'


const App = () => {

  return (
      <CheckpointContext>
          <Router>
              {/*<NavbarHome/>*/}
              <AppRoutes/>
          </Router>
      </CheckpointContext>


  )
}

export default App;