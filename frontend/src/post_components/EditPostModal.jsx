const EditPostModal = () => {
    return (
        //     Global Container
        <div className="flex flex-col items-center justify-center min-h-screen">

            {/*    Card Container*/}
            <form action="" className="flex flex-col m-6 p-4 space-y-3 bg-white shadow-2xl">

                {/* Header */}
                <div className="flex items-center justify-center border-2 border-black bg-black">
                    <h1 className="font-heading mb-5 text-2xl font-medium text-white">Edit Your Post</h1>
                </div>

                {/* Previous Post */}
                <div>
                    <h2 className="font-heading font-semibold text-xl">Current Post</h2>
                    <div className="w-full p-1">
                        <p className="font-body text-xl">[Old post goes here]</p>
                    </div>
                </div>

                {/* New Username */}
                <div>
                    <label htmlFor="new-post" className="font-heading font-semibold text-xl">New Post</label>
                    <div className="w-full p-1">
                        <textarea
                            // value={}
                            id="new-post"
                            name="newPost"
                            className="w-full p-4 border border-gray-300 rounded-md placeholder:font-body placeholder:font-medium"
                            placeholder="Enter new post..."
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

export default EditPostModal;