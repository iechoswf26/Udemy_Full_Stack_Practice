// Purpose: Define createContext(), Provider component, and any state/reducer logic.

import React, { useState, createContext } from 'react';

export const CardContext = createContext()

const CheckpointContext = () => {

    const [card, setCard] = useState(false)

    const handleClick = () => {
        setCard()
    }

    return (
        <CardContext.Provider value={card}>
            { children }
        </CardContext.Provider>
    )
}