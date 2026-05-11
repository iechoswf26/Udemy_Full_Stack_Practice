import {useForm} from "react-hook-form";
import {yupResolver} from "@hookform/resolvers/yup";
import{object, string} from "yup";


const NewPost = () => {

    const postSchema = object ({
        postArea: string()
            .max(250, "Cannot be more than 250 characters.")
            .required("This field is required.")
    })

    const {
        register,
        setValue,
        handleSubmit,
        reset,
        formState:{errors}
    } = useForm() ({
        resolver: yupResolver(postSchema)
    })

    const onSubmit = (data) => {
        console.log(data)
        reset()
    }

    const handleChange = (e) => {
        // console.log(`${e.target.name}: ${e.target.value}`)
        setValue(e.target.name, e.target.value)
    }

    return (
        <div className="flex flex-col items-center justify-center bg-gray-300 w-10/12 rounded-lg">

            <form onSubmit={handleSubmit(onSubmit)} className="w-11/12 space-y-3 my-10">

                <textarea
                    placeholder="Post here..."
                    className="w-full bg-white border-2 border-black rounded-lg text-xl placeholder:font-body placeholder:font-medium placeholder:text-xl p-3"
                    {...register("postArea")}
                    onChange={handleChange}
                />
                {errors.postArea && <span> {errors.postArea.message}</span>}

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


