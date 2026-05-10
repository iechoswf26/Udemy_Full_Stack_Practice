import NavbarHome from "./navbar_components/NavbarHome.jsx";
import {BrowserRouter as Router} from "react-router-dom";
import AppRoutes from "./navbar_components/AppRoutes.jsx";
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