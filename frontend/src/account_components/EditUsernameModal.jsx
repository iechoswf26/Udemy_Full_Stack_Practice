const EditUsernameModal = () => {
    return (
    //     Global Container
        <div className="flex items-center justify-center min-h-screen">

        {/*    Card Container*/}
            <div className="relative flex flex-col m-6 p-4 space-y-3 bg-white shadow-2xl">

                {/* Header */}
                <div className="flex items-center justify-center border-2 border-black bg-black">
                    <h2 className="font-heading mb-5 text-2xl font-medium text-white">Edit Your Username</h2>
                </div>

                {/* Previous Username */}
                <div>
                    <h6 className="font-heading font-semibold text-xl">Current Username</h6>
                    <div className="w-full p-6">
                        <p className="font-body text-xl">[Old username goes here]</p>
                    </div>
                </div>

                {/* New Username */}
                <div>
                    <h6 className="font-heading font-semibold text-xl">New Username</h6>
                    <input
                        type="text"
                        className="w-full p-6 border border-gray-300 rounded-md placeholder:font-body placeholder:font-medium"
                        placeholder="Enter username"
                    />
                </div>

                {/* Bottom Buttons Container */}
                <div className="flex items-center justify-center space-x-3">

                    <button className="p-2 px-5 py-3 rounded-xl text-white bg-black border-2 border-black font-body text-xl hover:text-black hover:border-2 hover:border-black hover:bg-white hover:font-semibold">Cancel</button>

                    <button className="p-2 px-5 py-3 rounded-xl border-2 border-orange-600 bg-orange-600 text-white font-body text-xl hover:bg-white hover:text-orange-600 hover:border-2 hover:border-orange-600 hover:font-semibold">Save</button>

                </div>

            </div>

        </div>
    )
}

export default EditUsernameModal;