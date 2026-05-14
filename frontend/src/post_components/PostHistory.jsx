
import React, {useContext, useEffect, useState} from 'react';
import {CardContext} from "../context/CheckpointContext.jsx";
import {yupResolver} from "@hookform/resolvers/yup";
import {object, string} from "yup";
import {useForm} from "react-hook-form";
const PostHistory = ({id, checkpointId, username, post, date, time}) => {

    const postSchema = object ({
        post: string()
            .max(250, "Cannot be more than 250 characters.")
    })


    const {
        register,
        setValue,
        handleSubmit,
        reset,
        watch,
        formState: {errors}
    } = useForm({
        defaultValues: {
            post: post
        },
        resolver: yupResolver(postSchema)
    })

    useEffect(()=>{
        reset({post : post})
    }, [post, reset])

    const onSubmit = async (data) => {
        console.log(data)
        const parsedData = await postSchema.validate(data);
        await savePost(parsedData.post)
        reset()
    }

    const handleChange = (e) => {
        setValue(e.target.name, e.target.value)
    }

    // Before applying useContext, need to make sure context exists and if there any values. See CheckpointContext.jsx -> export const CardContext = createContext() is currently null.
    const checkpointContext = useContext(CardContext)
    if (!checkpointContext) {
        throw Error
    }

    // Destructure the values of the Provider (deletePost) from CheckpointContext.
    const {deletePost, updatePost} = checkpointContext

    const [editButton, setEditButton] = useState(false);

    const toggleEdit = () => {
        setEditButton(!editButton)
    }

    const savePost = async (post) => {
        await updatePost (id, post)
        console.log("EDITED", post);
        toggleEdit()
    }

    return (



        <div className="flex flex-col items-center justify-center bg-gray-300 w-10/12 rounded-lg">

            <div className="w-11/12 space-y-3 my-10">

                {/* Username */}
                <div className="flex justify-between">
                    <p className="font-heading font-medium text-2xl">{username}</p>
                </div>
                <form onSubmit={handleSubmit(e => onSubmit(e))}>
                {/* Post */}
                {
                    editButton ?
                            <textarea
                                className="bg-white w-full text-xl rounded-lg"
                                onChange={handleChange}
                                {...register("post")}
                            ></textarea>
 :
                    <p className="w-full bg-white rounded-lg p-3 font-body font-medium text-xl">{post}</p>}


                <div className="flex justify-between">
                    <p className="font-body font-medium text-xl text-black"></p>

                    <div className="space-x-5">
                        <button
                            type={editButton ? "submit" : "button"}
                            onClick={!editButton ? (e) => {e.preventDefault(); toggleEdit()} : ()=>{}}
                            className="p-2 px-5 py-3 my-5 rounded-xl border-2 border-black bg-black text-white font-body text-xl hover:bg-white hover:text-black hover:border-2 hover:border-black hover:font-semibold">{editButton ? "Save" : "Edit"}</button>

                        <button onClick={() => deletePost(id)} className="p-2 px-5 py-3 rounded-xl border-2 border-black bg-black text-white font-body text-xl hover:bg-white hover:text-black hover:border-2 hover:border-black hover:font-semibold">Delete</button>
                    </div>

                </div>
                </form>

            </div>
        </div>

    )
}

export default PostHistory;