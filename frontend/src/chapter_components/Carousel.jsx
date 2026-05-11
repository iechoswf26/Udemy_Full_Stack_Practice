//react
import React, { useState, useRef, useEffect, useContext } from 'react'
//react dom
import { createRoot } from 'https://esm.sh/react-dom@18.2.0/client';
import PropTypes from 'prop-types';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAngleLeft, faAngleRight} from "@fortawesome/free-solid-svg-icons";
import {useNavigate} from "react-router";
import {CardContext} from "../context/CheckpointContext.jsx";


function useTilt(animationDuration = '150ms') {
    const ref = useRef(null);

    useEffect(() => {
        if (!ref.current) {
            return;
        }

        // used to unify the touch and click cases
        const unify = (e) => (e.changedTouches ? e.changedTouches[0] : e);

        const state = {
            rect: undefined,
            mouseX: undefined,
            mouseY: undefined,
        };

        let el = ref.current;

        const handleEnterEvent = () => {
            el.style.transition = `transform ${animationDuration} ease-out`;
        };

        const handleMoveEvent = (e) => {
            e.preventDefault();

            if (!el) {
                return;
            }
            if (!state.rect) {
                state.rect = el.getBoundingClientRect();
            }
            state.mouseX = unify(e).clientX;
            state.mouseY = unify(e).clientY;

            const px = (state.mouseX - state.rect.left) / state.rect.width;
            const py = (state.mouseY - state.rect.top) / state.rect.height;

            el.style.setProperty('--px', px.toFixed(2));
            el.style.setProperty('--py', py.toFixed(2));
        };

        const handleEndEvent = () => {
            el.style.setProperty('--px', 0.5);
            el.style.setProperty('--py', 0.5);
            el.style.transition = `transform ${animationDuration} ease-in`;
        };

        el.addEventListener('mouseenter', handleEnterEvent);
        el.addEventListener('mousemove', handleMoveEvent);
        el.addEventListener('mouseleave', handleEndEvent);
        el.addEventListener('touchstart', handleEnterEvent);
        el.addEventListener('touchmove', handleMoveEvent);
        el.addEventListener('touchend', handleEndEvent);

        return () => {
            el.removeEventListener('mouseenter', handleEnterEvent);
            el.removeEventListener('mousemove', handleMoveEvent);
            el.removeEventListener('mouseleave', handleEndEvent);
            el.removeEventListener('touchstart', handleEnterEvent);
            el.removeEventListener('touchmove', handleMoveEvent);
            el.removeEventListener('touchend', handleEndEvent);
        };
    }, [animationDuration]);

    return ref;
}

export const Slide = ({ id, image, title, description, question, offset, isPageBackground }) => {
    const active = offset === 0,
        ref = useTilt(active);

    const navigate = useNavigate()

    const context = useContext(CardContext)
    if (!context) {
        throw Error("Outside of provider!")
    }

    const {setNewCard} = context

    const slideObject = {
        id, image, title, description, question, offset, isPageBackground
    }

    const handleClick = () => {
        setNewCard(slideObject)
        navigate("/Posts")
    }

    return (
        <div
            ref={ref}
            className="slide hover:cursor-pointer"
            data-active={active}
            style={{
                '--offset': offset,
                '--dir': offset === 0 ? 0 : offset > 0 ? 1 : -1,
            }}

            onClick={handleClick}
        >
            {isPageBackground && (
                <div
                    className="slideBackground"
                    style={{
                        backgroundImage: `url('${image}')`,
                    }}
                />
            )}
            <div
                ref={ref}
                className="slideContent shadow-lg shadow-white"
                style={{
                    backgroundImage: `url('${image}')`,
                }}
            >
                <div className="slideContentInner p-10">
                    {title && (
                        <h2 className="slideTitle font-heading text-2xl py-4" dir="auto">
                            {title}
                        </h2>
                    )}
                    {/*{description && (*/}
                    {/*    <h3 className="slideDescription font-body text-shadow-white" dir="auto">*/}
                    {/*        {description}*/}
                    {/*    </h3>*/}
                    {/*)}*/}
                    {question && (
                        <p className="slideQuestion font-body text-xl" dir="auto">
                            {question}
                        </p>
                    )}
                </div>
            </div>
        </div>
    );
};

Slide.propTypes = {
    id: PropTypes.number.isRequired,
    image: PropTypes.string.isRequired,
    title: PropTypes.string,
    description: PropTypes.string,
    question: PropTypes.string,
    offset: PropTypes.number.isRequired,
    isPageBackground: PropTypes.bool,
};

const Carousel = ({ slides, isPageBackground }) => {
    const [slideIndex, setSlideIndex] = useState(0);

    const handlePrevSlide = () => {
        setSlideIndex((prev) => (prev === 0 ? 0 : prev - 1));
    };

    const handleNextSlide = () => {
        setSlideIndex((prev) => (prev + 1 == slides.length) ? prev : prev + 1);
    };

    return (
        <div>
            <div className="flex flex-row justify-center my-12">
                <button onClick={handlePrevSlide} >
                    <FontAwesomeIcon icon={faAngleLeft} className="text-6xl text-white font-bold"/>
                </button>

                <section className="slidesWrapper">
                    <div className="slides">

                        {slides.map((slide, i) => {
                            let offset = i- slideIndex;

                            if (typeof slide === 'string') {
                                return (
                                    <Slide id={slide.id} image={slide} offset={offset} isPageBackground={isPageBackground} key={i} />
                                );
                            } else {
                                return (
                                    <Slide
                                        id={slide.id}
                                        image={slide.image}
                                        title={slide.title}
                                        description={slide.description}
                                        question={slide.question}
                                        offset={offset}
                                        isPageBackground={isPageBackground}
                                        key={i}
                                    />
                                );
                            }
                        })}

                    </div>
                </section>
                <button onClick={handleNextSlide} >
                    <FontAwesomeIcon icon={faAngleRight} className="text-6xl text-white font-bold" />
                </button>
            </div>
        </div>


    );
};

Carousel.propTypes = {
    slides: PropTypes.array.isRequired,
    isPageBackground: PropTypes.bool,
};

export default Carousel;
