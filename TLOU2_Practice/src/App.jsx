import {slides} from './data/chapterOne.js'
import SampleCarousel from "./components/SampleCarousel.jsx";
import Form from "./pages/Form.jsx";


const App = () => {


    // const [isOpen, setIsOpen] = useState(false)


  return (
      <div>

          <SampleCarousel slides={slides} isPageBackground={false}/>
          {/*<Form/>*/}


      </div>
  )
}

export default App;