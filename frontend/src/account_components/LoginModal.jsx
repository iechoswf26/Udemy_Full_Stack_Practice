import {useContext} from "react";
import {CardContext} from "../context/CheckpointContext.jsx";
import {useForm} from "react-hook-form";
import {yupResolver} from "@hookform/resolvers/yup";
import {string, object} from "yup";

const LoginModal = ({loginModal, toggleModal}) => {

    const loginSchema = object({
        username: string()
            .required("This field is required.")

    })

    const {
        register,
        setValue,
        handleSubmit,
        reset,
        formState:{errors}
    } = useForm ({
        resolver: yupResolver(loginSchema)
    })

    const loginContext = useContext(CardContext);

    if (!loginContext) {
        throw Error("No provider.")
    }

    const {loginUser} = loginContext;

    const onSubmit = async (data) => {
        console.log(data)
        const validatedData = await loginSchema.validate(data)
        const loginDto ={
            username: validatedData.username
        }
        loginUser(loginDto)
        reset()
    }

    const handleChange = (e) => {
        setValue(e.target.name, e.target.value)
    }


    return (
        <>
            {loginModal &&
                //     Global Container
                <div
                    onClick={toggleModal}
                    className="flex items-center justify-center min-h-screen fixed inset-0 w-screen h-screen z-50 backdrop-blur-2xl">

                    {/*    Card Container*/}
                    <form onSubmit={handleSubmit(onSubmit)} onClick={e => e.stopPropagation()} className="relative flex flex-col m-6 p-4 space-y-3 bg-white shadow-2xl">

                        {/* Header */}
                        <div className="flex items-center justify-center border-2 border-black bg-black">
                            <h1 className="font-heading mb-5 text-2xl font-medium text-white">Login</h1>
                        </div>

                        {/* Username */}
                        <div>
                            <label htmlFor="username" className="font-heading font-semibold text-xl">Username</label>
                            <div className="w-full p-1">
                                <input
                                    // value={}
                                    type="text"
                                    name="username"
                                    id="username"
                                    className="w-full p-4 border border-gray-300 rounded-md placeholder:font-body placeholder:font-medium"
                                    placeholder="Enter username"
                                    {...register("username")}
                                    onChange={handleChange}
                                />
                            </div>
                        </div>


                        {/* Bottom Buttons Container */}
                        <div className="flex items-center justify-center space-x-3">

                            <button
                                onClick={toggleModal}
                                type="button"
                                value="cancel"
                                className="p-2 px-5 py-3 rounded-xl text-white bg-black border-2 border-black font-body text-xl hover:text-black hover:border-2 hover:border-black hover:bg-white hover:font-semibold"
                            >
                                Cancel
                            </button>

                            <button
                                type="submit"
                                value="submit"
                                className="p-2 px-5 py-3 rounded-xl border-2 border-orange-600 bg-orange-600 text-white font-body text-xl hover:bg-white hover:text-orange-600 hover:border-2 hover:border-orange-600 hover:font-semibold"
                            >
                                Login
                            </button>

                        </div>

                    </form>

                </div>
            }
        </>



    )
}

export default LoginModal;