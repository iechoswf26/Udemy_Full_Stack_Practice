import React from 'react';
import Carousel from "./Carousel.jsx";
import {chapters} from "../data/chapters.js"
import NavbarOther from "../Navbar_Components/NavbarOther.jsx";

const Chapter = () => {
    return (
        <div className="bg-black">
            <NavbarOther/>
            <div className="flex flex-col items-center h-screen mt-12">
                <div className="flex flex-col items-center justify center px-24">
                    <h1 className="text-white text-4xl font-heading font-bold my-3">Chapter 1 - Jackson</h1>
                    <p className="text-white text-2xl font-body my-3">In The Last of Us Part II, Chapter 1: Jackson introduces a fragile sense of peace as Ellie and Joel live among a thriving survivor community. During a winter patrol, Joel and Tommy rescue a stranger named Abby, unknowingly placing themselves in danger. They follow her to a nearby lodge, where they are ambushed by her group seeking revenge for past actions. The chapter ends with Joel’s brutal death, shattering the calm of Jackson and setting Ellie on a path driven by grief and vengeance.</p>
                </div>

                {
                    chapters.map(chapter => <Carousel slides={chapter.slides} key={chapter.id}/>)
                }
            </div>
        </div>
    );
};

export default Chapter;