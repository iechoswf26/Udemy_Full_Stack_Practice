const SignUpModal = () => {
    return (
        //     Global Container
        <div className="flex items-center justify-center min-h-screen">

            {/*    Card Container*/}
            <form action="" className="relative flex flex-col m-6 p-4 space-y-3 bg-white shadow-2xl">

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
                        />
                    </div>
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
                        />
                    </div>
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
                        />
                    </div>
                </div>


                {/* Bottom Buttons Container */}
                <div className="flex items-center justify-center space-x-3">

                    <button
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
    )
}

export default SignUpModal;