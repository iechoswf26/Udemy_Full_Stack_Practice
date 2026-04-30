import {Routes, Route, Navigate} from "react-router-dom";
import Form from "../pages/Form.jsx";
import Carousel from "../pages/Carousel.jsx";
import {slides} from "../data/chapterOne.js";

export default function AppRoutes () {
    return (
        <Routes>
            <Route path="/" element={<Navigate to="/Form"/>}/>
            <Route path ={"/Carousel"} element={<Carousel slides={slides}/>}/>
            <Route path ={"/Form"} element={<Form/>}/>

        </Routes>
    )
}