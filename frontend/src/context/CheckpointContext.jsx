import React, {useState, createContext, useEffect} from 'react';
import * as APIService from '../utilities/APIService.js'


export const CardContext = createContext()

export const CheckpointContext = ({ children }) => {

    const [chapters, setChapter] = useState([])
    const [checkpointId, setCheckpointId] = useState(JSON.parse(localStorage.getItem("checkpointId")))
    const [chapterId, setChapterId] = useState(JSON.parse(localStorage.getItem("chapterId")))
    const [currentCheckpoint, setCurrentCheckpoint] = useState();
    const updateCheckpoint = () => {
        if (!chapters || chapters.length === 0) return;
        console.log(chapters)
        let chapter;
        for (let i = 0; i < chapters.length; i++){
            if (chapters[i].id === chapterId){
                chapter = chapters[i];
                break;
            }
        }
        console.log(chapter)
        let checkpoint;
        for (let i = 0; i < chapter.checkpoints.length; i++){
            if (chapter.checkpoints[i].id === checkpointId){
                checkpoint = chapter.checkpoints[i];
            }

        }
        setCurrentCheckpoint(checkpoint);
    }
    const [postHistory, setPostHistory] = useState()
    const [userId, setUserId] = useState(JSON.parse(localStorage.getItem("userId")))

    const setNewCard = (slideObject) => {
        setCheckpointId(slideObject.checkpointId)
        setChapterId(slideObject.chapterId)
        localStorage.setItem("checkpointId", JSON.stringify(slideObject.checkpointId))
        localStorage.setItem("chapterId", JSON.stringify(slideObject.chapterId))
    }

    const chapterContent = async () => {
        const chapterResult = await APIService.axiosFindAllChapters()
        setChapter(chapterResult)
        console.log("CHAPTER: ", chapterResult)
    }

    useEffect( () => {
        chapterContent()
    }, []);

    useEffect(()=>{
        updateCheckpoint()
        console.log(checkpointId, chapterId)
    }, [checkpointId, chapterId, chapters])

    const submitPost = async (post) => {
        console.log(userId);
        const postRequest = {
            userId: userId,
            post : post,
            checkpointId : currentCheckpoint.id
        }
        await APIService.axiosSavePost(postRequest)
        await chapterContent()
    }

    const loginUser = async (username) => {
        console.log(username)
        const user = await APIService.axiosFindUserByUsername(username)
        setUserId(user.id)
        localStorage.setItem("userId", JSON.stringify(user.id));
        console.log(user.id)
    }

    const signUpUser = async (user) => {
        const saveUser = await APIService.axiosSaveUser(user)
        setUserId(saveUser.id)
        localStorage.setItem("userId", JSON.stringify(saveUser.id));
    }

    const deletePost = async (postId) => {

        await APIService.axiosDeleteExistingPost(userId, postId)
        await chapterContent();
    }

    const updatePost = async(postId, post) => {
        const postUpdateRequest = {
            userId: userId,
            postId : postId,
            post: post
        }
        await APIService.axiosUpdatePost(postUpdateRequest)
        await chapterContent()
    }



    return (
        <CardContext.Provider value={{currentCheckpoint, chapters, setNewCard, submitPost, loginUser, userId, signUpUser, setCheckpointId, setChapterId, deletePost, updatePost}}>
            { children }
        </CardContext.Provider>
    )
}