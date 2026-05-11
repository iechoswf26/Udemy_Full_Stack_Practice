import React, {useContext, useEffect, useState} from 'react';
import Carousel from "../chapter_components/Carousel.jsx";
import NavbarOther from "../navbar_components/NavbarOther.jsx";
import {CardContext} from "../context/CheckpointContext.jsx";

const Chapter = () => {

    // Hook
    const chapterContext = useContext(CardContext)
    if (!chapterContext) {
        throw Error('Did not wrap in provider.')
    }

    // Anything in curly braces will extract from chapterContext.
    const {chapters} = chapterContext

    // Do this if: "A listener indicated an async response by returning true, but the message channel closed before a response was received."
    const [isLoading, setIsLoading] = useState(true) // Should always load first, hence true.

    useEffect(() => {
        if (chapters) {
            setIsLoading(false)
        }

        console.log(chapters)
    }, [chapters]);

    return (
        <>
            {isLoading ? <div>
                    <svg
                        className="w-48 text-white bg-black p-10"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                    >
                        <circle
                            className="opacity-25"
                            cx="12"
                            cy="12"
                            r="10"
                            stroke="currentColor"
                            strokeWidth="4"
                        ></circle>

                        <path
                            className="opacity-75"
                            fill="currentColor"
                            d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"
                        ></path>
                    </svg>
                </div> :


                <div className="bg-black">
                    <NavbarOther/>
                    <div className="flex flex-col items-center h-screen mt-12">
                        <div className="flex flex-col items-center justify center px-24">
                            <h1 className="text-white text-4xl font-heading font-bold my-3">{chapters.title}</h1>
                            <p className="text-white text-2xl font-body my-5 mx-32">{chapters.description}</p>
                        </div>

                        {
                            // chapters.map(chapter => <Carousel slides={chapter.slides} key={chapter.id}/>)

                            <Carousel slides={chapters.checkpoints} key={chapters.id}/>
                        }
                    </div>
                </div>}
        </>

    );
};

export default Chapter;