import React from 'react';
import MothAndFern from "../assets/TLOU2_Moth_and_Fern.png";
import Carousel from 'react-bootstrap/Carousel';

const CarouselCard = () => {
    return (
        <Carousel.Item>
            <img src={MothAndFern} alt="Moth and Fern"/>
            <Carousel.Caption>
                <h3>Third slide label</h3>
                <p>
                    Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                </p>
            </Carousel.Caption>
        </Carousel.Item>
    );
};

export default CarouselCard;