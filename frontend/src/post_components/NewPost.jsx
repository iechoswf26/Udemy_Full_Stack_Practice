import {useForm} from "react-hook-form";
import {yupResolver} from "@hookform/resolvers/yup";
import{object, string} from "yup";
import React, {useContext} from 'react';
import {CardContext} from "../context/CheckpointContext.jsx";

const NewPost = () => {

    const postSchema = object ({
        post: string()
            .max(250, "Cannot be more than 250 characters.")
            .required("This field is required.")
    })

    const {
        register,
        setValue,
        handleSubmit,
        reset,
        formState:{errors}
    } = useForm ({
        resolver: yupResolver(postSchema)
    })

    // Need context before submit.
    const checkpointContext = useContext(CardContext)
    if (!checkpointContext) {
        throw Error('Did not wrap in provider.')
    }
    const {submitPost} = checkpointContext

    const onSubmit = async (data) => {
        console.log(data)
        const validatedData = await postSchema.validate(data)
        submitPost(validatedData.post)
        reset()
    }

    const handleChange = (e) => {
        setValue(e.target.name, e.target.value)
    }

    return (
        <div className="flex flex-col items-center justify-center bg-gray-300 w-10/12 rounded-lg">

            <form onSubmit={handleSubmit(onSubmit)} className="w-11/12 space-y-3 my-10">

                <textarea
                    placeholder="Post here..."
                    className="w-full bg-white border-2 border-black rounded-lg text-xl placeholder:font-body placeholder:font-medium placeholder:text-xl p-3"
                    {...register("post")}
                    onChange={handleChange}
                />
                {errors.post && <span> {errors.post.message}</span>}

                <div className="flex justify-end">
                    <button
                        type={"submit"}
                        className="p-2 px-5 py-3 rounded-xl border-2 border-black bg-black text-white font-body text-xl hover:bg-white hover:text-black hover:border-2 hover:border-black hover:font-semibold" >Post</button>
                </div>

            </form>
        </div>
    )
}

export default NewPost;


