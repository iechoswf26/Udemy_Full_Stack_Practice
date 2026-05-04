// Purpose: Define createContext(), Provider component, and any state/reducer logic.

import React, {useState, createContext, useEffect} from 'react';

export const CardContext = createContext()

export const CheckpointContext = ({ children }) => {

    const [card, setCard] = useState(JSON.parse(localStorage.getItem("card")))

    const setNewCard = (slideObject) => {
        setCard(slideObject)
        localStorage.setItem("card", JSON.stringify(slideObject))
    }

    return (
        <CardContext.Provider value={{card, setNewCard}}>
            { children }
        </CardContext.Provider>
    )
}