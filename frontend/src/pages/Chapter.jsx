import React from 'react';
import Carousel from "./Carousel.jsx";
import {chapters} from "../data/chapters.js"
import NavbarOther from "../Navbar_Components/NavbarOther.jsx";

const Chapter = () => {
    return (
        <div>
            <NavbarOther/>
            {
                chapters.map(chapter => <Carousel slides={chapter.slides} key={chapter.id}/>)
            }
        </div>
    );
};

export default Chapter;