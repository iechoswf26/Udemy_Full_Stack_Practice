import React, {useState, createContext, useEffect} from 'react';
import * as APIService from '../utilities/APIService.js'

export const CardContext = createContext()

export const CheckpointContext = ({ children }) => {

    const [card, setCard] = useState(JSON.parse(localStorage.getItem("card")))

    const [chapters, setChapter] = useState()
    const [postHistory, setPostHistory] = useState()

    const setNewCard = (slideObject) => {
        setCard(slideObject)
        localStorage.setItem("card", JSON.stringify(slideObject))
    }

    const chapterContent = async () => {
        const chapterResult = await APIService.axiosFindAllChapters()
        setChapter(chapterResult)
    }

    useEffect( () => {
        chapterContent()
    }, []);



    return (
        <CardContext.Provider value={{card, chapters, setNewCard}}>
            { children }
        </CardContext.Provider>
    )
}