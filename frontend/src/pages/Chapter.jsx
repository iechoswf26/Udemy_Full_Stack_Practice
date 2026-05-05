import React from 'react';
import Carousel from "./Carousel.jsx";
import {chapters} from "../data/chapters.js"

const Chapter = () => {
    return (
        <div>
            {
                chapters.map(chapter => <Carousel slides={chapter.slides} key={chapter.id}/>)
            }
        </div>
    );
};

export default Chapter;