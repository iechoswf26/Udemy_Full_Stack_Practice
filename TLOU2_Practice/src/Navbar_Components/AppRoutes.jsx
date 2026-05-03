import {Routes, Route, Navigate} from "react-router-dom";
import Form from "../pages/Form.jsx";
import Carousel from "../pages/Carousel.jsx";
import {slides} from "../data/chapterOne.js";
import LandingPage from "../pages/LandingPage.jsx";

export default function AppRoutes () {
    return (
        <Routes>
            <Route path={"/LandingPage"} element={<LandingPage/>}/>
            <Route path ={"/Carousel"} element={<Carousel slides={slides}/>}/>
            <Route path ={"/Form"} element={<Form/>}/>

        </Routes>
    )
}