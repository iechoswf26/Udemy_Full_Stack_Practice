import Navbar from "./Navbar_Components/Navbar.jsx";
import {BrowserRouter as Router} from "react-router-dom";
import AppRoutes from "./Navbar_Components/AppRoutes.jsx";


const App = () => {


    // const [isOpen, setIsOpen] = useState(false)


  return (
      <div>

          <Router>
              <Navbar/>
              <AppRoutes/>
          </Router>


          {/*<Carousel slides={slides} isPageBackground={false}/>*/}
          {/*<Form/>*/}


      </div>
  )
}

export default App;