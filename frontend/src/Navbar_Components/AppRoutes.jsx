import {Routes, Route} from "react-router-dom";
import Form from "../pages/Form.jsx";
import LandingPage from "../pages/LandingPage.jsx"
import Chapter from "../pages/Chapter.jsx";

export default function AppRoutes () {
    return (
        <Routes>
            <Route path={"/"} element={<LandingPage/>}/>
            <Route path ={"/Chapters"} element={<Chapter/>}/>
            <Route path ={"/Form"} element={<Form/>}/>

        </Routes>
    )
}