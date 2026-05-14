import React, {useContext} from "react";
import {CardContext} from "../context/CheckpointContext.jsx";
import {useForm} from "react-hook-form";
import {yupResolver} from "@hookform/resolvers/yup";
import {string, object, date} from "yup";
const SignUpModal = ({signUpModal, toggleModal}) => {

    const today = new Date();
    const minDate = new Date(
        today.getFullYear() - 17,
        today.getMonth(),
        today.getDate()
    );

    const signUpSchema = object ({
        username: string().min(6, "Must be at least 6 characters!").max(30, "Must be less than 30 characters!").matches(/^[A-Za-z0-9_-]+$/),
        email: string().matches(/^[A-Za-z0-9._+%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$/),
        birthdate: date()
            .max(minDate, 'You must be at least 17 years old')
            .required('Age 17+')
    })

    const {
        register,
        setValue,
        handleSubmit,
        reset,
        formState:{errors}
    } = useForm ({
        resolver: yupResolver(signUpSchema)
    })

    const loginContext = useContext(CardContext);

    if (!loginContext) {
        throw Error("No provider.")
    }

    const {signUpUser} = loginContext;

    const onSubmit = async (data) => {
        console.log(data)
        const validatedData = await signUpSchema.validate(data)
        const formatted = validatedData.birthdate.toISOString().split('T')[0];
        const signUpDto = {
            username: validatedData.username,
            email: validatedData.email,
            birthDate: formatted
        }
        await signUpUser(signUpDto)
        reset()
    }

    const handleChange = (e) => {
        setValue(e.target.name, e.target.value)
    }

    return (


        <>
            {signUpModal &&
                //     Global Container
                <div
                    onClick={toggleModal}
                    className="flex items-center justify-center min-h-screen fixed inset-0 w-screen h-screen z-50 backdrop-blur-2xl">

                    {/*    Card Container*/}
                    <form onSubmit={handleSubmit(onSubmit)} onClick={e => e.stopPropagation()} className="relative flex flex-col m-6 p-4 space-y-3 bg-white shadow-2xl">

                        {/* Header */}
                        <div className="flex items-center justify-center border-2 border-black bg-black">
                            <h1 className="font-heading mb-5 text-2xl font-medium text-white">Sign Up</h1>
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
                            {errors.username && <span className="text-red-500" > {errors.username.message}</span>}

                        </div>

                        {/* Email */}
                        <div>
                            <label htmlFor="email" className="font-heading font-semibold text-xl">Email</label>
                            <div className="w-full p-1">
                                <input
                                    // value={}
                                    type="email"
                                    name="email"
                                    id="email"
                                    className="w-full p-4 border border-gray-300 rounded-md placeholder:font-body placeholder:font-medium"
                                    placeholder="Enter email"
                                    {...register("email")}
                                    onChange={handleChange}
                                />
                            </div>
                            {errors.email && <span className="text-red-500"> {errors.email.message}</span>}
                        </div>

                        {/* Birthdate */}
                        <div>
                            <label htmlFor="birthdate" className="font-heading font-semibold text-xl">Birthday</label>
                            <div className="w-full p-1">
                                <input
                                    // value={}
                                    type="date"
                                    name="birthdate"
                                    id="birthdate"
                                    className="w-full p-4 border border-gray-300 rounded-md placeholder:font-body placeholder:font-medium"
                                    {...register("birthdate")}
                                    onChange={handleChange}
                                />
                            </div>
                            {errors.birthdate && <span className="text-red-500"> {errors.birthdate.message}</span>}
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
                                Save
                            </button>

                        </div>

                    </form>

                </div>
            }
        </>



    )
}

export default SignUpModal;